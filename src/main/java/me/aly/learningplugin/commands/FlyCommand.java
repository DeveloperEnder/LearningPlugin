package me.aly.learningplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.aly.learningplugin.utils.shortcutTags.*;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("learn.fly") || !(sender instanceof Player)) {
            if (args.length == 0 && sender instanceof Player) {
                Player player = (Player) sender;
                if (!(player.getAllowFlight())) {
                    player.setAllowFlight(true);
                    sender.sendMessage(PREFIX + ChatColor.GREEN + "Fly has been enabled!");
                } else if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    sender.sendMessage(PREFIX + ChatColor.RED + "Fly has been disabled!");
                }
            } else if (sender.hasPermission("learn.fly.other") || !(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(specifyplayer);
                } else {
                    Player arg0 = Bukkit.getServer().getPlayer(args[0]);
                    if (arg0 == null) {
                        sender.sendMessage(cannotfind);
                    } else {
                        if (!(arg0.getAllowFlight())) {
                            arg0.setAllowFlight(true);
                            arg0.sendMessage(PREFIX + ChatColor.GREEN + "Fly has been enabled!");
                            sender.sendMessage(PREFIX + ChatColor.GREEN + "Fly has been enabled for " + arg0.getDisplayName() + "!");
                        } else if (arg0.getAllowFlight()) {
                            arg0.setAllowFlight(false);
                            arg0.sendMessage(PREFIX + ChatColor.RED + "Fly has been disabled!");
                            sender.sendMessage(PREFIX + ChatColor.RED + "Disabled Flying for " + arg0.getDisplayName() + "!");
                        }
                    }
                }
            } else {
                sender.sendMessage(noperm);
            }
        } else {
            sender.sendMessage(noperm);
        }

        return false;
    }
    }