package com.plugin.minestates;

import com.plugin.minestates.commands.Commands;
import com.plugin.minestates.commands.Guis;
import com.plugin.minestates.sql.MySQL;
import com.plugin.minestates.sql.SQLGetter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;


public final class Main extends JavaPlugin {

    private static Economy eco = null;
    public MySQL SQL;
    public SQLGetter data;

    @Override
    public void onEnable() {
        if (!setupEconomy() ) {
            System.out.println("No economy plugin found, disabling the plugin");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getCommand("ms").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getServer().getPluginManager().registerEvents(new Guis(), this);

        this.SQL = new MySQL();
        this.data = new SQLGetter(this);

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
            // Login info is incorrect
            // they are not using a database
            Bukkit.getLogger().info("Database not connected");
        }

        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected!");
            data.createTables();
        }

    }

    @Override
    public void onDisable() {
        SQL.disconnect();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        eco = rsp.getProvider();
        return true;
    }

    public static Economy getEconomy() {
        return eco;
    }
}
