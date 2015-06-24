package nightmare;

/// Генерация и выбор оружия для персонажа на основе переданных параметров
public class WeaponSelector {
    private Weapon weapon;

    /// Генерация и выбор оружия для персонажа на основе переданных параметров.
    /// Если передается Any, то генерируем любое оружие. Если передается конкретный тип,
    /// то генерируем до тех пор, пока не попадется нужный тип оружия
    public Weapon Generate(String name, Game game) {
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        boolean flag = true;

        if (name == "Any") {
            return weaponGenerator.Generate(game.Character);
        }

        do {
            weapon = weaponGenerator.Generate(game.Character);
            if (weapon.Mace) {
                flag = name.toLowerCase() == "mace";
            }
            if (weapon.Sword) {
                flag = name.toLowerCase() == "sword";
            }
            if (weapon.Dagger) {
                flag = name.toLowerCase() == "dagger";
            }
            if (weapon.Staff) {
                flag = name.toLowerCase() == "staff";
            }
            if (weapon.Bow) {
                flag = name.toLowerCase() == "bow";
            }
        } while (!flag);

        return weapon;
    }
}
