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
    public static final ItemGroup UNKNOWN_ITEMS_GROUP = createGroup(ModItems.UNKNOWN_ITEM, "itemGroup.unknown_item");

    private static RegistryKey<ItemGroup> createRegistryKey(String name) {
        return RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(UnknownMod.MOD_ID, name));
    }

    private static ItemGroup createGroup(Item icon, String displayName) {
        return FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon))
                .displayName(Text.translatable(displayName))
                .build();
    }

    private static void registerGroup(RegistryKey<ItemGroup> key, ItemGroup itemGroup) {
        Registry.register(Registries.ITEM_GROUP, key, itemGroup);
    }

    public static void register() {
        registerGroup(UNKNOWN_ITEMS_GROUP_KEY, UNKNOWN_ITEMS_GROUP);
    }
}
