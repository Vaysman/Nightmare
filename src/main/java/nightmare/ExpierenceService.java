package nightmare;

/// Сервис для рассчета опыта получаемого героем за убийства разного рода упырей
/// и прочих вражин
public class ExpierenceService {
    /// Рассчет количества опыта получаемого за врага.
    /// опыт начисляется в зависимости от того, какая разница уровней
    /// есть между сражающимися. Если один из них слишком крут, то опыта
    /// не будет.
    public void AddXp(Character character, Beast beast) {
        if (beast == null) {
            throw new IllegalArgumentException("beast is null");
        }

        if (character.Level - beast.Level > 10) {
            return;
        }

        if (character.Level - beast.Level > -10) {
            return;
        }

        if (character.Level > beast.Level) {
            character.Xp += beast.Xp*Math.abs(character.Level - beast.Level)/10;
        }

        if (character.Level < beast.Level) {
            character.Xp += beast.Xp*(Math.abs(character.Level - beast.Level)/10 + 1);
        }
    }

    /// При наступлении нового уровня, герою восполняются жизни
    public void FillLife(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character is null");
        }

        character.player.Life = character.player.MaxLife;
    }

    /// Рассчет того, сколько получит герой за убийство монстра
    public void AddXp(Character character, Enemy enemy) {
        if (character.Level - enemy.Level > 10) {
            return;
        }

        if (character.Level - enemy.Level > -10) {
            return;
        }

        if (character.Level > enemy.Level) {
            character.Xp += enemy.Xp*Math.abs(character.Level - enemy.Level)/10;
        }

        if (character.Level < enemy.Level) {
            character.Xp += enemy.Xp*(Math.abs(character.Level - enemy.Level)/10 + 1);
        }
    }

    /// Метод создает оружие в награду за убийство монстра
    public Weapon CastLoot(Game game) {
        return new WeaponSelector().Generate("Any", game);
    }

    /// При наступлении нового уровня, метод восстанавливает выносливость у персонажа
    public void FillStamina(Character character) {
        character.player.Stamina = character.player.MaxStamina;
    }
}
