package nightmare;

/// Класс противника
public class Wolf extends Enemy {
    public Wolf() {
        BaseAttack = 15;
        Defence = 30;
    }

    @Override
    public int OrdinalAttack() {
        return BaseAttack;
    }

    @Override
    public int AirAttack() {
        return 0;
    }

    @Override
    public int SpecialAttack() {
        return 0;
    }

    @Override
    public int StunAttack() {
        return 0;
    }

    @Override
    public int BonusAttack() {
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
}
