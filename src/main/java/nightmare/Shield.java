package nightmare;

/// Все щиты описываются этим классом
public class Shield extends Item{
    public int id;
    public int Defence;

    public boolean Equiped;

    public Shield() {
        Type = "S";
    }

    /// Определяет, может ли персонаж использовать щит
    public boolean CanWearFor(Player player) {
        return true;
    }
}
