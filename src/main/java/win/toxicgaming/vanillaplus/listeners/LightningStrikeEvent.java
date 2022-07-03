package win.toxicgaming.vanillaplus.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class LightningStrikeEvent implements Listener {
    private static final int RADIUS = 10;
    private static final Random RANDOM = new Random();

    @EventHandler
    public void onLightingHitSandEvent(org.bukkit.event.weather.LightningStrikeEvent event)
    {
        Block block = event.getLightning().getLocation().subtract(0, 1, 0).getBlock();

        if (block.getType() == Material.LIGHTNING_ROD)
        {
            block = block.getLocation().subtract(0, 1, 0).getBlock();
        }

        if (block.getType() != Material.SAND) return;

        block.setType(Material.GLASS, true);

        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();

        for (int i = 0; i < RADIUS; ++i) {
            int direction = RANDOM.nextInt(10);

            if (i == 0)
            {
                y -= 1;
            }
            else {
                switch (direction) {
                    case 0 -> ++x;
                    case 1 -> --x;
                    case 2 -> ++z;
                    case 3 -> --z;
                    default -> --y;
                }
            }

            block = event.getWorld().getBlockAt(x, y, z);
            if (block.getType() == Material.SAND) {
                block.setType(Material.GLASS);
            }
        }
    }
}
