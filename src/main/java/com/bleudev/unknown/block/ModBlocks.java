package com.bleudev.unknown.block;

import com.bleudev.unknown.UnknownMod;
import com.bleudev.unknown.item.ModItemGroups;
import com.bleudev.unknown.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block UNKNOWN_BLOCK = registerBlock("unknown_block", new Block(Block.Settings.copy(Blocks.GRASS_BLOCK)), ModItemGroups.UNKNOWN_ITEMS_GROUP_KEY);
    public static final Block UNKNOWN_BLOCK_2 = registerBlock("unknown_block_2", new Block(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK)), ModItemGroups.UNKNOWN_ITEMS_GROUP_KEY);

    private static Block registerBlock(String id, Block block) {
        ModItems.registerItem(id, new BlockItem(block, new Item.Settings()));

        UnknownMod.LOGGER.debug("Registering block " + UnknownMod.MOD_ID + "." + id);
        var registeredBlock = Registry.register(Registries.BLOCK, Identifier.of(UnknownMod.MOD_ID, id), block);
        UnknownMod.LOGGER.debug("Registered block " + UnknownMod.MOD_ID + "." + id);
        return registeredBlock;
    }
    private static Block registerBlock(String id, Block block, RegistryKey<ItemGroup> itemGroup) {
        ModItems.registerItem(id, new BlockItem(block, new Item.Settings()), itemGroup);
        return Registry.register(Registries.BLOCK, Identifier.of(UnknownMod.MOD_ID, id), block);
    }
    public static void register() {
        UnknownMod.LOGGER.debug("Registering blocks for " + UnknownMod.MOD_ID);
    }
}
