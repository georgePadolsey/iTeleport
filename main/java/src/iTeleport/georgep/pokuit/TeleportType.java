package iTeleport.georgep.pokuit;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * Created by George on 28/12/13.
 */
public abstract class TeleportType {

    public ArrayList<TeleportStage> stages = new ArrayList<TeleportStage>();

    protected abstract void addStages();

    public final void teleport() {
        long curTimeout = 0;
        for(final TeleportStage s : stages) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    s.runStage();
                }
            }.runTaskLater(iTeleport.getInstance(), s.getTime() + curTimeout);
            curTimeout += s.getTime();
        }
    }
}
