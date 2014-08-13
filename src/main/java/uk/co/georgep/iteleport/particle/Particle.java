package uk.co.georgep.iteleport.particle;

import lombok.Data;

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
@Data
public class Particle {

    public final ParticleType type;

    public final Integer duration;

    public final Integer afterDelay;
}
