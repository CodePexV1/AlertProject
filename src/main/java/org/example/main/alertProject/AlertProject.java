package org.example.main.alertProject;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AlertProject extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "The Plugin Has Been Started!");
        getCommand("alert").setExecutor(new Alert());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "The Plugin Stopped!");
    }
}
