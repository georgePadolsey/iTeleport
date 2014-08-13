package uk.co.georgep.iteleport.particle;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import uk.co.georgep.iteleport.utils.NMSPacket;
import uk.co.georgep.iteleport.utils.NMSPacketUtils;
import uk.co.georgep.iteleport.utils.ReflectionUtils;

public enum ParticleType {

    HUGE_EXPLOSION("hugeexplosion"),
    LARGE_EXPLODE("largeexplode"),
    FIREWORKS_SPARK("fireworksSpark"),
    BUBBLE("bubble"),
    SUSPEND("suspend"),
    DEPTH_SUSPEND("depthSuspend"),
    TOWN_AURA("townaura"),
    CRIT("crit"),
    MAGIC_CRIT("magicCrit"),
    MOB_SPELL("mobSpell"),
    MOB_SPELL_AMBIENT("mobSpellAmbient"),
    SPELL("spell"),
    INSTANT_SPELL("instantSpell"),
    WITCH_MAGIC("witchMagic"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    EXPLODE("explode"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    SPLASH("splash"),
    LARGE_SMOKE("largesmoke"),
    CLOUD("cloud"),
    RED_DUST("reddust"),
    SNOWBALL_POOF("snowballpoof"),
    DRIP_WATER("dripWater"),
    DRIP_LAVA("dripLava"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    ANGRY_VILLAGER("angryVillager"),
    HAPPY_VILLAGER("happerVillager"),
    ICONCRACK("iconcrack_"),
    TILECRACK("tilecrack_");

    private String particleName;

    ParticleType(String particleName) {
        this.particleName = particleName;
    }

    public void sendToPlayer(Player player, Location location, float offsetX, float offsetY, float offsetZ, float speed, int count) throws Exception {
        NMSPacket packet = new NMSPacket("PacketPlayOutWorldParticles");
        ReflectionUtils.setValue(packet, "a", particleName);
        ReflectionUtils.setValue(packet, "b", (float) location.getX());
        ReflectionUtils.setValue(packet, "c", (float) location.getY());
        ReflectionUtils.setValue(packet, "d", (float) location.getZ());
        ReflectionUtils.setValue(packet, "e", offsetX);
        ReflectionUtils.setValue(packet, "f", offsetY);
        ReflectionUtils.setValue(packet, "g", offsetZ);
        ReflectionUtils.setValue(packet, "h", speed);
        ReflectionUtils.setValue(packet, "i", count);
        NMSPacketUtils.sendPacket(player, packet);
    }

}