package me.ItxItay.itemCoolDown.Listeners;

import me.ItxItay.itemCoolDown.util.Config;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class onItemClickListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemClick(@NotNull PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack mainHandItem = event.getItem();

        if (event.getAction().equals(Action.PHYSICAL)) return;
        if (player.hasCooldown(mainHandItem.getType())) {event.setCancelled(true); return;}
        int cooldown = Config.getCooldown(mainHandItem.getType());
        if (cooldown <= 0) return;
        player.setCooldown(mainHandItem.getType(), cooldown);


    }

}
