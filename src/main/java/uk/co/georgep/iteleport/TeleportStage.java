package uk.co.georgep.iteleport;

import lombok.Data;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONUtil;
import org.bukkit.entity.Player;
import uk.co.georgep.iteleport.particle.Particle;
import uk.co.georgep.iteleport.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import static uk.co.georgep.iteleport.utils.JsonUtils.jsonArrayToJsonObjectArray;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 29/12/13
 */
@Data
public class TeleportStage {

    public final String schematic;
    public final Boolean repeatParticles;

    public final Integer duration;
    public final Integer afterDelay;

    public final Integer maxParticles;
    public final Particle[] particles;
    public final Particle defaultParticle;


    public static TeleportStage[] fromJsonArray(JSONArray teleportStages) {

        List<TeleportStage> teleportStageList = new ArrayList<>();

        JSONObject[] teleportStagesArray = jsonArrayToJsonObjectArray(teleportStages);

        for(JSONObject teleportStage : teleportStagesArray) {
            teleportStageList.add(TeleportStage.fromJsonObject(teleportStage));
        }

        return teleportStageList.toArray(new TeleportStage[teleportStageList.size()]);

    }

    public static TeleportStage fromJsonObject(JSONObject teleportStage) {

        String schematic = (String) teleportStage.get("schematic");

        Boolean repeatParticle = (Boolean) teleportStage.get("repeatParticles");

        Integer duration = (Integer) teleportStage.get("duration");

        Integer afterDelay = (Integer) teleportStage.get("afterDelay");

        Integer maxParticles = (Integer) teleportStage.get("maxParticles");

        Particle[] particles = Particle.fromJsonArray();


    }
}
