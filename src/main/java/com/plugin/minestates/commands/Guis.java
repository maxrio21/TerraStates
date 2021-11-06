package com.plugin.minestates.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import java.util.HashMap;
import java.util.UUID;


public class Guis implements Listener {

    private HashMap<UUID,StringBuilder> list = new HashMap<>();

    public GuiBuilder guiBuilder = new GuiBuilder();

    public StringBuilder getHashValue(UUID uuid) {return list.get(uuid);}
    public void appendValue(UUID uuid, String text) {
        StringBuilder sb = list.get(uuid);

        if (sb.equals(null))
        {
            list.put(uuid, new StringBuilder(text));
        }
        else
        {
            sb.append(text);
        }
    }


    @EventHandler
    public void guiEnterEvent(InventoryOpenEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        if (!e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "PasswordGUI"))) { return;}
        list.put(uuid, new StringBuilder().append(""));

    }

    @EventHandler
    public void guiClickEvent(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        StringBuilder sb = list.get(uuid);


        if (!e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "PasswordGUI"))) return;
        e.setCancelled(true);


        if (list.get(uuid).length() < 4)
        {
            switch (e.getSlot()) {

                //Boton 1
                case 9:
                    appendValue(uuid,"1");
                    e.getWhoClicked().sendMessage(String.valueOf(getHashValue(uuid)));
                    p.openInventory(guiBuilder.getPasswordGui(uuid));
                    break;

                //Boton 2
                case 10:
                    break;
                //Boton 3
                case 11:
                    break;
                //Boton 4
                case 18:
                    break;
                //Boton 5
                case 19:
                    break;
                //Boton 6
                case 20:
                    break;
                //Boton 7
                case 27:
                    break;
                //Boton 8
                case 28:
                    break;
                //Boton 9
                case 29:
                    break;
                //Boton 0
                case 37:
                    break;
            }
        }
        else
        {
            e.getWhoClicked().closeInventory();
            list.remove(uuid);
        }
    }
}
