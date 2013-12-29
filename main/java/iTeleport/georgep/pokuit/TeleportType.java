package iTeleport.georgep.pokuit;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * Created by George on 28/12/13.
 */
public abstract class TeleportType implements Listener {

    public Player player;

    public ArrayList<TeleportStage> stages = new ArrayList<TeleportStage>();

    protected abstract void addStages();

    public final void teleport(final Player p) {
        this.stages.clear();
        addStages();
        long curTimeout = 0;
        for(final TeleportStage s : stages) {
            iTeleport.getInstance().getLogger().info("running stage ----"+s.getTime()+" "+curTimeout);
            new BukkitRunnable() {
                @Override
                public void run() {
                    iTeleport.getInstance().getLogger().info("running stage");
                    s.runStage(p);
                }
            }.runTaskLater(iTeleport.getInstance(), curTimeout);
            //Plus how long this task will take and turn it into ig ticks
            curTimeout += (s.getTime()*0.02);
        }
    }
}
