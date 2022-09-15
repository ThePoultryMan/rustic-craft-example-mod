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
                case BuildingBlocks -> ItemGroup.BUILDING_BLOCKS;
                case Decorations -> ItemGroup.DECORATIONS;
                case Redstone -> ItemGroup.REDSTONE;
                case Transportation -> ItemGroup.TRANSPORTATION;
                case Misc -> ItemGroup.MISC;
                case Search -> ItemGroup.SEARCH;
                case Food -> ItemGroup.FOOD;
                case Tools -> ItemGroup.TOOLS;
                case Combat -> ItemGroup.COMBAT;
                case Materials -> ItemGroup.MATERIALS;
            };
        }

        static class ModItemSettings {
            ItemGroup item_group;

            enum ItemGroup {
                BuildingBlocks,
                Decorations,
                Redstone,
                Transportation,
                Misc,
                Search,
                Food,
                Tools,
                Combat,
                Materials,
            }
        }
    }
}
