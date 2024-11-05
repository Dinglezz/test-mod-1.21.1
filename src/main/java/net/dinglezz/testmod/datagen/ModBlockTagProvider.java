package net.dinglezz.testmod.datagen;

import net.dinglezz.testmod.block.ModBlocks;
import net.dinglezz.testmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE)
                .add(ModBlocks.MAGIC_BLOCK)
                .add(ModBlocks.PINK_GARNET_BUTTON)
                .add(ModBlocks.PINK_GARNET_DOOR)
                .add(ModBlocks.PINK_GARNET_TRAPDOOR)
                .add(ModBlocks.PINK_GARNET_LAMP)
                .add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PINK_GARNET_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
