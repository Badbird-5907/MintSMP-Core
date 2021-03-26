package net.badbird5907.mintsmp.listeners;

import net.badbird5907.mintsmp.MintSMP;
import net.badbird5907.mintsmp.team.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(!MintSMP.getUsers().containsKey(event.getPlayer().getUniqueId())){
            User user = new User(event.getPlayer().getUniqueId());
            MintSMP.getUsers().put(event.getPlayer().getUniqueId(),user);
        }
    }
}
