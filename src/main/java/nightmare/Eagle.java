package nightmare;

public class Eagle extends Flying {
    public Eagle() {
        BaseAttack = 10;
        Defence = 50;
    }

    @Override
    public int OrdinalAttack() {
        return 0;
    }

    @Override
    public int AirAttack() {
        return BaseAttack;
    }

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

