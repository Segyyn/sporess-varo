package de.jaaaaames.varo.command;

import de.jaaaaames.varo.manager.pluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class varo_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("varo")) {
            if(!(player.hasPermission("varo.maincommand"))) {
                player.sendMessage(pluginManager.noPermission);
                return true;
            } else {

            }
        }

        return false;
    }
}
