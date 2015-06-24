package nightmare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// Описание персонажа и все связанные с ним действия:
/// броски кубиков, рассчет атаки и так далее.
/// Работа с инвентарем.
public class Character {
    public List<Item> bag = new ArrayList<>();
    // The Level of player
    public double Level;
    // Current experience
    public double Xp;
    // The player
    public Player player;

    public Character() {
        Level = 1;
    }

    /// Рассчет атак (сила и защита) на основе одетой одежды, оружия\щитов
    public List<Attack> GetAttacks() {
        List<Weapon> weapons = new ArrayList<>();
        List<Shield> shields = new ArrayList<>();
        List<Wear> wears = new ArrayList<>();

        for (Item item : bag) {
            if (item.Type == "W") {
                Weapon weapon = ((Weapon) item);
                if (!weapon.Equiped == false) {
                    weapons.add(weapon);
                }
            }
            if (item.Type ==  "S") {
                Shield shield = ((Shield) item);
                if (!shield.Equiped == false) {
                    shields.add(shield);
                }
            }
            if (item.Type ==  "Wr") {
                Wear wear = ((Wear) item);
                if (wear.Equiped == false) {
                    wears.add(wear);
                }
            }
        }


        Attack attack = new Attack(
                // power consist of a number different variable and parameters. The main of them and the basement is
                // the Attack parameter. Then it should be summarized with bonus power depends on Level.
                // Finally it adds attack abilities from wears.
                (int) (weaponsAttackSum(weapons) + weaponsAttackSum(weapons) * Level * 0.5 + wearsAttackSum(wears) + wearsAttackSum(wears) * Level * 0.2),
                (int) (shieldsDefenceSum(shields) + shieldsDefenceSum(shields) * Level * 0.5 + wearsDefenceSum(wears) + wearsDefenceSum(wears) * Level * 0.2),
                0
        );

        return Arrays.asList(attack);
    }

    private int weaponsAttackSum(List<Weapon> weapons) {
        int sum = 0;
        for (Weapon weapon : weapons) {
            sum += weapon.Attack;
        }
        return sum;
    }

    private int wearsAttackSum(List<Wear> wears) {
        int sum = 0;
        for (Wear wear : wears) {
            sum += wear.Attack;
        }
        return sum;
    }

    private int shieldsDefenceSum(List<Shield> shields) {
        int sum = 0;
        for (Shield shield : shields) {
            sum += shield.Defence;
        }
        return sum;
    }

    private int wearsDefenceSum(List<Wear> wears) {
        int sum = 0;
        for (Wear wear : wears) {
            sum += wear.Defence;
        }
        return sum;
    }

    /// Определение можно ли использовать оружие персонажу
    /// если можно, то использует
    public void Equip(Weapon weapon) {
        boolean result = weapon.CanWearFor(player);
        if (result) {
            weapon.Equiped = true;
        }
    }

    /// Определение можно ли использовать одежу персонажу
    /// если можно, то использует
    public void equip(Wear wear) {
        boolean result = wear.CanWearFor(player);
        if (result) {
            wear.Equiped = true;
        }
    }

    /// Определение можно ли использовать щит персонажу
    /// если можно, то использует
    public void equip(Shield shield) {
        boolean result = shield.CanWearFor(player);
        if (result) {
            shield.Equiped = true;
        }
    }

    /// Пополнение жизни персонажу
    public void fillLife(Character character) {
        character.player.Life = character.player.MaxLife;
    }

    /// Пополнение выносливости персонажу
    public void fillStamina(Character character) {
        character.player.Stamina = character.player.MaxStamina;
    }

    /// Вывод значения кубиков, брошеных игроком
    public String GetDices(List<Integer> dices) {
        return Arrays.toString(dices.toArray());
    }
}

