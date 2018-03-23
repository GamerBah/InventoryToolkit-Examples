package com.gamerbah.toolkittesting.simple.example2;
/* Created by GamerBah on 3/22/2018 */

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Example2 implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item.getType() == Material.REDSTONE_COMPARATOR) {
            if (player.hasPermission("example2.admin"))
                new ExampleInventory2(player).build(player).open();
            else {
                player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                player.playSound(player.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 1, 1);
            }
        }
    }

}
