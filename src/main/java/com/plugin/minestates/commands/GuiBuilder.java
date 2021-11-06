package com.plugin.minestates.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class GuiBuilder {

    Guis guis = new Guis();

    private Inventory passInv = Bukkit.createInventory(null, 54, "PasswordGUI");


    public void createPasswordGui(UUID uuid) {

        /*Making the custom model data interface that is placed in the top right corner of the gui*/

        ItemStack item = new ItemStack(Material.STONE_HOE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"PasswordGUI"));
        meta.setCustomModelData(2);
        item.setItemMeta(meta);
        passInv.setItem(8,item);

        /* Here are the buttons for the interface, the names are displayed in spanish because im from spain XD */

        ItemStack b1 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b1meta = item.getItemMeta();
        b1meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l1"));
        b1meta.setCustomModelData(1);
        b1.setItemMeta(b1meta);
        passInv.setItem(9,b1);

        ItemStack b2 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b2meta = item.getItemMeta();
        b2meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l2"));
        b2meta.setCustomModelData(2);
        b2.setItemMeta(b2meta);
        passInv.setItem(10,b2);

        ItemStack b3 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b3meta = item.getItemMeta();
        b3meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l3"));
        b3meta.setCustomModelData(3);
        b3.setItemMeta(b3meta);
        passInv.setItem(11,b3);

        ItemStack b4 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b4meta = item.getItemMeta();
        b4meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l4"));
        b4meta.setCustomModelData(4);
        b4.setItemMeta(b4meta);
        passInv.setItem(18,b4);

        ItemStack b5 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b5meta = item.getItemMeta();
        b5meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l5"));
        b5meta.setCustomModelData(5);
        b5.setItemMeta(b5meta);
        passInv.setItem(19,b5);

        ItemStack b6 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b6meta = item.getItemMeta();
        b6meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l6"));
        b6meta.setCustomModelData(6);
        b6.setItemMeta(b6meta);
        passInv.setItem(20,b6);

        ItemStack b7 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b7meta = item.getItemMeta();
        b7meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l7"));
        b7meta.setCustomModelData(7);
        b7.setItemMeta(b7meta);
        passInv.setItem(27,b7);

        ItemStack b8 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b8meta = item.getItemMeta();
        b8meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l8"));
        b8meta.setCustomModelData(8);
        b8.setItemMeta(b8meta);
        passInv.setItem(28,b8);

        ItemStack b9 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b9meta = item.getItemMeta();
        b9meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l9"));
        b9meta.setCustomModelData(9);
        b9.setItemMeta(b9meta);
        passInv.setItem(29,b9);

        ItemStack b0 = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta b0meta = item.getItemMeta();
        b0meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l0"));
        b0meta.setCustomModelData(10);
        b0.setItemMeta(b0meta);
        passInv.setItem(37,b0);

        ItemStack bcancel = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta bcancelmeta = item.getItemMeta();
        bcancelmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&c&lBORRAR"));
        bcancelmeta.setCustomModelData(11);
        bcancel.setItemMeta(bcancelmeta);
        passInv.setItem(36,bcancel);

        ItemStack baccept = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta bacceptmeta = item.getItemMeta();
        bacceptmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&a&lACEPTAR"));
        bacceptmeta.setCustomModelData(12);
        baccept.setItemMeta(bacceptmeta);
        passInv.setItem(38,baccept);

        if(guis.getHashValue(uuid).length() < 1) {}
        else
        {
            ItemStack asterisk = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            ItemMeta basteriskmeta = asterisk.getItemMeta();
            basteriskmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&l1"));
            asterisk.setItemMeta(basteriskmeta);

            int length = guis.getHashValue(uuid).length();
            passInv.setItem(21 + length, asterisk);

        }

        Player p = (Player) Bukkit.getPlayer(uuid);
        p.openInventory(this.passInv);
    }

    public Inventory getPasswordGui(UUID uuid) {
        createPasswordGui(uuid);
        return passInv;
    }

}
