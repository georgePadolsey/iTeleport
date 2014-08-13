package uk.co.georgep.iteleport;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 01/01/14
 */
public class TeleportHandler implements Listener {

    Player player = null;
    Plugin plugin = null;

    int pitch = -1;
    int yaw = -1;

    @Getter
    ArrayList<TeleportType.MovementType> movementNotAllowed = new ArrayList<>();

    public TeleportHandler(Plugin plugin, Player player) {
        this.player = player;
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void addMovementNotAllowed(TeleportType.MovementType movement) {
        this.movementNotAllowed.add(movement);
    }

    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent e) {
        if (e.getPlayer().equals(player)) {

            // I've tested and it does run this
            Location newLoc = e.getTo().clone();

            if (this.pitch != -1) {
                newLoc.setPitch(pitch);
                pitch = -1;
            }

            if (this.yaw != -1) {
                newLoc.setYaw(yaw);
                yaw = -1;
            }


            //I've tested this and it does run all of these if statement's
            if (this.movementNotAllowed.contains(TeleportType.MovementType.X)) newLoc.setX(e.getFrom().getX());
            if (this.movementNotAllowed.contains(TeleportType.MovementType.Y)) newLoc.setY(e.getFrom().getY());
            if (this.movementNotAllowed.contains(TeleportType.MovementType.Z)) newLoc.setZ(e.getFrom().getZ());
            if (this.movementNotAllowed.contains(TeleportType.MovementType.PITCH))
                newLoc.setPitch(e.getFrom().getPitch());
            if (this.movementNotAllowed.contains(TeleportType.MovementType.YAW)) newLoc.setYaw(e.getFrom().getYaw());

            e.setTo(newLoc);
        }
    }

    @NonNull
    public void setYaw(int i) {
        this.player.setVelocity(new Vector(0.00, 0.05, 0.00));
        this.yaw = i;
    }

    @NonNull
    public void setPitch(int i) {
        this.player.setVelocity(new Vector(0.00, 0.05, 0.00));
        this.pitch = i;
    }
}
