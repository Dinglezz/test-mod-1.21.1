package net.dinglezz.testmod.world.tree;

import net.dinglezz.testmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DEEP =
            new SaplingGenerator("deep", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.DEEP_TREE_KEY),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
