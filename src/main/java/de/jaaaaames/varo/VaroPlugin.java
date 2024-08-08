package de.jaaaaames.varo;

import de.jaaaaames.varo.listener.playerDeathEvent;
import de.jaaaaames.varo.listener.playerJoinEvent;
import de.jaaaaames.varo.manager.GameState;
import de.jaaaaames.varo.manager.GameStateManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class VaroPlugin extends JavaPlugin {

    public static VaroPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        GameStateManager.setCurrentGameState(GameState.LOBBY); //setting GameState always to LOBBY due to server restart.

        commandHandler();
        eventHandler();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private  void commandHandler() { // method for registrating commands

    }

    private void eventHandler() { // method for registrating listener
        getServer().getPluginManager().registerEvents(new playerJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new playerDeathEvent(), this);
    }

    public static VaroPlugin getInstance() {
        return instance;
    }

    public static void setInstance(VaroPlugin instance) {
        VaroPlugin.instance = instance;
    }
}
