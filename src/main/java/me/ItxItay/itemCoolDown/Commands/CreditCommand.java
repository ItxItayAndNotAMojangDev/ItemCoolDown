package me.ItxItay.itemCoolDown.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CreditCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        sender.sendMessage("§aPlugin made by ItxItay & NAMD");
        sender.sendMessage("§f - §cItxItay §f- §b§nhttps://github.com/itxitay");
        sender.sendMessage("§f - §cNotAMojangDev §b§nhttps:://github.com/NotAMojangDev");
        return false;
    }
}
