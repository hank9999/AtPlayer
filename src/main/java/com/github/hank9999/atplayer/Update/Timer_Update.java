package com.github.hank9999.atplayer.Update;

import com.github.hank9999.atplayer.AtPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Timer;
import java.util.TimerTask;

public class Timer_Update {
    private boolean is_first = true;

    public Timer_Update() {
        final Timer timer = new Timer(true); // We use a timer cause the Bukkit scheduler is affected by server lags
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (AtPlayer.ins == null || !AtPlayer.ins.isEnabled()) { // Plugin was disabled
                    timer.cancel();
                    return;
                }
                Bukkit.getScheduler().runTask(AtPlayer.ins, () -> Update_Check());
            }
        }, 0, 1000 * 60 * 60);
    }

    public void Update_Check() {
        new Update_Checker(AtPlayer.ins).getVersion(version -> {
            if (("v" + AtPlayer.ins.getDescription().getVersion()).equalsIgnoreCase(version)) {
                if (is_first) {
                    AtPlayer.ins.getLogger().info(ChatColor.AQUA + "No new update available.");
                    is_first = false;
                }
            } else {
                AtPlayer.ins.getLogger().info(ChatColor.AQUA + "A new update " + version + " available!");
                AtPlayer.ins.getLogger().info(ChatColor.AQUA + "See it in https://www.spigotmc.org/resources/atplayer.78276/");
            }
        });
    }
}
