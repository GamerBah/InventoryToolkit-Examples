 # InventoryToolkit-Examples
A repo to show both simples and advanced usages of my [Inventory Toolkit for Spigot](https://www.spigotmc.org/resources/inventory-toolkit.54414/ "Inventory Toolkit's resource page").

**NOTE:** These examples are *purely* to show how this API can be used, and it's recommended to not copy the classes line-for-line, as they may not fit your exact needs. If the advanced example still don't suit your fancy, feel free to contact me for some help (although the advanced examples should be in the range of what everyone will need, we'll see when we get there).

---
## Installation
Add the `InventoryToolkit.jar` as a library in your project and throw it in `your-server/plugins`

## Basics
Every inventory that you want to create should be contained in its own class that `extends GameInventory`. From there, a custom constructor can be used, but one of the supers must be called:
```java
// Full Constructor
GameInventory(final String name, final int itemCount, final int size, final GameInventory previousInventory)

// Constructor that has a null previousInventory
GameInventory(final String name, final int itemCount, final int size)

// Constructor that doesn't take an itemCount, most-likely the most-used
GameInventory(final String name, final int size, final GameInventory previousInventory)

// Basic constructor that only takes a string and a name
GameInventory(final String name, final int size)

// Basic constructor that sets a previousInventory, and uses the default size of 54
GameInventory(final String name, final GameInventory previousInventory)
```

Using this, we can create a very basic group of custom inventories:
```java
public class ParentInventory extends GameInventory {
  
  private final Player player;
  
  public ParentInventory(final Player player) {
    // Uses the (name, size) constructor, since, because this is the parent, we don't need a previousInventory
    super("Parent Inventory", 27);
    this.player = player;
    
    addButton(13, new ItemBuilder(Material.DIAMOND)
        .name("Child Inventory")
        .lore("Click to go to the")
        .lore("child inventory!")
        .onClick(new ClickEvent(() -> new ChildInventory("Child Inventory", 54, this).build(player).open(), ClickEvent.Type.ANY);
  }
  
}
```

```java
public class ChildInventory extends GameInventory {
  
  public ChildInventory(final String name, final int size, final GameInventory previousInventory) {
    // Uses the (name, size, previousInventory) constructor since we have a previousInventory to go back to
    super(name, size, previousInventory);
    // Adds a working pagination search box that takes up the whole inventory
    setSearchRows(0, 5);
    // Sets the offset of each item in the search box to 1 on each side
    setSearchOffset(1);
    // Puts navigation buttons inline with the items in the search box
    setInlineNavigation(true);
    // Allows creative mode players to click in the inventory
    setAllowCreative(true);
    
    // Add 319 stacks of diamonds to this inventory
    for (int i = 0; i < 319; i++)
      addItem(new ItemBuilder(Material.DIAMOND)
          .name(ChatColor.AQUA + "DIAMOND!")
          .lore("Oooh shiny!")
          .amount(64)
          .enchantment(Enchantment.LOOT_BONUS_BLOCKS, 3);
  }
  
}
```

Much more advanced examples will be available in this repo as soon as I get around to it. This is a *very basic* example, and much more advanced things can be done using this API, such as sorting and querying items with certain names.

Suggestions for this API are always welcome over at the [resource's Spigot discussion](https://www.spigotmc.org/threads/inventory-toolkit.308483/)!
