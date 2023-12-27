package me.aly.learningplugin.events;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import static me.aly.learningplugin.utils.shortcutTags.*;

public class BedEvent implements Listener {

    @EventHandler
    public void OnEnterBed(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        player.sendMessage(PREFIX + "You entered a bed.");
    }

    @EventHandler
    public void OnLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.sendMessage(PREFIX + "You left a bed.");
    }

}
