package net.badbird5907.mintsmp;

import com.google.gson.Gson;
import lombok.Getter;
import net.badbird5907.mintsmp.bedrock.IsPlayerOutside;
import net.badbird5907.mintsmp.commands.ColorCodesCommand;
import net.badbird5907.mintsmp.commands.RenameCommand;
import net.badbird5907.mintsmp.listeners.ThornsFix;
import net.badbird5907.mintsmp.team.User;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

@Getter
public final class MintSMP extends JavaPlugin {
    @Getter
    private static MintSMP instance;
    @Getter
    private static Gson gson = new Gson();
    @Getter
    private static HashMap<UUID, User> users = new HashMap<>();
    @Override
    public void onEnable() {
        instance = this;
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("colorcodes").setExecutor(new ColorCodesCommand());
        Bukkit.getServer().getPluginManager().registerEvents(new IsPlayerOutside(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new ThornsFix(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
