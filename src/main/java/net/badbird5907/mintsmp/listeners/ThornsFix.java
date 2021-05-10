package net.badbird5907.mintsmp.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ThornsFix implements Listener{
    public void onDamage(EntityDamageEvent event){
        if(event.getCause() == EntityDamageEvent.DamageCause.THORNS){
            try{
                if(event.getEntity() instanceof LivingEntity){
                    LivingEntity livingEntity = (LivingEntity) event.getEntity();
                    livingEntity.setNoDamageTicks(0);
                }
            } catch (Exception e) { }
        }
    }
}
