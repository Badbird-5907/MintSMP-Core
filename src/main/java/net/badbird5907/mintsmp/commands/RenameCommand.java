package net.badbird5907.mintsmp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            if(args.length >= 1){
                StringBuilder sb = new StringBuilder();
                int i = -1;
                for (String arg : args) {
                    sb.append((i==0)?arg : " " + arg);
                }
                if(containsUnicode(sb.toString())){
                    sender.sendMessage(ChatColor.RED + "You may not use unicode!");
                    return true;
                }
                String name = ChatColor.translateAlternateColorCodes('&',sb.toString());
                Player p = ((Player) sender).getPlayer();
                if(p.getLevel() > 1){
                    p.setLevel(p.getLevel()-1);
                    ItemStack currentItem = p.getInventory().getItemInMainHand();
                    ItemMeta meta = currentItem.getItemMeta();
                    meta.setDisplayName(name.replaceAll("\\n","\n"));
                    p.getInventory().getItemInMainHand().setItemMeta(meta);
                    p.sendMessage(ChatColor.GREEN + "Set your item name to: " + name);
                }else{
                    p.sendMessage(ChatColor.RED + "You need at least 1 xp level to rename!");
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Usage: /rename [name]\nDo /colorcodes for a list of color codes");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "This is player-only!1!!!11!!");
        }
        return true;
    }
    private static boolean containsUnicode(String message){
        Pattern p = Pattern.compile("[^a-z0-9~!@#$%^&*()_+-={}\\[\\]|:\";'<>?,./\\\\    ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(message);
        boolean b = m.find();

        if (b)
            return true;
        else return false;
    }
}
