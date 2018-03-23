package com.gamerbah.toolkittesting.simple.example2;
/* Created by GamerBah on 3/12/2018 */

import com.gamerbah.inventorytoolkit.ClickEvent;
import com.gamerbah.inventorytoolkit.GameInventory;
import com.gamerbah.inventorytoolkit.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;

public class ExampleInventory2 extends GameInventory {

    public ExampleInventory2(Player player) {
        super("Admin Menu", 27);
        // Since we don't have any pagination-enabled boxes in this inventory, nothing but addButton() is needed

        addButton(11, new ItemBuilder(Material.CONCRETE)
                .name(ChatColor.GREEN + "Enable Chat")
                .lore(ChatColor.GRAY + "Allows players to chat")
                .addPermission("example2.chat.enable")
                .enchantment(Enchantment.KNOCKBACK)
                .flag(ItemFlag.HIDE_ENCHANTS)
                // Set the color to lime
                .durability(5)
                .onClick(new ClickEvent(() -> {
                    // Code to enable chat here
                    Bukkit.getServer().getOnlinePlayers().forEach(p -> {
                        p.sendMessage(ChatColor.GREEN + "Chat has been enabled!");
                        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    });
                })));

        addButton(13, new ItemBuilder(Material.SIGN)
                .name(ChatColor.YELLOW + "Clear Chat")
                .lore(ChatColor.GRAY + "Clears the chat")
                .addPermission("example2.chat.clear")
                .onClick(new ClickEvent(() -> {
                    // Sends the players 100 blank messages, "clearing" their chat boxes
                    for (int x = 0; x < 100; x++)
                        Bukkit.getServer().getOnlinePlayers().forEach(p -> p.sendMessage(" "));
                    Bukkit.getServer().getOnlinePlayers().forEach(p -> {
                        p.sendMessage(ChatColor.YELLOW + "Chat was cleared by " + ChatColor.GRAY + player.getName());
                        p.playSound(p.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 1, 1);
                    });
                })));

        addButton(15, new ItemBuilder(Material.CONCRETE)
                .name(ChatColor.RED + "Disable Chat")
                .lore(ChatColor.GRAY + "Disallows player chat")
                .addPermission("example2.chat.disable")
                .enchantment(Enchantment.KNOCKBACK)
                .flag(ItemFlag.HIDE_ENCHANTS)
                // Set the color to red
                .durability(14)
                .onClick(new ClickEvent(() -> {
                    // Code to disable chat here
                    Bukkit.getServer().getOnlinePlayers().forEach(p -> {
                        p.sendMessage(ChatColor.RED + "Chat has been disabled!");
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1, 1);
                    });
                })));
    }

}
