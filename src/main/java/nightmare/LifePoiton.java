package nightmare;

/// Пузырёк для восстановления жизни. Всей.
public class LifePoiton extends Item {
    public void Use(Character character) {
        new ExpierenceService().FillLife(character);
    }
}
