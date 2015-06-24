package nightmare;

/// Базоый класс для всех типов одежды для персонажа.
/// Одёжа может быть как для защиты, так и добавлять бонусов к атаке.
/// Например пинок сабатоном чувствительнее пинка мокасином
public class Wear extends Item {
    public int id;
    public int Attack;
    public int Defence;

    public boolean Equiped;

    public Wear() {
        Type = "Wr";
    }

    /// Метод определяет может ли персонаж одеть конкретную одежку
    public boolean CanWearFor(Player player) {
        return true;
    }
}
