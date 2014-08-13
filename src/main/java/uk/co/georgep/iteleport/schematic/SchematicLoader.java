/*
* -- > Re-written version of https://forums.bukkit.org/threads/pasting-loading-schematics.87129/ <--
*/

package uk.co.georgep.iteleport.schematic;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jnbt.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import static uk.co.georgep.iteleport.utils.ThreeDUtils.cuboidAreaLoop;

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
public class SchematicLoader {

    public static void pasteSchematic(Location loc, Schematic schematic, boolean ignoreAir) {
        loopSchematicBlocks(loc, schematic, (Location location, Material material, Byte data) -> {
            if (ignoreAir && material.equals(Material.AIR)) return;
            Block b = location.getBlock();
            b.setType(material);
            b.setData(data);
        });

    }

    public static void showSchematicToPlayer(Player player, Location loc, Schematic schematic, boolean ignoreAir) {

        loopSchematicBlocks(loc, schematic,
                (Location location, Material material, Byte data) -> {
                    if (ignoreAir && material.equals(Material.AIR)) return;
                    player.sendBlockChange(location, material, data);
                }
        );

    }

    public static void loopSchematicBlocks(Location loc, Schematic schematic, SchematicLoopCallback callback) {
        Byte[] blocks = schematic.getBlocks();
        Byte[] blockData = schematic.getData();

        short length = schematic.getLength();
        short width = schematic.getWidth();
        short height = schematic.getHeight();

        cuboidAreaLoop(
                (int) width, (int) height, (int) length,
                (Integer x, Integer y, Integer z) -> {
                    int index = y * width * length + z * width + x;
                    callback.nextBlock(
                            new Location(loc.getWorld(), x + loc.getX(), y + loc.getY(), z + loc.getZ()),
                            Material.getMaterial(blocks[index]),
                            blockData[index]
                    );
                }
        );
    }

    public static Schematic loadSchematic(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        NBTInputStream nbtStream = new NBTInputStream(new GZIPInputStream(stream));

        CompoundTag schematicTag = (CompoundTag) nbtStream.readTag();
        if (!schematicTag.getName().equals("Schematic")) {
            throw new IllegalArgumentException("Tag \"Schematic\" does not exist or is not first");
        }

        Map<String, Tag> schematic = schematicTag.getValue();
        if (!schematic.containsKey("Blocks")) {
            throw new IllegalArgumentException("Schematic file is missing a \"Blocks\" tag");
        }

        short width = getChildTag(schematic, "Width", ShortTag.class).getValue();
        short length = getChildTag(schematic, "Length", ShortTag.class).getValue();
        short height = getChildTag(schematic, "Height", ShortTag.class).getValue();

        String materials = getChildTag(schematic, "Materials", StringTag.class).getValue();

        if (!materials.equals("Alpha"))
            throw new IllegalArgumentException("Schematic file is not an Alpha schematic");

        // Convert byte[] to Byte[]
        Byte[] blocks = ArrayUtils.toObject(getChildTag(schematic, "Blocks", ByteArrayTag.class).getValue());
        Byte[] blockData = ArrayUtils.toObject(getChildTag(schematic, "Data", ByteArrayTag.class).getValue());
        return new Schematic(blocks, blockData, width, length, height);
    }

    /**
     * Get child tag of a NBT structure.
     *
     * @param items    The parent tag map
     * @param key      The name of the tag to get
     * @param expected The expected type of the tag
     * @return child tag casted to the expected type
     * @throws java.lang.IllegalArgumentException if the tag does not exist or the tag is not of the
     *                                            expected type
     */
    private static <T extends Tag> T getChildTag(Map<String, Tag> items, String key, Class<T> expected) throws IllegalArgumentException {
        if (!items.containsKey(key)) {
            throw new IllegalArgumentException("Schematic file is missing a \"" + key + "\" tag");
        }
        Tag tag = items.get(key);
        if (!expected.isInstance(tag)) {
            throw new IllegalArgumentException(key + " tag is not of tag type " + expected.getName());
        }
        return expected.cast(tag);
    }

    /**
     * The Callback used when looping through a schematics blocks
     */
    public interface SchematicLoopCallback {
        public void nextBlock(Location location, Material material, Byte data);
    }
}
