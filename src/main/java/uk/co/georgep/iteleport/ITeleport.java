package uk.co.georgep.iteleport;

import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 28/12/13
 */
public class ITeleport extends JavaPlugin implements Listener {

    @Getter
    public static ITeleport instance;

    public TeleportTypeLoader ttl;

    @Override
    public void onEnable() {
        instance = this;


        ttl = new TeleportTypeLoader(this);

        //I know you shouldn't have listeners in main class just testing
        //getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }
/*
    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent e) {

        ttl.use("medieval1", e.getPlayer());

    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
            getLogger().info("testtestsetsteetste");
    }*/
}
