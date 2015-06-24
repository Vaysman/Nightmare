package nightmare;

import java.util.Arrays;
import java.util.List;

/// Базовый класс для всех типов существ с которым будет сражаться главный герой
/// Класс содержит все данные, которые учитываются при расчете защиты и атаки.
///
/// Существа могут быть летающими, ядовитыми, а так же с "пробивным" ударом.
/// Все эти свойства могут комбинироваться в произвольном порядке и проявится все
/// вместе в одном существе.
///
/// Класс задает некоторые базовые значения для чудовища 1го уровня.
///
/// Может быть оглушен и получить штраф к защите в размере оглушения. Может сам оглушать
/// специальной атакой.
public abstract class Enemy {
    public int BaseAttack = 1;
    public int Defence = 0;
    public int Level = 1;
    public int Life = 10;
    public int Name;
    public int Stamina = 10;
    public int Xp = 3;

    /// Расчет структуры защиты, мощи и спец.ударов для выяснения
    /// кто круче, герой-задохлик или же этот красавец.
    public List<Attack> attacks() {
        return Arrays.asList(
                new Attack(
                        OrdinalAttack() + AirAttack() + StunAttack(),
                        OrdinalDefence() + SpecialDefence(),
                        SpecialAttack() + BonusAttack()
                )
        );
    }

    // Методы должны быть переопределены в наследниках,
    // чтобы можно было рассчитать структуру для выяснения того,
    // кто круче
    public abstract int OrdinalAttack();

    public abstract int AirAttack();

    public abstract int StunAttack();

    public abstract int OrdinalDefence();

    public abstract int SpecialDefence();

    public abstract int SpecialAttack();

    public abstract int BonusAttack();
}
