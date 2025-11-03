package com.bleudev.unknown.item;

import com.bleudev.unknown.UnknownMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> UNKNOWN_ITEMS_GROUP_KEY = createRegistryKey("unknown_items");
    public static final ItemGroup UNKNOWN_ITEMS_GROUP = registerGroup(UNKNOWN_ITEMS_GROUP_KEY, ModItems.UNKNOWN_ITEM, "itemGroup.unknown_item");

    private static RegistryKey<ItemGroup> createRegistryKey(String name) {
        return RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(UnknownMod.MOD_ID, name));
    }

    private static ItemGroup registerGroup(RegistryKey<ItemGroup> key, Item icon, String displayName) {

        UnknownMod.LOGGER.debug("Building item group " + displayName);
        ItemGroup itemGroup = FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon))
                .displayName(Text.translatable(displayName))
                .build();
        UnknownMod.LOGGER.debug("Builded item group " + displayName);

        UnknownMod.LOGGER.debug("Registering item group " + displayName);
        Registry.register(Registries.ITEM_GROUP, key, itemGroup);
        UnknownMod.LOGGER.debug("Registered item group " + displayName);
        return itemGroup;
    }

    public static void register() {
    }
}
