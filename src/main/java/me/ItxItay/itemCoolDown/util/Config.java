package me.ItxItay.itemCoolDown.util;

import me.ItxItay.itemCoolDown.ItemCoolDown;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public class Config {

    private static ItemCoolDown plugin;
    private static FileConfiguration config;
    private static final HashMap<Material, Integer> itemCooldowns = new HashMap<>();

    private Config() {}

    public static void init(ItemCoolDown plugin) {
        Config.plugin = plugin;
        Config.config = plugin.getConfig();
        plugin.saveDefaultConfig();
        reloadConfig();
    }

    /**
     * Reloads the plugin config
     */
    public static void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();

        Config.itemCooldowns.clear();

        List<String> itemCooldowns = config.getStringList("Item-CoolDowns");

        itemCooldowns.forEach(element -> {
            String[] data = element.split(";");
            Material materialType = Material.valueOf(data[0].toUpperCase());
            Integer number = Integer.valueOf(data[1]);
            Config.itemCooldowns.put(materialType, number * 20);
        });
    }

    /**
     * returns the cooldown an item should have
     * @param material the material to check for
     * @return Integer is it exists, Null if it doesn't
     */
    @Nullable
    public static int getCooldown(Material material) {
        return itemCooldowns.getOrDefault(material, -1);
    }

}
