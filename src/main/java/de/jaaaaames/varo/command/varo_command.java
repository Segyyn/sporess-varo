package de.jaaaaames.varo.command;

import de.jaaaaames.varo.manager.pluginManager;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class varo_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("varo")) {
            if(!(player.hasPermission("varo.maincommand"))) {
                player.sendMessage(pluginManager.noPermission);
                return true;
            } else {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("help")) {
                        player.sendMessage(pluginManager.getPluginPrefix + "§eVARO-System §7- §av1.0");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo help §7- §cLasse dir dieses Fenster zeigen");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo setup §7- §cBeginne mit dem Einstellen von VARO");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo start §7- §cBeginne das VARO-Event");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo stop §7- §cStoppe das VARO-Event");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo pause §7- §cPausiere das VARO-Event");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo spectate §7- §cBegebe dich in die Spectatoransicht");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo eliminatedPlayers §7- §cGib eine Liste von allen eliminierten Spielern ausd");
                        player.sendMessage(pluginManager.getPluginPrefix + "§e/varo teamstats <teamname> §7- §cGib die Statistiken für jedes einzelne Team aus");
                    } else if (args[0].equalsIgnoreCase("start")) {

                    } else if (args[0].equalsIgnoreCase("stop")) {

                    } else if (args[0].equalsIgnoreCase("pause")) {

                    } else if (args[0].equalsIgnoreCase("spectate")) {
                        if(player.hasPermission("varo.spectate")) {
                            ArrayList<Player> vanish = new ArrayList<>();

                            if(!(vanish.contains(player))) {
                                vanish.add(player);

                                player.playSound(player.getLocation(), Sound.CAT_PURR, 1F, 1F);
                                player.sendMessage(pluginManager.getSpectateTrue);

                                player.setGameMode(GameMode.ADVENTURE);
                                player.setAllowFlight(true);
                                player.setFlying(true);
                            } else {
                                vanish.remove(player);
                            }
                        } else {
                            player.sendMessage(command.getPermissionMessage());
                            return true;
                        }
                    } else if (args[0].equalsIgnoreCase("eliminatedPlayers")) {

                    } else {

                    }
                } else {
                    player.sendMessage(pluginManager.getPluginPrefix + "§cBenutze: §e/varo <arg|help>");
                }
            }
        }

        return false;
    }
}
