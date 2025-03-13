package com.bleudev.unknown.item;

import com.bleudev.unknown.UnknownMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item UNKNOWN_ITEM = registerItem("unknown_item", new Item(new Item.Settings()), ModItemGroups.UNKNOWN_ITEMS_GROUP_KEY);
    public static final Item UNKNOWN_ITEM_2 = registerItem("unknown_item_2", new Item(new Item.Settings()), ModItemGroups.UNKNOWN_ITEMS_GROUP_KEY);

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(UnknownMod.MOD_ID, id), item);
    }
    private static Item registerItem(String id, Item item, RegistryKey<ItemGroup> itemGroup) {
        Item registeredItem = Registry.register(Registries.ITEM, Identifier.of(UnknownMod.MOD_ID, id), item);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        return registeredItem;
    }

    public static void register() {
        UnknownMod.LOGGER.debug("Register item for " + UnknownMod.MOD_ID);
    }
}
