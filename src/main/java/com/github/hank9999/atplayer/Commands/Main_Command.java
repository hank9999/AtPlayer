package com.github.hank9999.atplayer.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_Command implements TabExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
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
