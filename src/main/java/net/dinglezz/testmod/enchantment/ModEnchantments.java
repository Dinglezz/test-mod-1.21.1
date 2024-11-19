package net.dinglezz.testmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.dinglezz.testmod.TestMod;
import net.dinglezz.testmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(TestMod.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        TestMod.LOGGER.info("Registering Mod Enchantments for " + TestMod.MOD_ID);
    }
}
