package iTeleport.georgep.pokuit;

import iTeleport.georgep.pokuit.types.medieval1;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by George on 28/12/13.
 */
public class iTeleport extends JavaPlugin {

    public static iTeleport curInstance;

    @Override
    public void onEnable() {
        curInstance = this;
    }

    @Override
    public void onDisable() {

    }

    public static iTeleport getInstance() {
        return curInstance;
    }
}
