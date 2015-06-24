package nightmare;

public class Skeleton extends Beast {
    public Skeleton() {
        super.BaseAttack = 13;
        super.Defence = 20;
        super.Name = "Thursty Skelet";
    }
}

class SkeletonArcher extends Skeleton {
    public SkeletonArcher() {
        Name = "Skeleton Archer";
        BaseAttack = 12;
    }
}