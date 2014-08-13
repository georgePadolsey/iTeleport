package uk.co.georgep.iteleport;

/**
 * todo File Description
 *
 * <p>
 * Latest Change:
 * <p>
 *
 * @author George
 * @since 28/12/13
 */

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TeleportTypeMeta {

    String name();

    /**
     * take credit before I do >:)
     *
     * @return the author of it
     */
    String author() default "George Padolsey <georgepadolsey@gmail.com>";

    int maxTime();

}
