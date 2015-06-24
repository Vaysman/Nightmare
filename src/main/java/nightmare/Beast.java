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
/// Существо может быть оглушено и получить штраф к защите в размере значения оглушения
public class Beast {
    public int IsFlying = 0;
    public int IsStomping = 0;
    public int IsPoison = 0;
    public int Life = 10;
    public int Stamina = 10;
    public int Xp = 3;
    public int Level = 1;
    public int BaseAttack = 1;
    public int Defence = 0;
    public String Name;
    public int Stunned;

    /// Может быть больше одной атаки за раз.
    /// Последовательно должны быть вычеслены Защита, Мощь, Спец.Атака
    /// от соответствующих базовых параметров.
    public List<Attack> GetAttacks() {
        Attack attack = new Attack(BaseAttack, 0, 0);

        int val = BaseAttack;

        if (IsFlying == 1) {
            val = val + (int) (Level *0.7);
        }
        attack.Special += val;

        if (IsFlying == 1) {
            val = (int) (Defence *1.2);
        }
        attack.Defence += val;

        if (IsStomping > 0) {
            val = attack.Power + IsStomping;
        }
        attack.Power = val;

        if (IsStomping > 0) {
            val = attack.Special + IsStomping;
        }
        attack.Special += val;

        if (IsStunned()) {
            val = Stunned;
        }
        attack.Defence -= val;

        // If beast with poison ability he can attack twice
        return IsPoison == 0 ? Arrays.asList(attack) : Arrays.asList(attack, attack);
    }

    /// Модификатор оглушения существа
    private boolean IsStunned() {
        return Stunned > 0;
    }
}

/// Класс для расчета повреждений во время боя
class Attack {
    public int Power;
    public int Defence;
    public int Special;

    public Attack(int power, int defence, int special) {
        this.Power = power;
        this.Defence = defence;
        this.Special = special;
    }
}

