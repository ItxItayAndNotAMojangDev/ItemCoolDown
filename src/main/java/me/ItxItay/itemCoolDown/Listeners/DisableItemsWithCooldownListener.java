package me.ItxItay.itemCoolDown.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DisableItemsWithCooldownListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteract(final @NotNull PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final ItemStack itemInUse = player.getInventory().getItemInMainHand();

        if (itemInUse.getType().equals(Material.AIR)) return;

        if (player.hasCooldown(itemInUse.getType())) event.setCancelled(true);


    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(final @NotNull EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;

        final ItemStack itemInUse = player.getInventory().getItemInMainHand();

        if (itemInUse.getType().equals(Material.AIR)) return;

        if (player.hasCooldown(itemInUse.getType())) event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(final @NotNull BlockBreakEvent event) {
        final Player player = event.getPlayer();

        final ItemStack itemInUse = player.getInventory().getItemInMainHand();

        if (itemInUse.getType().equals(Material.AIR)) return;

        if (player.hasCooldown(itemInUse.getType())) event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onConsume(PlayerItemConsumeEvent event) {
        final Player player = event.getPlayer();

        final ItemStack itemInUse = player.getInventory().getItemInMainHand();

        if (itemInUse.getType().equals(Material.AIR)) return;

        if (player.hasCooldown(itemInUse.getType())) event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteractEntity(PlayerInteractAtEntityEvent event) {
        final Player player = event.getPlayer();

        final ItemStack itemInUse = player.getInventory().getItemInMainHand();

        if (itemInUse.getType().equals(Material.AIR)) return;

        if (player.hasCooldown(itemInUse.getType())) event.setCancelled(true);
    }
}
