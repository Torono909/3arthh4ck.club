package me.earth.earthhack.impl;

import me.earth.earthhack.api.util.interfaces.Globals;
import me.earth.earthhack.impl.core.ducks.IMinecraft;
import me.earth.earthhack.impl.managers.Managers;
import me.earth.earthhack.impl.managers.thread.GlobalExecutor;
import me.earth.earthhack.impl.util.discord.DiscordPresence;
import me.earth.earthhack.impl.util.math.geocache.Sphere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

public class Earthhack
        implements Globals {
    private static final Logger LOGGER = LogManager.getLogger((String)"Toxonic");
    public static final String NAME = "Toxonic";
    public static final String VERSION = "1.0.0";

    public static void preInit() {
        GlobalExecutor.EXECUTOR.submit(() -> Sphere.cacheSphere(LOGGER));
    }

    public static void init() {
        LOGGER.info("\n\nInitializing Toxonic.");
        Display.setTitle((String)"Toxonic - 1.0.0");
        DiscordPresence.start();
        Managers.load();
        LOGGER.info("\nToxonic initialized.\n");
    }

    public static void postInit() {
    }


    public static Logger getLogger() {
        return LOGGER;
    }

    public static boolean isRunning() {
        return ((IMinecraft)mc).isEarthhackRunning();
    }
}
