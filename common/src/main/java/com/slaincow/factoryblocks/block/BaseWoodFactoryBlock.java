package com.slaincow.factoryblocks.block;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.BooleanProperty;

import static com.slaincow.factoryblocks.FactorySound.FACTORY_BLOCKS;

public class BaseWoodFactoryBlock extends Block
{
    public static final BooleanProperty ON = BooleanProperty.of("on");
    public BaseWoodFactoryBlock(Settings settings)
    {
        super(settings.strength(2.0f).sounds(BlockSoundGroup.WOOD));
    }
}
