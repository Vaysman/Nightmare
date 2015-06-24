package nightmare;

import java.util.Random;

/// Класс для описания всех видов оружия. Оно может быть следующих типов:
/// - Дубина
/// - Меч
/// - Кинжал
/// - Посох
/// - Лук
public class Weapon extends Item {
    public int Attack;
    public boolean Bow;
    public boolean Dagger;
    public boolean Equiped;
    public int Id;
    public boolean Mace;
    public boolean Staff;
    public boolean Sword;

    public Weapon() {
        Type = "W";
    }

    /// В классе указывается, какой класс персонажа
    /// какой тип оружия может быть использован
    public boolean CanWearFor(Player player) {
        switch (player.clazz) {
            case "Warrior":
                Equiped = true;
                return true;
            case "Paladin":
                if (Mace || Sword || Dagger || Bow) {
                    Equiped = true;
                    return true;
                } else {
                    return false;
                }
            case "Wizard":
                if (!Staff) {
                    return false;
                } else {
                    Equiped = true;
                    return true;
                }
            case "Rouge":
                if (Dagger || Bow) {
                    Equiped = true;

                    return true;
                } else {
                    return false;
                }
            case "Barbarian":
                Equiped = true;

                return true;
        }

        return true;
    }
}

