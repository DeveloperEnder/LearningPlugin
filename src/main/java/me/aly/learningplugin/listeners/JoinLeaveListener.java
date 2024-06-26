package me.aly.learningplugin.listeners;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()){
            e.setJoinMessage(PREFIX + ChatColor.GREEN + "Welcome back to the adventure " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GREEN + "!");
        }else{
            e.setJoinMessage(PREFIX + ChatColor.BLUE + "" + ChatColor.BOLD + player.getDisplayName() + ", " + ChatColor.BLUE + "Welcome to the adventure!");
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();

        e.setQuitMessage(PREFIX + ChatColor.YELLOW + player.getDisplayName() + ChatColor.RED + " has left the adventure.");
    }

}
