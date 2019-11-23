package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Specifies the Primary Key of the table column.
 */
@Target(ElementType.FIELD)
public @interface Key {

    /**
     * Specifies the index of the key property.
     * 
     * @return The order of the index.
     */
    public int order() default 0;
}
