package de.jaaaaames.varo;

import org.bukkit.plugin.java.JavaPlugin;

public class VaroPlugin extends JavaPlugin {

    public static VaroPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        commandHandler();
        eventHandler();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private static void commandHandler() { // method for registrating commands

    }

    private static void eventHandler() { // method for listener events

    }

    public static VaroPlugin getInstance() {
        return instance;
    }

    public static void setInstance(VaroPlugin instance) {
        VaroPlugin.instance = instance;
    }
}
