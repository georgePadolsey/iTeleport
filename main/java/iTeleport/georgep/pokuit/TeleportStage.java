package iTeleport.georgep.pokuit;

import org.bukkit.entity.Player;

/**
 * Created by George on 29/12/13.
 */
public interface TeleportStage {

    public void runStage(Player p);

    public long getTime();

}
