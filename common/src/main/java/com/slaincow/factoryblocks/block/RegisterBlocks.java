package com.slaincow.factoryblocks.block;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.slaincow.factoryblocks.TooltipBlockItem;
import com.slaincow.factoryblocks.block.fan.*;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

import static com.slaincow.factoryblocks.FactoryBlocksMod.MODID;

public class RegisterBlocks
{
    public static ArrayList<Identifier> TRANSPARENT_BLOCKS = new ArrayList<Identifier>();
    public static final Supplier<Registries> MANAGER = Suppliers.memoize(() -> Registries.get(MODID));

    enum Type {
        base,
        baseFan,
        redFan,
        mediumFan,
        transparentBase,
        transparentFan,
        transparentRedFan
    }

    private static void addFactoryBlock(String nameID, Type type)
    {
        addFactoryBlock(nameID, type, true);
    }

    public static ArrayList<RegistrySupplier<Item>> itemSuppliers = new ArrayList<>();

    private static void addFactoryBlock(String nameID, Type type, boolean include)
    {
        Identifier blockID = new Identifier(MODID, nameID);

        Registrar<Block> blocks = MANAGER.get().get(Registry.BLOCK_KEY);
        RegistrySupplier<Block> blockSupplier;

        switch (type) {
            default -> blockSupplier = blocks.register(blockID, () -> new BaseFactoryBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case baseFan -> blockSupplier = blocks.register(blockID, () -> new BaseFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case redFan -> blockSupplier = blocks.register(blockID, () -> new RedstoneFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case mediumFan -> blockSupplier = blocks.register(blockID, () -> new MediumFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case transparentBase -> blockSupplier = blocks.register(blockID, () -> new BaseTransparentFactoryBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case transparentFan -> blockSupplier = blocks.register(blockID, () -> new TransparentBaseFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case transparentRedFan -> blockSupplier = blocks.register(blockID, () -> new TransparentRedstoneFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        }

        Registrar<Item> items = MANAGER.get().get(Registry.ITEM_KEY);
        itemSuppliers.add(items.register(blockID, () -> new TooltipBlockItem(blockSupplier.get(), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS), nameID + ".tooltip")));

        if (type == Type.transparentBase || type == Type.transparentFan || type == Type.transparentRedFan)
        {
            TRANSPARENT_BLOCKS.add(blockID);
        }
    }

    public static void register()
    {
        addFactoryBlock("factory", Type.base);
        addFactoryBlock("rust", Type.base);
        addFactoryBlock("vrust", Type.base);
        addFactoryBlock("srust", Type.base);
        addFactoryBlock("wireframe", Type.base);
        addFactoryBlock("pwireframe", Type.base);
        addFactoryBlock("hazard", Type.base);
        addFactoryBlock("hazardo", Type.base);
        addFactoryBlock("circuit", Type.base);
        addFactoryBlock("metalbox", Type.base);
        addFactoryBlock("gcircuit", Type.base);
        addFactoryBlock("pgcircuit", Type.base);
        addFactoryBlock("grinder", Type.base);
        addFactoryBlock("old_vents", Type.base);
        addFactoryBlock("rust_plates", Type.base);
        addFactoryBlock("bcircuit", Type.base);
        addFactoryBlock("ice", Type.base);
        addFactoryBlock("mosaic", Type.base);
        addFactoryBlock("bwireframe", Type.base);
        addFactoryBlock("rusty_scaffold", Type.base);
        addFactoryBlock("caution", Type.base);
        addFactoryBlock("large_pipes", Type.base);
        addFactoryBlock("small_pipes", Type.base);
        addFactoryBlock("vent", Type.base);
        addFactoryBlock("gvent", Type.base);
        addFactoryBlock("insulation", Type.base);
        addFactoryBlock("gears", Type.base);
        addFactoryBlock("cables", Type.base);
        addFactoryBlock("rust_bplates", Type.base);
        addFactoryBlock("grate", Type.base);
        addFactoryBlock("rgrate", Type.base);
        addFactoryBlock("hex", Type.base);
        addFactoryBlock("wgpanel", Type.base);
        addFactoryBlock("wopanel", Type.base);
        addFactoryBlock("sturdy", Type.base);
        addFactoryBlock("megacell", Type.base);
        addFactoryBlock("exhaust", Type.base);
        addFactoryBlock("engineer", Type.base);
        addFactoryBlock("scaffold", Type.base);
        addFactoryBlock("piping", Type.base);
        addFactoryBlock("large_plating", Type.base);
        addFactoryBlock("fan_side", Type.base);

        addFactoryBlock("fan_on", Type.baseFan);
        addFactoryBlock("fan_four_on", Type.baseFan);
        addFactoryBlock("fan_malfunction_on", Type.baseFan);

        addFactoryBlock("fan", Type.redFan);
        addFactoryBlock("fan_four", Type.redFan);
        addFactoryBlock("fan_malfunction", Type.redFan);

        addFactoryBlock("medium_fan", Type.mediumFan, false);
        addFactoryBlock("vertical_vent", Type.base);
        addFactoryBlock("tape_drive", Type.base);
        addFactoryBlock("metal_column", Type.base);
        addFactoryBlock("industrial_relic", Type.base);
        addFactoryBlock("scaffold_transparent", Type.transparentBase, true);

        addFactoryBlock("fan_four_transparent", Type.transparentRedFan);
        addFactoryBlock("fan_four_transparent_on", Type.transparentFan);
    }
}
