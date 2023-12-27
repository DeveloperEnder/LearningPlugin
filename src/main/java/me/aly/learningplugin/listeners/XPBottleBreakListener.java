package me.aly.learningplugin.listeners;

import static me.aly.learningplugin.utils.shortcutTags.*;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreakListener implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e){

     e.setShowEffect(false);

    }
}
