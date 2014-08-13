package uk.co.georgep.iteleport.utils;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import uk.co.georgep.iteleport.TeleportStage;

import java.util.ArrayList;
import java.util.List;

/**
 * todo File Description
 * <p/>
 * <p/>
 * Latest Change:
 * <p/>
 *
 * @author George
 * @since 12/07/2014
 */
public class JsonUtils {
    public static String[] jsonArrayToStringArray(JSONArray stringArray) {
        return stringArray.toArray(new String[stringArray.size()]);
    }

    public static JSONObject[] jsonArrayToJsonObjectArray(JSONArray objectArray) {
        return objectArray.toArray(new JSONObject[objectArray.size()]);
    }
}
