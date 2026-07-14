package com.yourname.elytrafilter;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElytraFilterMod implements ClientModInitializer {
    public static final String MOD_ID = "elytrafilter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Elytra Click Filter initialized.");
    }
}
