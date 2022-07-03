package win.toxicgaming.vanillaplus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import win.toxicgaming.vanillaplus.commands.ChunkLoaderCommand;
import win.toxicgaming.vanillaplus.listeners.LightningStrikeEvent;

import java.util.List;

public final class VanillaPlus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VanillaPlus has been enabled");
        PluginManager pluginManager = getServer().getPluginManager();
        Plugin plugin = pluginManager.getPlugin("VanillaPlus");

        PluginCommand toxicLoadChunk = getCommand("toxic-load-chunk");
        if (toxicLoadChunk != null)
        {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VanillaPlus chunk loader enabled");
            toxicLoadChunk.setExecutor(new ChunkLoaderCommand());
        }

        registerEvents(pluginManager);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "VanillaPlus Plugin: " + plugin);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "VanillaPlus has been Disabled");
    }

    private void registerEvents(PluginManager pluginManager)
    {
        pluginManager.registerEvents(new LightningStrikeEvent(), this);
    }
}
