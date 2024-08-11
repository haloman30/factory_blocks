package com.slaincow.factoryblocks.block.fan;

import com.slaincow.factoryblocks.block.BaseFactoryBlock;
import com.slaincow.factoryblocks.block.BaseTransparentFactoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class TransparentBaseFanBlock extends BaseTransparentFactoryBlock
{
    public TransparentBaseFanBlock(Settings settings)
    {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.EAST));
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        try {
            return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerLookDirection().getOpposite());
        } catch (Exception e) {
            // idk why this happens gg
            return this.getDefaultState();
        }
    }
}
