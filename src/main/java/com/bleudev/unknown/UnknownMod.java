package com.bleudev.unknown;

import com.bleudev.unknown.block.ModBlocks;
import com.bleudev.unknown.item.ModItemGroups;
import com.bleudev.unknown.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnknownMod implements ModInitializer {
	public static final String MOD_ID = "unknown-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("TASK: Register item groups");
		ModItemGroups.register();
		LOGGER.info("TASK: Completed!");

		LOGGER.info("TASK: Register items");
		ModItems.register();
		LOGGER.info("TASK: Completed!");

		LOGGER.info("TASK: Register blocks");
		ModBlocks.register();
		LOGGER.info("TASK: Completed!");
		
		LOGGER.info("Hello Fabric world!");
	}
}