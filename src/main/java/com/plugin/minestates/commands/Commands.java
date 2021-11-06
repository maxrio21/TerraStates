package com.plugin.minestates.commands;

import com.plugin.minestates.Main;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    Main main;
    public GuiBuilder guiBuilder = new GuiBuilder();


    public Commands(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy eco = Main.getEconomy();



            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6Me gustas te gusto?"));
            } else if (args.length > 0) {
                switch (args[0]) {
                    case "bank":
                        switch (args[1]) {
                            case "create":
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"Create"));
                                break;
                            case "delete":
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"Delete"));
                                break;
                            case "info":
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"Info"));
                                break;
                            case "password":
                                player.openInventory(guiBuilder.getPasswordGui(player.getUniqueId()));
                                break;
                        }
                        break;
                    case "d":
                        //player.sendMessage(ChatColor.translateAlternateColorCodes('&',"Dinero: " + eco.getBalance(player)));
                        break;
                }


            }
        }
        return true;

    }
}
