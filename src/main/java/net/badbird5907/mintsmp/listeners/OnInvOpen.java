package net.badbird5907.mintsmp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnInvOpen implements Listener {
    @EventHandler
    public void onInvOpen(InventoryOpenEvent event){
        int i = -1;
        for (ItemStack content : event.getInventory().getContents()) {
            i++;
            if(content.getItemMeta().getDisplayName().toCharArray().length > 32){
                ItemMeta meta = content.getItemMeta();
                meta.setDisplayName(content.getType().name());
                event.getInventory().getItem(i).setItemMeta(meta);
                event.getPlayer().sendMessage(ChatColor.RED + "A item in the chest/inventory you just opened has been renamed to it's default name because It was over 32 characters long.");
            }
        }
    }
}
