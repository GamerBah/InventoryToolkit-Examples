package com.gamerbah.toolkittesting.simple;
/* Created by GamerBah on 3/12/2018 */

import com.gamerbah.inventorytoolkit.ClickEvent;
import com.gamerbah.inventorytoolkit.GameInventory;
import com.gamerbah.inventorytoolkit.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class SimpleExample1 extends GameInventory {

    public SimpleExample1(Player player) {
        super("Name", 54);

        // Add a pagination-enabled search box from the first to the fourth row (slots 0-35)
        setSearchRows(0, 3);
        // Sets the row that the navigation buttons will be on (next page/previous page)
        setPageRow(5);
        // Adds a glass-pane border on row 5, between the search box and the pagination buttons
        addBorder(4, DyeColor.RED);

        for (int x = 0; x < 64; x++)
            addItem(new ItemBuilder(Material.DIAMOND)
                    .name(ChatColor.AQUA + "You can click me!")
                    .lore(ChatColor.GRAY + "Some lore...")
                    .enchantment(Enchantment.SILK_TOUCH)
                    .amount(64)
                    .onClick(new ClickEvent(() -> {
                        player.sendMessage("Yay!");
                        player.setAllowFlight(true);
                    }, ClickEvent.Type.LEFT, ClickEvent.Type.SHIFT_LEFT)));

        addButton(49, new ItemBuilder(Material.APPLE)
                .name("An apple a day...")
                .lore("... is too healthy! :D")
                .onClick(new ClickEvent(() -> player.sendMessage("hello!"))));
    }

}
