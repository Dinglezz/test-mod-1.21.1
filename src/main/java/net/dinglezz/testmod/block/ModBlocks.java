package net.dinglezz.testmod.block;

import net.dinglezz.testmod.block.custom.DeepSapling;
import net.dinglezz.testmod.block.custom.MagicBlock;
import net.dinglezz.testmod.block.custom.PinkGarnetLampBlock;
import net.dinglezz.testmod.sound.ModSounds;
import net.dinglezz.testmod.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.dinglezz.testmod.TestMod;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0).requiresTool()));



    public static final Block DEEPSlATE_GRASS = registerBlock("deepslate_grass",
            new GrassBlock(AbstractBlock.Settings.create().strength(3.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRASIN = registerBlock("grasin",
            new Block(AbstractBlock.Settings.create().strength(2.0F, 5.0F).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block DEEP_SAPLING = registerBlock("deep_sapling",
        new DeepSapling(ModSaplingGenerators.DEEP, AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.NYLIUM).nonOpaque()));

    public static final Block DEEP_LOG = registerBlock("deep_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).strength(4f)));
    public static final Block DEEP_WOOD = registerBlock("deep_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).strength(4f)));

    //public static final Block

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
