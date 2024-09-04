package me.ItxItay.itemCoolDown.Listeners;

import me.ItxItay.itemCoolDown.util.Config;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class onItemClickListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onItemClick(@NotNull PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack mainHandItem = event.getItem();

        if (mainHandItem == null || mainHandItem.getType().equals(Material.AIR)) return;
        if (event.getAction().equals(Action.PHYSICAL)) return;
        if (player.hasCooldown(mainHandItem.getType())) {event.setCancelled(true); return;}
        int cooldown = Config.getCooldown(mainHandItem.getType());
        if (cooldown <= 0) return;
        player.setCooldown(mainHandItem.getType(), cooldown);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onInteractAtEntityEvent(@NotNull EntityDamageByEntityEvent event){
        if (!(event.getDamager() instanceof Player player)) return;
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        if (mainHandItem == null || mainHandItem.getType().equals(Material.AIR)) return;
        if (player.hasCooldown(mainHandItem.getType())) {event.setCancelled(true); return;}
        int cooldown = Config.getCooldown(mainHandItem.getType());
        if (cooldown <= 0) return;
        player.setCooldown(mainHandItem.getType(), cooldown);
    }


}
