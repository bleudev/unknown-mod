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

    public static Item registerItem(String id, Item item) {
        UnknownMod.LOGGER.debug("Registering item " + UnknownMod.MOD_ID + "." + id);
        Item registeredItem = Registry.register(Registries.ITEM, Identifier.of(UnknownMod.MOD_ID, id), item);
        UnknownMod.LOGGER.debug("Registered item " + UnknownMod.MOD_ID + "." + id);
        return registeredItem;
    }
    public static Item registerItem(String id, Item item, RegistryKey<ItemGroup> itemGroup) {
        UnknownMod.LOGGER.debug("Registering item " + UnknownMod.MOD_ID + "." + id);
        Item registeredItem = Registry.register(Registries.ITEM, Identifier.of(UnknownMod.MOD_ID, id), item);
        UnknownMod.LOGGER.debug("Registered item " + UnknownMod.MOD_ID + "." + id);

        UnknownMod.LOGGER.debug("Adding item " + UnknownMod.MOD_ID + "." + id + " to item group");
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        UnknownMod.LOGGER.debug("Added item " + UnknownMod.MOD_ID + "." + id + " to item group");
        return registeredItem;
    }

    public static void register() {
        UnknownMod.LOGGER.debug("Registering items for " + UnknownMod.MOD_ID);
    }
}
