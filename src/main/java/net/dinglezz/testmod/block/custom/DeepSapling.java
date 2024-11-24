package net.dinglezz.testmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dinglezz.testmod.util.ModTags;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class DeepSapling extends PlantBlock implements Fertilizable {
    public static final IntProperty STAGE = Properties.STAGE;
    public static final float field_31236 = 6.0F;
    public static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    public  SaplingGenerator generator = null;

    @Override
    public MapCodec<? extends SaplingBlock> getCodec() {
        return CODEC;
    }

    public DeepSapling(SaplingGenerator generator, Settings settings) {
        super(settings);
        this.generator = generator;
        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, Integer.valueOf(0)));
    }

    public final MapCodec<SaplingBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(SaplingGenerator.CODEC.fieldOf("tree").forGetter(saplingBlock -> this.generator), createSettingsCodec())
                    .apply(instance, SaplingBlock::new)
    );

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.generate(world, pos, state, random);
        }
    }


    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(ModTags.Blocks.IS_DEEP_PLANTABLE) || floor.isOf(Blocks.GRASS_BLOCK) || super.canPlantOnTop(floor, world, pos);
    }

    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if ((Integer)state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycle(STAGE), Block.NO_REDRAW);
        } else {
            this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)world.random.nextFloat() < 0.45;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.generate(world, pos, state, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
