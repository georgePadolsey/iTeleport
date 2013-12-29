package iTeleport.georgep.pokuit.types;

import iTeleport.georgep.pokuit.TeleportStage;
import iTeleport.georgep.pokuit.TeleportType;
import iTeleport.georgep.pokuit.TeleportTypeMeta;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/**
 * Created by George on 28/12/13.
 */
@TeleportTypeMeta(
        name = "medieval1",
        maxTime = 2000
)
public class medieval1 extends TeleportType {

    @Override
    protected void addStages() {
        stages.add(new TeleportStage() {
            @Override
            public void runStage(Player p) {
                p.sendBlockChange(p.getLocation().subtract(0, 1, 0), Material.BEACON, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(0, 2, 0), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(1, 2, 0), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(0, 2, 1), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(1, 2, 1), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(-1, 2, 0), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(0, 2, -1), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(-1, 2, -1), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(1, 2, -1), Material.DIAMOND_BLOCK, (byte) 0);
                p.sendBlockChange(p.getLocation().subtract(-1, 2, 1), Material.DIAMOND_BLOCK, (byte) 0);
                p.setVelocity(new Vector(0, 5, 0));
            }

            @Override
            public long getTime() {
                return 2000;
            }
        } );
        stages.add(new TeleportStage() {
            @Override
            public void runStage(Player p) {
                p.sendMessage("I HATE YOU SO MUCH MORE");
            }

            @Override
            public long getTime() {
                return 0;
            }
        } );
    }

}