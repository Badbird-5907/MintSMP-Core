package net.badbird5907.mintsmp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ColorCodesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String msg =
                ChatColor.GOLD + "Color codes:\n" +
                        ChatColor.GREEN + "Green = &a\n"
                        + ChatColor.GOLD + "Gold = &6\n"
                        + ChatColor.YELLOW + "Yellow = &e\n"
                        + ChatColor.BLACK + "Black = &0\n"
                        + ChatColor.DARK_GRAY + "Dark Gray = &8\n"
                        + ChatColor.GRAY + "Gray = &7\n"
                        + ChatColor.DARK_BLUE + "Dark Blue = &1\n"
                        + ChatColor.BLUE + "Light Blue / Aqua = &b\n"
                        + ChatColor.DARK_PURPLE + "Purple = &5\n"
                        + ChatColor.LIGHT_PURPLE + "Light Purple = &d\n"
                + ChatColor.GRAY + "You can find a full list here: \nhttps://wiki.ess3.net/mc/\nhttps://www.digminecraft.com/lists/color_list_pc.php"
                ;
        sender.sendMessage(msg);
        return true;
    }
}
