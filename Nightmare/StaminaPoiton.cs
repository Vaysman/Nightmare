﻿namespace Nightmare
{
    // Пузырек для восстановления выносливости
    public class StaminaPoiton : Item{
        public void Use(Character character)
        {
            new ExpierenceService().FillStamina(character);
        }
    }
}