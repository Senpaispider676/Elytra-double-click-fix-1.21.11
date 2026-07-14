package com.yourname.elytrafilter;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElytraFilter implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    public static final String MOD_ID = "elytrafilter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world from Elytra Filter!");
    }
}
