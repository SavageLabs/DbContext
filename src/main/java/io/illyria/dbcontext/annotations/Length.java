package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Determines the max length available for the table column.
 */
@Target(ElementType.FIELD)
public @interface Length {

    /**
     * The max length for the column values.
     * 
     * @return The max length.
     */
    public int size();
}
