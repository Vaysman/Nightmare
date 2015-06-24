package nightmare;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/// Класс ответственный за коммуникацию между разными
/// частями и механиками игры.
public class Game {
    public Character Character;
    private List<Attack> beastAttack;
    private List<Attack> charAttack;

    /// Бросок костей для монстра, в зависимости от уровня
    public List<Integer> AiDice(Beast beast) {
        List<Integer> ints = new ArrayList<>();
        Random random = new Random();

        int rolls = beast.Level;
        for (int i = 0; i < rolls; i++) {
            ints.add(random.nextInt(6) + 1);
        }

        return ints;
    }

    /// Создание различных областей игры, по которым будет путешествовать персонаж
    public Area CreateArea(String name, AreaType areaType, boolean IsFightArea, boolean IsMerchArea, boolean IsSecretArea, boolean IsTravelArea, boolean IsQuestArea, int discoverXp) {
        if (name == "" || name == null) {
            throw new IllegalArgumentException("Name should be filled");
        }

        Area area = new Area();
        area.name = name;
        area.areaType = areaType;
        area.discoverXp = discoverXp;
        area.isFightArea = IsFightArea;
        area.isMerchArea = IsMerchArea;
        area.isSecretArea = IsSecretArea;
        area.IsQuestArea = IsQuestArea;
        area.IsTravelArea = IsTravelArea;
        area.Undiscovered = true;
        area.game = this;
        return area;
    }

    /// Бросок кубиков для игрока. Количество кубиков рассчитывается на основе
    /// параметров игрока.
    public List<Integer> Dices(Player player) {
        int rolls = 2;
        if (player.Stats.get(6) > 5) {
            rolls += 1;
        }
        if (player.Stats.get(6) > 15 && player.Stats.get(1) > 10) {
            rolls += 2;
        }
        if (player.Stats.get(6) > 25 && player.Stats.get(4) > 20) {
            rolls += 3;
        }

        List<Integer> ints = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < rolls; i++) {
            ints.add(random.nextInt(6) + 1);
        }

        return ints;
    }

    /// Битва между персонажем и чудовищем
    public void Fight(Character character, Beast beast) {
        charAttack = character.GetAttacks();
        beastAttack = beast.GetAttacks();
    }

    /// Игрок получает новый уровень. Задается количество очков для увеличения
    /// характеристик. Жизнь и выносливость растут согласно коэффициентам
    /// класса персонажа
    public void LevelUp(Character character, Form1 form1) {
        character.player.LevelPoints = 5;
        character.player.Life = character.player.Life + character.player.Life * (int) Player.LIFE.get(character.player.clazz).get(0).intValue();
        character.player.Stamina = character.player.Stamina + character.player.Life * (int) Player.LIFE.get(character.player.clazz).get(1).intValue();

        form1.NewLevel();
    }

    /// Рассчет одного хода битвы
    /// В зависимости от того, у кого круче уровень, будет по разному рассчитаны коэффициенты атаки и защиты,
    /// соответственно и урона.
    /// Далее сравниваются атака и защита борющихся и в зависимости от этого опять же меняются коэффициенты.
    public void Turn(Character character, Beast beast, List<Integer> charDices, List<Integer> beastDices) {
        if (character.Level > beast.Level) {
            if (charAttack.size() >= beastAttack.size()) {
                for (int i = 0; i < charAttack.size(); i++) {
                    if (charAttack.get(i).Power > beastAttack.get(i).Defence) {
                        if (countDiceWithPoints(charDices, 6) >= 1) {
                            beast.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.4);
                        } else {
                            if (countDiceWithPoints(charDices, 5) >= 2) {
                                beast.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.6);
                            }
                            if (countDiceWithPoints(charDices, 5) >= 1) {
                                beast.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.8);
                            }
                        }
                    }

                    if (charAttack.get(i).Power < beastAttack.get(i).Defence) {
                        if (countDiceWithPoints(charDices, 6) >= 2) {
                            beast.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.5);
                        } else {
                            if (countDiceWithPoints(charDices, 5) < 0) {
                                character.player.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.8);
                            }
                            if (countDiceWithPoints(charDices, 5) < 2) {
                                beast.Life -= charAttack.get(i).Power - (int) (beastAttack.get(i).Defence * 0.4);
                            }
                        }
                    }
                }
            }
        }

        if (beast.Life <= 0) {
            new ExpierenceService().AddXp(character, beast);
        }
    }

    private int countDiceWithPoints(List<Integer> dices, int points) {
        int count = 0;
        for (Integer dice : dices) {
            if (dice == points) {
                count++;
            }
        }
        return count;
    }
}

