package com.github.hank9999.atplayer;

import com.github.hank9999.atplayer.Commands.Main_Command;
import com.github.hank9999.atplayer.bStats.MetricsLite;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AtPlayer extends JavaPlugin {

    public static AtPlayer ins;

    @Override
    public void onLoad() {
        getLogger().info(ChatColor.BLUE + "AtPlayer v" + getDescription().getVersion() + " Loaded");
    }

    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        reloadConfig();
        try {
            MetricsLite metrics = new MetricsLite(this, 7388);
            getLogger().info(ChatColor.GOLD + "bStats Metrics Enable");
        } catch (Exception exception) {
            getLogger().warning("An error occurred while enabling bStats Metrics!");
        }
        Objects.requireNonNull(getServer().getPluginCommand("at")).setExecutor(new Main_Command());
        Objects.requireNonNull(getServer().getPluginCommand("at")).setTabCompleter(new Main_Command());
        getLogger().info(ChatColor.BLUE + "AtPlayer v" + getDescription().getVersion() + " Enabled");
    }

    @Override
    public void onDisable() {
        ins = null;
        getLogger().info(ChatColor.GOLD + "AtPlayer v" + getDescription().getVersion() + " Disabled");
    }
}
