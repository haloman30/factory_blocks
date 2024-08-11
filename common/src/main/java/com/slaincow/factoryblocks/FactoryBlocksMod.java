package com.slaincow.factoryblocks;

import com.google.common.base.Supplier;
import com.slaincow.factoryblocks.block.RegisterBlocks;
import com.slaincow.factoryblocks.optional.ChiselSupport;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static com.slaincow.factoryblocks.block.RegisterBlocks.itemSuppliers;

public class FactoryBlocksMod
{
	public static final String MODID = "factory_blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static void init()
	{
		RegisterBlocks.register();
	}

	public static void post(boolean chisel)
	{
		Registrar<Block> blocks = Registries.get(MODID).get(Registry.BLOCK_KEY);

		for (Identifier block_id : RegisterBlocks.TRANSPARENT_BLOCKS)
		{
			Block block = blocks.get(block_id);

			if (block == null)
			{
				continue;
			}

			RenderTypeRegistry.register(RenderLayer.getTranslucent(), block);
		}

		if (chisel)
		{
			for (RegistrySupplier<Item> supplier : RegisterBlocks.itemSuppliers)
			{
				if (!RegisterBlocks.EXCLUDED_BLOCKS.contains(supplier.getId()))
				{
					ChiselSupport.addFactoryBlockToChisel(supplier.get().arch$registryName());
				}
			}
		}
	}
}
