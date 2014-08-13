package uk.co.georgep.iteleport;

import lombok.Data;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

import static uk.co.georgep.iteleport.utils.JsonUtils.jsonArrayToStringArray;

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
@Data
public class TeleportType implements Listener {

    public final String name;
    public final String version;
    public final String[] authors;

    public final HeadPosition headPosition;

    public final MovementType[] disabledMovement;

    public final Integer maxStages;
    public final TeleportStage[] stages;
    public final TeleportStage defaultStage;

   /* public final void use(final Player p, final Plugin plugin) {
        addStages();
        long curTimeout = 0;
        for (final TeleportStage s : stages) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    s.runStage(p, new TeleportHandler(plugin, p));
                }
            }.runTaskLater(plugin, curTimeout);
            //Plus how long this task will take and turn it into in-game ticks
            curTimeout += (s.getTime() * 0.02);
        }
    }*/

    public static TeleportType fromJsonObject(JSONObject teleportType) {
        String name = (String) teleportType.get("name");
        String version = (String) teleportType.get("version");

        String[] authors = jsonArrayToStringArray((JSONArray) teleportType.get("authors"));

        TeleportType.HeadPosition headPosition = HeadPosition.fromJsonObject(
                (JSONObject) teleportType.get("headPosition")
        );

        TeleportType.MovementType[] disabledMovement = TeleportType.MovementType.toMovementTypeArray(
                jsonArrayToStringArray((JSONArray) teleportType.get("disabledMovement"))
        );

        Integer maxStages = (Integer) teleportType.get("maxStages");

        TeleportStage[] stages = TeleportStage.fromJsonArray((JSONArray) teleportType.get("stages"));

        TeleportStage defaultStage = TeleportStage.fromJsonObject((JSONObject) teleportType.get("defaultStage"));

        return new TeleportType(
            name,
            version,
            authors,
            headPosition,
            disabledMovement,
            maxStages,
            stages,
            defaultStage
        );
    }

    @Data
    public static class HeadPosition {
        public final Integer pitch;
        public final Integer yaw;

        public static HeadPosition fromJsonObject(JSONObject headPositionObject) {
            return new HeadPosition(
                    headPositionObject == null ? 0 : (Integer) headPositionObject.get("pitch"),
                    headPositionObject == null ? 0 : (Integer) headPositionObject.get("yaw")
            );
        }
    }

    public static enum MovementType {
        X,
        Y,
        Z,
        PITCH,
        YAW;

        public static MovementType[] toMovementTypeArray(String[] strings) {
            List<MovementType> movementList = new ArrayList<>();

            MovementType movementType;
            for (String movement : strings) {
                try {
                    movementType = MovementType.valueOf(movement.trim().toUpperCase());
                } catch (Exception exception) {
                    continue;
                }

                movementList.add(movementType);
            }

            return movementList.toArray(new MovementType[movementList.size()]);
        }
    }
}
