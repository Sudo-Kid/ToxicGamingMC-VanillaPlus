package win.toxicgaming.vanillaplus.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;


public class ChunkLoaderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        Location playerLocation = player.getLocation();
        World world = player.getWorld();
        UUID worldUID = world.getUID();
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Player Location: " + playerLocation + " WorldUID: " + worldUID);

        return true;
    }
}
