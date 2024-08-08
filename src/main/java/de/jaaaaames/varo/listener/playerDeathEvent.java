package de.jaaaaames.varo.listener;

import de.jaaaaames.varo.VaroPlugin;
import de.jaaaaames.varo.manager.GameState;
import de.jaaaaames.varo.manager.GameStateManager;
import de.jaaaaames.varo.manager.pluginManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDeathEvent implements Listener {

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if (GameStateManager.isGameState(GameState.RUNNING)) {
            if (player.isDead()) {
                event.setKeepInventory(false); // player should not keep items after death

                event.setDeathMessage(pluginManager.getPluginPrefix + player.getName() + " §cwurde durch: §e" + player.getKiller() + " §celiminiert!");
                Bukkit.getScheduler().runTaskTimer(VaroPlugin.instance, new Runnable() {
                    @Override
                    public void run() {
                        player.kickPlayer(pluginManager.getEliminationKickMessage); // running kick later so player can see the reactions
                        System.out.println(pluginManager.getPluginPrefix + player.getName() + " §cist ausgeschieden!");
                    }
                }, 5,5);
            }
        } else if (GameStateManager.isGameState(GameState.LOBBY)) {

        }
    }
}
