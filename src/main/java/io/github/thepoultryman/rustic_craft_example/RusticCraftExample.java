package io.github.thepoultryman.rustic_craft_example;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RusticCraftExample implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Rustic Craft Example Mod");

	@Override
	public void onInitialize(ModContainer modContainer) {
		LOGGER.info("The Rustic Craft Example mod is initializing.");
        ModFileReader modFileReader = new ModFileReader();

        ModFile mod = modFileReader.readModFile(modContainer.metadata().id());

        for (ModFile.ModItem modItem : mod.items) {
            Item item = new Item(new Item.Settings().group(modItem.getItemGroup()));
            Registry.register(Registry.ITEM, new Identifier(mod.getModId(), modItem.identifier), item);
        }
	}
}
