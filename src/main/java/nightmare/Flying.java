package nightmare;

/// Если вражина летает, то он должен наследоваться от этого класса
/// с базовыми значениями для атаки и защиты
public abstract class Flying extends Enemy {
    protected Flying() {
        BaseAttack = 50;
        Defence = 200;
    }
}

class Lion extends Enemy {
    public Lion() {
        BaseAttack = 36;
        Defence = 45;
    }

    @Override
    public int AirAttack() {
        return 0;
    }

    @Override
    public int BonusAttack() {
        return (int) (BaseAttack * 0.5);
    }

    @Override
    public int OrdinalAttack() {
        return BaseAttack;
    }

    @Override
    public int OrdinalDefence() {
        return Defence;
    }

    @Override
    public int SpecialAttack() {
        return 0;
    }

    @Override
    public int SpecialDefence() {
        return 0;
    }

    @Override
    public int StunAttack() {
        return 0;
    }
}
