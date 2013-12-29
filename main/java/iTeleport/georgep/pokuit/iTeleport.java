package iTeleport.georgep.pokuit;

import iTeleport.georgep.pokuit.types.medieval1;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by George on 28/12/13.
 */
public class iTeleport extends JavaPlugin implements Listener {

    public static iTeleport curInstance;
    public TeleportTypeLoader ttl;

    @Override
    public void onEnable() {
        ttl = new TeleportTypeLoader(this);
        curInstance = this;
        //I know you shouldn't have listeners in main class just testing
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    public static iTeleport getInstance() {
        return curInstance;
    }

    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent e) {

        ttl.use("medieval1", e.getPlayer());

    }
}
