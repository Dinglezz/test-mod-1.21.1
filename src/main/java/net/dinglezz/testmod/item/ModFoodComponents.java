package net.dinglezz.testmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent STARLIGHT_ASHES = new FoodComponent.Builder().nutrition(6).saturationModifier(1.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER,300), 0.80f).build();
}
