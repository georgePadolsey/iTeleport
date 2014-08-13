package uk.co.georgep.iteleport.utils;

import org.bukkit.Bukkit;

import java.lang.reflect.Field;

public class NMSPacket {

    private static String packageName = Bukkit.getServer().getClass().getPackage().getName();
    private static String version = packageName.substring(packageName.lastIndexOf(".") + 1);

    private Object packet;
    private Class<?> nmsPacket;

    public NMSPacket(String packetName) {
        try {
            nmsPacket = Class.forName("net.minecraft.server." + version + "." + packetName);
            packet = nmsPacket.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            packet = null;
            nmsPacket = null;
        }

    }

    public void setField(String fieldName, Object value) {
        try {
            Field f = packet.getClass().getField(fieldName);
            f.setAccessible(true);
            f.set(packet, value);
            f.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDeclaredField(String fieldName, Object value) {
        try {
            Field f = packet.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(packet, value);
            f.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getField(String fieldName) {
        try {
            Field f = packet.getClass().getField(fieldName);
            f.setAccessible(true);
            Object s = f.get(packet);
            f.setAccessible(false);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getDeclaredField(String fieldName) {
        try {
            Field f = packet.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            Object s = f.get(packet);
            f.setAccessible(false);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class<?> getPacketClass() {
        return nmsPacket;
    }

    public Object getPacket() {
        return packet;
    }

    public boolean isUsable() {
        return packet != null;
    }

}