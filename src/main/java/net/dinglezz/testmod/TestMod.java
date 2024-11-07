package net.dinglezz.testmod;

import net.dinglezz.testmod.block.ModBlocks;
import net.dinglezz.testmod.component.ModDataComponentTypes;
import net.dinglezz.testmod.item.ModItemGroups;
import net.dinglezz.testmod.item.ModItems;
import net.dinglezz.testmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 1600);

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}