package me.ItxItay.itemCoolDown.Commands;

import me.ItxItay.itemCoolDown.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadItemCoolDowns implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Config.reloadConfig();
        sender.sendMessage("§aThe config has been reloaded successfully!");
        return false;
    }
}
