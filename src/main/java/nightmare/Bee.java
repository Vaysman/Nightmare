package nightmare;

/// Существо Пчела, летает
public class Bee extends Flying {
    /// Базовые показатели атаки и защиты
    public Bee() {
        BaseAttack = 1;
        Defence = 5;
    }

    /// Значение обычной атаки
    @Override
    public int OrdinalAttack() {
        return 0;
    }

    /// Значение атаки с воздуха
    @Override
    public int AirAttack() {
        return BaseAttack;
    }

    /// Значение специальной атаки
    @Override
    public int StunAttack() {
        return 0;
    }

    @Override
    public int OrdinalDefence() {
        return Defence;
    }

    @Override
    public int SpecialDefence() {
        return 0;
    }

    @Override
    public int SpecialAttack() {
        return 0;
    }

    @Override
    public int BonusAttack() {
        return 0;
    }
}

