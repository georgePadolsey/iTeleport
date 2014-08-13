package uk.co.georgep.iteleport.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

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
public class NMSPacketUtils {

    private static String packageName = Bukkit.getServer().getClass().getPackage().getName();
    private static String version = packageName.substring(packageName.lastIndexOf(".") + 1);

    public static void sendPacket(Player plyr, Object o) {
        try {
            Class<?> packet = Class.forName("net.minecraft.server." + version + ".Packet");
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");

            if (!packet.isAssignableFrom(o.getClass())) {
                throw new IllegalArgumentException("Object o wasn't a packet!");
            }

            Object cp = craftPlayer.cast(plyr);
            Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
            Object con = handle.getClass().getField("playerConnection").get(handle);
            con.getClass().getMethod("sendPacket", packet).invoke(con, o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendPackets(Object o) {
        try {
            Class<?> packet = Class.forName("net.minecraft.server." + version + ".Packet");
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
            for (Player plyr : Bukkit.getOnlinePlayers()) {
                if (!packet.isAssignableFrom(o.getClass())) {
                    throw new IllegalArgumentException("Object o wasn't a packet!");
                }

                Object cp = craftPlayer.cast(plyr);
                Object handle = craftPlayer.getMethod("getHandle").invoke(cp);
                Object con = handle.getClass().getField("playerConnection").get(handle);
                con.getClass().getMethod("sendPacket", packet).invoke(con, o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
