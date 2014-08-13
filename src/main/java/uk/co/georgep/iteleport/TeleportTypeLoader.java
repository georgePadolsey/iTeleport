package uk.co.georgep.iteleport;

import lombok.Cleanup;
import lombok.extern.java.Log;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

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
@Log
public class TeleportTypeLoader {

    JavaPlugin plugin = null;

    public TeleportTypeLoader(JavaPlugin plugin) {

        this.plugin = plugin;

        addTeleportType("/syfy1.json");
    }

/*    public void addTeleportType(File teleportFile) {

        @Cleanup InputStream teleportStream = null;
        try {
            teleportStream = new BufferedReader(new FileReader(teleportFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        addTeleportType(teleportStream);
    }*/

    public void addTeleportType(String fileName) {

        @Cleanup InputStream inputStream = getClass().getResourceAsStream(fileName);

        if (inputStream == null) return;
        JSONObject jsonObject = (JSONObject) JSONValue.parse(new InputStreamReader(inputStream));

        TeleportType teleportType = TeleportType.fromJsonObject(jsonObject);
    }

/*
    public void use(String name, Player p) {
        for (TeleportType teleportType : teleportTypes) {
            if (name.equalsIgnoreCase(teleportType.getClass().getAnnotation(TeleportTypeMeta.class).name())) {
                teleportType.use(p, plugin);
                return;
            }
        }
        ///create new type of exception
        try {
            throw new Exception("meeep");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
