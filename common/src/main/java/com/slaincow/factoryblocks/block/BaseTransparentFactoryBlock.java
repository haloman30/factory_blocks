package com.slaincow.factoryblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.TransparentBlock;
import net.minecraft.state.property.BooleanProperty;

import static com.slaincow.factoryblocks.FactorySound.FACTORY_BLOCKS;

public class BaseTransparentFactoryBlock extends TransparentBlock
{
    public static final BooleanProperty ON = BooleanProperty.of("on");

    public BaseTransparentFactoryBlock(Settings settings)
    {
        super(settings.strength(2.0f).sounds(FACTORY_BLOCKS).nonOpaque());
    }
}
