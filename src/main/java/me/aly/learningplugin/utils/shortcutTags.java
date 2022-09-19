package me.aly.learningplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

public class shortcutTags implements Listener {


    public static String PREFIX = "" + ChatColor.WHITE + ChatColor.BOLD + "[" + ChatColor.GREEN + ChatColor.BOLD + "Learn" + ChatColor.WHITE + ChatColor.BOLD + "] ";
    public static String noperm = PREFIX + ChatColor.RED + "You do not have permission to run this commmand. ";
    public static String lessargs = PREFIX + ChatColor.RED + "Not Enough Arguements: ";
    public static String moreargs = PREFIX + ChatColor.RED + "Too Many Arguements: ";
    public static String console = PREFIX + ChatColor.RED + "You need to be a player to execute this command. ";
    public static String cannotfind = PREFIX + ChatColor.RED + "Cannot find. ";
    public static String specifyplayer = PREFIX + ChatColor.RED + "Specify Player. ";




}