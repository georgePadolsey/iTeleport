package iTeleport.georgep.pokuit;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

/**
 * Created by George on 29/12/13.
 */
public class TeleportTypeLoader {

    Plugin plugin = null;
    private ArrayList<TeleportType> teleportTypes = new ArrayList<TeleportType>();

    public TeleportTypeLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public void addTeleportType(TeleportType teleportType) {
        teleportTypes.add(teleportType);
    }

    public void use(String name, Player p) {
        for(TeleportType teleportType : teleportTypes) {
            if(name.equalsIgnoreCase(teleportType.getClass().getAnnotation(TeleportTypeMeta.class).name())) {
                teleportType.teleport(p);
                return;
            }
        }
        ///create new type of exception
        try {
            throw new Exception("meeep");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
