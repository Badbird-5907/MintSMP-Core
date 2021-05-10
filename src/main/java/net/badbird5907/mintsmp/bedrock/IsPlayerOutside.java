package net.badbird5907.mintsmp.bedrock;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class IsPlayerOutside implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event){
        //is BE player
        if(event.getPlayer().getDisplayName().startsWith("*") || event.getPlayer().getName().startsWith("*")){
            if(isOutsideOfBorder(event.getPlayer())){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "You're at the world border!");
            }
        }
    }
    @EventHandler
    public void onTeleport(PlayerTeleportEvent event){
        if(event.getPlayer().getDisplayName().startsWith("*") || event.getPlayer().getName().startsWith("*")){
            if(isOutsideOfBorder(event.getTo())){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "Your pearl landed outside the border!");
            }
        }
    }
    public static boolean isOutsideOfBorder(Player p) {
        Location loc = p.getLocation();
        WorldBorder border = p.getWorld().getWorldBorder();
        double size = border.getSize()/2;
        Location center = border.getCenter();
        double x = loc.getX() - center.getX(), z = loc.getZ() - center.getZ();
        return ((x > size || (-x) > size) || (z > size || (-z) > size));
    }
    public static boolean isOutsideOfBorder(Location loc) {
        WorldBorder border = loc.getWorld().getWorldBorder();
        double size = border.getSize()/2;
        Location center = border.getCenter();
        double x = loc.getX() - center.getX(), z = loc.getZ() - center.getZ();
        return ((x > size || (-x) > size) || (z > size || (-z) > size));
    }
}
