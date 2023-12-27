package me.aly.learningplugin.commands;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("learn.heal")){
                player.setHealth(20);
                player.setFoodLevel(20);
                player.sendMessage(PREFIX + ChatColor.YELLOW + "You have been healed.");
            }else{
            player.sendMessage(noperm);
            }
        }else{System.out.println(console);
        }


        return false;
    }
}
