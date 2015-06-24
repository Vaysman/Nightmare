package nightmare;

// Пузырек для восстановления выносливости
public class StaminaPoiton extends Item {
    public void Use(Character character) {
        new ExpierenceService().FillStamina(character);
    }
}
