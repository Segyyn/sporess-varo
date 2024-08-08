package de.jaaaaames.varo.listener;

import de.jaaaaames.varo.manager.GameState;
import de.jaaaaames.varo.manager.GameStateManager;
import de.jaaaaames.varo.manager.pluginManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (GameStateManager.isGameState(GameState.LOBBY)) {
            if (player.getName().equals("Jaaaaames")) {
                event.setJoinMessage(pluginManager.getPluginPrefix + "§4Jaaaaames §aist VARO beigetreten");
            } else {
                event.setJoinMessage(pluginManager.getPluginPrefix + player.getName() + " §aist VARO beigetreten!");
            }
        }
    }
}
