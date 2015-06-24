package nightmare;

public class Dragon extends Flying {
    public Dragon() {
        BaseAttack = 100;
        Defence = 900;
    }

    @Override
    public int OrdinalAttack() {
        return BaseAttack;
    }

    @Override
    public int AirAttack() {
        return (int) (BaseAttack * 0.4);
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
        return (int) (Level * 70);
    }

    @Override
    public int BonusAttack() {
        return 0;
    }
}

