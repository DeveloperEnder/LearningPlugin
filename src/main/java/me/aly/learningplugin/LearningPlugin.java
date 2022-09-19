package me.aly.learningplugin;

import me.aly.learningplugin.commands.FlyCommand;
import me.aly.learningplugin.commands.Gamemode;
import me.aly.learningplugin.commands.HealCommand;
import me.aly.learningplugin.commands.GodCommand;
import me.aly.learningplugin.events.BedEvent;
import me.aly.learningplugin.listeners.JoinLeaveListener;
import me.aly.learningplugin.listeners.XPBottleBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class LearningPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("LearningPlugin has started.");

        //Events
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new BedEvent(),this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(),this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(),this);

        //commands
        getCommand("god").setExecutor(new GodCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gms").setExecutor(new Gamemode());
        getCommand("gmc").setExecutor(new Gamemode());
        getCommand("gmsp").setExecutor(new Gamemode());
        getCommand("gma").setExecutor(new Gamemode());
        getCommand("fly").setExecutor(new FlyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("LearningPlugin has stopped.");

    }
}
