package com.gamerbah.toolkittesting.simple.example1;
/* Created by GamerBah on 3/22/2018 */

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Example1 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        if (args.length == 0)
            // Opens to page 1 without any modifications done
            new ExampleInventory1(player).build(player).open();

        if (args.length == 1) {
            if (args[0].equals("2"))
                // Opens to the 2nd page, since page() is zero-based
                new ExampleInventory1(player).build(player).open(1);
            if (args[0].equals("3"))
                // This'll throw an error, since we won't have more than 2 total pages in the inventory
                new ExampleInventory1(player).build(player).open(2);
        }

        return true;
    }
}
