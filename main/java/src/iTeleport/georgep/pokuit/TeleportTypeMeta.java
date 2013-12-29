package iTeleport.georgep.pokuit;

/**
 * Created by George on 28/12/13.
 */

import javax.lang.model.element.Element;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TeleportTypeMeta {

    String name();

    /**
     * take credit before I do >:)
     * @return the author of it
     */
    String author() default "George Padolsey <georgepadolsey@gmail.com>";

    int maxTime();

}
