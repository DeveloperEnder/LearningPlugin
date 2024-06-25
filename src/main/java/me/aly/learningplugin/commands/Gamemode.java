package me.aly.learningplugin.commands;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

    public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("gma")) {
            changeGM(sender, args, "gma", GameMode.ADVENTURE);
        } else if (cmd.getName().equalsIgnoreCase("gmc")) {
            changeGM(sender, args, "gmc", GameMode.CREATIVE);
        } else if (cmd.getName().equalsIgnoreCase("gms")) {
            changeGM(sender, args, "gms", GameMode.SURVIVAL);
        } else if (cmd.getName().equalsIgnoreCase("gmsp")) {
            changeGM(sender, args, "gmsp", GameMode.SPECTATOR);
        }
        return false;
    }

    public void changeGM(CommandSender sender, String[] args, String permission, GameMode gamemode) {
        if (sender.hasPermission("learn." + permission) || !(sender instanceof Player)) {
            if (args.length == 0 && sender instanceof Player) {
                Player player = (Player) sender;
                if (player.getGameMode() == gamemode) {
                    sender.sendMessage(PREFIX + ChatColor.RED + "You are aleady in " + player.getGameMode());
                } else {
                    sender.sendMessage(PREFIX + ChatColor.GREEN + "Gamemode changed to " + ChatColor.BLUE + gamemode.name());
                    player.setGameMode(gamemode);
                }
            } else if (sender.hasPermission("learn.gm.other") || !(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage(specifyplayer);
                } else {
                    Player arg0 = Bukkit.getServer().getPlayer(args[0]);
                    if (arg0 == null) {
                        sender.sendMessage(cannotfind + args[0]);
                    } else {
                        if (arg0.getGameMode() == gamemode) {
                            sender.sendMessage(PREFIX + ChatColor.RED + arg0.getDisplayName() + " is " + "already in " + arg0.getGameMode());
                        } else {
                            sender.sendMessage(PREFIX + ChatColor.GREEN + arg0.getDisplayName() + "'s " + "Gamemode changed to " + ChatColor.BLUE + gamemode.name());
                            arg0.sendMessage(PREFIX + ChatColor.GREEN + "Gamemode Changed to " + ChatColor.BLUE + gamemode.name());
                            arg0.setGameMode(gamemode);
                        }
                    }
                }
            } else {
                sender.sendMessage(noperm);
            }
        } else {
            sender.sendMessage(noperm);
        }
    }
}