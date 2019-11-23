package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Column options for the field.
 */
@Target(ElementType.FIELD)
public @interface Column {

    /**
     * Name of the table column to use for the field.
     *
     * @return The name of the column.
     */
    public String name() default "";

    /**
     * Data type of the table column.
     *
     * @return The data type.
     */
    public String type() default "";
}
