package uk.co.georgep.iteleport.utils;

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
public class ThreeDUtils {
    public static void cuboidAreaLoop(Integer width, Integer height, Integer length, CuboidAreaLoopCallback callback) {
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                for (int z = 0; z < length; ++z) {
                    callback.nextBlock(x, y, z);
                }
            }
        }
    }

    public interface CuboidAreaLoopCallback {
        public void nextBlock(Integer x, Integer y, Integer z);
    }
}
