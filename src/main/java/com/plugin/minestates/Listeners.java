package com.plugin.minestates;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class Listeners implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setResourcePack("https://www.dropbox.com/sh/r143pk6h5nghq16/AAAXnGygLq0zmbCmXFvz7K-Ka?dl=1");
    }
}
