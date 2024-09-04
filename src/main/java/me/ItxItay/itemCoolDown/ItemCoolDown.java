package me.ItxItay.itemCoolDown;

import me.ItxItay.itemCoolDown.Commands.CreditCommand;
import me.ItxItay.itemCoolDown.Commands.ReloadItemCoolDowns;
import me.ItxItay.itemCoolDown.Listeners.DisableItemsWithCooldownListener;
import me.ItxItay.itemCoolDown.Listeners.onItemClickListener;
import me.ItxItay.itemCoolDown.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ItemCoolDown extends JavaPlugin {

    Logger logger = getLogger();

    @Override
    public void onEnable() {
        logger.info("Programmed by ItxItay and NAMD");
        logger.info("Contact us: https://github.com/ItxItayAndNotAMojangDev");
        Config.init(this);
        getCommand("reloaditemcooldows").setExecutor(new ReloadItemCoolDowns());
        getCommand("cooldowns-credit").setExecutor(new CreditCommand());
        Bukkit.getPluginManager().registerEvents(new onItemClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new DisableItemsWithCooldownListener(), this);

    }

    @Override
    public void onDisable() {
        logger.info("Programmed by ItxItay and NAMD");
        logger.info("Contact us: https://github.com/ItxItayAndNotAMojangDev");
    }
}
