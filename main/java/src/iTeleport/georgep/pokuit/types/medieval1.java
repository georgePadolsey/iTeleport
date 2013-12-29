package iTeleport.georgep.pokuit.types;

import iTeleport.georgep.pokuit.TeleportStage;
import iTeleport.georgep.pokuit.TeleportType;
import iTeleport.georgep.pokuit.TeleportTypeMeta;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by George on 28/12/13.
 */
@TeleportTypeMeta(
        name = "medieval1",
        maxTime = 5
)
public class medieval1 extends TeleportType {


    @Override
    protected void addStages() {
        stages.add(new TeleportStage() {
            @Override
            public void runStage() {

            }

            @Override
            public long getTime() {
                return 2000;
            }
        } );
    }
}