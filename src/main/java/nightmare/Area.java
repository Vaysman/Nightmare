package nightmare;

import java.util.ArrayList;
import java.util.List;

// Класс содержит информацию об области где находится главный герой.
// В зависимости от типа области накладываются штрафы или бонусы на героя
// (так же зависят от способностей героя)
// Область может быть только одной специализации.
public class Area {
    public String name;
    public AreaType areaType;
    /// обозначает враждебную область. всегда.
    public boolean isFightArea;
    /// зона торговли или нет
    public boolean isMerchArea;
    /// является ли это скрытой областью, которая открывается спец.средствами
    public boolean isSecretArea;
    /// является ли эта область проходной для путешественника, где не обязательно
    /// будут стычки с врагами
    public boolean IsTravelArea;
    /// Является ли область выделенной под квест и попасть туда можно только
    /// взяв и выполняя определенный квест
    public boolean IsQuestArea;
    /// количество опыта герою за открытие зоны
    public int discoverXp;

    public boolean Undiscovered;
    private Character character;

    public Game game;

    /// Обработка логики вхождения игрока в игровую зону
    public void PlayerEnter(Character character) {
        Undiscovered = false;
        this.character = character;
        // тут должна быть реализация
    }

    public void GenerateBeasts() {

    }

    public void StartFight() {
        List<Beast> beasts = new ArrayList<>();
        game.Fight(character, beasts.get(0));
        while (beasts.get(0).Life > 0 || character.player.Life > 0) {
            game.Turn(character, beasts.get(0), game.Dices(character.player), game.AiDice(beasts.get(0)));
        }

    }
}
