package me.aly.learningplugin.commands;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("learn.god")) {
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(PREFIX + ChatColor.RED + "You are no longer in GOD MODE.");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(PREFIX + ChatColor.GREEN + "You are now in GOD MODE.");
                }
            } else {
                p.sendMessage(noperm);
            }

        }
        return true;
    }
}