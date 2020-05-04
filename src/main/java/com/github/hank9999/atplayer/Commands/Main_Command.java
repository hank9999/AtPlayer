package com.github.hank9999.atplayer.Commands;

import com.github.hank9999.atplayer.AtPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Command implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("at") || command.getName().equalsIgnoreCase("atplayer")) {
            if (strings.length == 0) {
                commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.LIGHT_PURPLE + "Author: hank9999, xm2020");
                commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.DARK_PURPLE + "/at help");
                return true;
            }
            if (strings.length != 1) {
                return true;
            }
            boolean is_exist = false;
            for (String c : Arrays.asList("help", "on", "off", "enable", "disable", "reload")) {
                if (strings[0].equalsIgnoreCase(c)) {
                    is_exist = true;
                    break;
                }
            }
            if (!is_exist) {
                for (String message : AtPlayer.ins.getConfig().getStringList("command_message.not_exist")) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                            ChatColor.translateAlternateColorCodes('&', message));
                }
                return true;
            }
            if (strings[0].equalsIgnoreCase("help")) {
                commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.DARK_PURPLE + "/at help | on | off | enable | disable");
                return true;
            }
            if (strings[0].equalsIgnoreCase("enable")) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.RED + "CommandSender must be player");
                    return true;
                }
                AtPlayer.ins.at_stats.putIfAbsent((Player) commandSender, true);
                AtPlayer.ins.at_stats.put((Player) commandSender, true);
                for (String message : AtPlayer.ins.getConfig().getStringList("command_message.enable")) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                            ChatColor.translateAlternateColorCodes('&', message));
                }
                return true;
            }
            if (strings[0].equalsIgnoreCase("disable")) {
                if (!(commandSender instanceof Player)) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.RED + "CommandSender must be player");
                    return true;
                }
                AtPlayer.ins.at_stats.putIfAbsent((Player) commandSender, false);
                AtPlayer.ins.at_stats.put((Player) commandSender, false);
                for (String message : AtPlayer.ins.getConfig().getStringList("command_message.disable")) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                            ChatColor.translateAlternateColorCodes('&', message));
                }
                return true;
            }
            if (commandSender.hasPermission("AtPlayer.admin")) {
                if (strings[0].equalsIgnoreCase("reload")) {
                    AtPlayer.ins.reloadConfig();
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " + ChatColor.GOLD + "Config Reload");
                    return true;
                }
                if (strings[0].equalsIgnoreCase("on")) {
                    AtPlayer.ins.getConfig().set("atall", true);
                    AtPlayer.ins.getConfig().set("atplayer", true);
                    AtPlayer.ins.saveConfig();
                    AtPlayer.ins.reloadConfig();
                    for (String message : AtPlayer.ins.getConfig().getStringList("command_message.m_on")) {
                        commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                                ChatColor.translateAlternateColorCodes('&', message));
                    }
                    return true;
                }
                if (strings[0].equalsIgnoreCase("off")) {
                    AtPlayer.ins.getConfig().set("atall", false);
                    AtPlayer.ins.getConfig().set("atplayer", false);
                    AtPlayer.ins.saveConfig();
                    AtPlayer.ins.reloadConfig();
                    for (String message : AtPlayer.ins.getConfig().getStringList("command_message.m_off")) {
                        commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                                ChatColor.translateAlternateColorCodes('&', message));
                    }
                    return true;
                }
            } else {
                for (String message : AtPlayer.ins.getConfig().getStringList("command_message.no_perm")) {
                    commandSender.sendMessage(ChatColor.AQUA + "[@] " + ChatColor.YELLOW + ">>> " +
                            ChatColor.translateAlternateColorCodes('&', message));
                }
            }

        }
        return true;
    }

    private final String[] Commands = {"reload", "on", "off", "disable", "enable", "help"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 0) return Arrays.asList(Commands);
        if (args.length > 1) return new ArrayList<>();
        return Arrays.stream(Commands).filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
    }
}
