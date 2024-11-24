package net.dinglezz.testmod.world.gen;

import net.dinglezz.testmod.world.ModPlacedFeatures;
import net.dinglezz.testmod.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.TEST_BIOME),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DEEP_TREE_PLACED_KEY);
    }
}
