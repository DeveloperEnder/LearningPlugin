package me.aly.learningplugin;

import static me.aly.learningplugin.utils.shortcutTags.*;

import me.aly.learningplugin.commands.*;
import me.aly.learningplugin.events.*;
import me.aly.learningplugin.listeners.*;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println(PREFIX + "LearningPlugin has started.");

        //Events
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BedEvent(),this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(),this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);

        //commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());
        getCommand("gma").setExecutor(new Gamemode());
        getCommand("fly").setExecutor(new FlyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println(PREFIX + "LearningPlugin has stopped.");

    }
}
