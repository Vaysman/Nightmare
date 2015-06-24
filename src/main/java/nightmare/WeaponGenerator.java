package nightmare;

import java.util.Random;

/// Класс для создания оружия с поправкой на уровень персонажа
public class WeaponGenerator {
    public Weapon Generate(Character character) {
        Random random = new Random();
        Weapon weapon = new Weapon();

        int value = random.nextInt(5);
        switch (value) {
            case 0:
                weapon.Mace = true;
                break;
            case 1:
                weapon.Sword = true;
                break;
            case 2:
                weapon.Dagger = true;
                break;
            case 3:
                weapon.Staff = true;
                break;
            case 4:
                weapon.Bow = true;
                break;
            default:
                throw new IllegalArgumentException("Unreachable code");
        }

        value = (int) (random.nextInt(10) * character.Level);
        weapon.Attack = value;

        return weapon;
    }
}
