package io.github.thepoultryman.rustic_craft_example;

import net.minecraft.item.ItemGroup;

import java.util.List;

public class ModFile {
    String mod_id;
    List<ModItem> items;

    public String getModId() {
        return this.mod_id;
    }

    public static class ModItem {
        String identifier;
        ModItemSettings item_settings;

        public ItemGroup getItemGroup() {
            return switch (item_settings.item_group) {
                case Combat -> ItemGroup.COMBAT;
                case Decorations -> ItemGroup.DECORATIONS;
                case Search -> ItemGroup.SEARCH;
            };
        }

        static class ModItemSettings {
            ItemGroup item_group;

            enum ItemGroup {
                Combat,
                Decorations,
                Search
            }
        }
    }
}
