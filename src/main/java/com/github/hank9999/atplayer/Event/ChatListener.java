package com.github.hank9999.atplayer.Event;

import com.github.hank9999.atplayer.AtPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player p = e.getPlayer();
        if (message.toLowerCase().contains("@all")) {
            if (!AtPlayer.ins.getConfig().getBoolean("atall")) {
                return;
            }
            if (!p.hasPermission("AtPlayer.admin")) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                                ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                        AtPlayer.ins.getConfig().getString("message.no_perm")
                                )));
                    }
                }.runTaskLaterAsynchronously(AtPlayer.ins, 1L);
                return;
            }
            message = message.replaceAll("(?i)@all", ChatColor.AQUA + "@all" + ChatColor.RESET + " ");
            e.setMessage(message);
            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player player : AtPlayer.ins.getServer().getOnlinePlayers()) {
                        player.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.GREEN + p.getName() + " " +
                                ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                        AtPlayer.ins.getConfig().getString("message.at")
                                )));
                        AtPlayer.ins.at_stats.putIfAbsent(player, true);
                        if (AtPlayer.ins.at_stats.get(player)) {
                            player.sendTitle(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                    AtPlayer.ins.getConfig().getString("message.have_atall")
                            )), ChatColor.AQUA + p.getName() + " " +
                                    ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                            AtPlayer.ins.getConfig().getString("message.atall")
                                    )));
                            for (String sound : Objects.requireNonNull(AtPlayer.ins.getConfig().getConfigurationSection("sounds.atall")).getKeys(false)) {
                                player.playSound(player.getLocation(),
                                        Sound.valueOf(sound),
                                        ((Double)AtPlayer.ins.getConfig().getDouble("sounds.atall." + sound + ".volume")).floatValue(),
                                        ((Double)AtPlayer.ins.getConfig().getDouble("sounds.atall." + sound + ".pitch")).floatValue()
                                );
                            }
                        }
                    }
                }
            }.runTaskLaterAsynchronously(AtPlayer.ins, 1L);
            return;
        }
        for (Player player : AtPlayer.ins.getServer().getOnlinePlayers()) {
            String playername = player.getName();
            if (message.toLowerCase().contains(("@" + playername).toLowerCase()) || message.toLowerCase().contains(("@ " + playername).toLowerCase())) {
                if (!AtPlayer.ins.getConfig().getBoolean("atplayer")) {
                    return;
                }
                if (!(AtPlayer.ins.getConfig().getBoolean("bypass_cooldown") && p.hasPermission("AtPlayer.admin"))) {
                    if (AtPlayer.ins.at_time.get(player) == null) {
                        AtPlayer.ins.at_time.put(player, System.currentTimeMillis() / 1000);
                    } else if (((System.currentTimeMillis() / 1000) - (AtPlayer.ins.at_time.get(player))) <= AtPlayer.ins.getConfig().getLong("cooldown")) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                p.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                                        ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                                Objects.requireNonNull(AtPlayer.ins.getConfig().getString("message.cooldown")).replaceAll("%s%",
                                                        String.valueOf(AtPlayer.ins.getConfig().getLong("cooldown") - ((System.currentTimeMillis() / 1000) - (AtPlayer.ins.at_time.get(player))))
                                                )
                                        )));
                            }
                        }.runTaskLaterAsynchronously(AtPlayer.ins, 1L);
                        return;
                    } else {
                        AtPlayer.ins.at_time.put(player, System.currentTimeMillis() / 1000);
                    }
                }

                if (!(p.hasPermission("AtPlayer.use") || p.hasPermission("AtPlayer.admin"))) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            p.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                                    ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                            AtPlayer.ins.getConfig().getString("message.no_perm")
                                    )));
                        }
                    }.runTaskLaterAsynchronously(AtPlayer.ins, 1L);
                    return;
                }
                message = message.replaceAll("(?i)@" + playername, ChatColor.AQUA + "@" + playername + ChatColor.RESET + " ");
                message = message.replaceAll("(?i)@ " + playername, ChatColor.AQUA + "@" + playername + ChatColor.RESET + " ");
                e.setMessage(message);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.GREEN + p.getName() + " " +
                                ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                        AtPlayer.ins.getConfig().getString("message.at")
                                )));
                        AtPlayer.ins.at_stats.putIfAbsent(player, true);
                        if (AtPlayer.ins.at_stats.get(player)) {
                            player.sendTitle(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                    AtPlayer.ins.getConfig().getString("message.have_at")
                            )), ChatColor.AQUA + player.getName() + " " +
                                    ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(
                                            AtPlayer.ins.getConfig().getString("message.at")
                                    )));
                            for (String sound : Objects.requireNonNull(AtPlayer.ins.getConfig().getConfigurationSection("sounds.at")).getKeys(false)) {
                                player.playSound(player.getLocation(),
                                        Sound.valueOf(sound),
                                        ((Double)AtPlayer.ins.getConfig().getDouble("sounds.at." + sound + ".volume")).floatValue(),
                                        ((Double)AtPlayer.ins.getConfig().getDouble("sounds.at." + sound + ".pitch")).floatValue()
                                );
                            }
                        }
                    }
                }.runTaskLaterAsynchronously(AtPlayer.ins, 1L);
            }
        }
        return;
    }
}
