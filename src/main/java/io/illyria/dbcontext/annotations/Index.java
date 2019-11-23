package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Determines an Index property exists for the field.
 */
@Target(ElementType.FIELD)
public @interface Index {

    /**
     * The name of the Index for the table column.
     * 
     * @return Name of the index.
     */
    public String name() default "";

    /**
     * Determines if the Index for the column is unique.
     * 
     * @return Is unique.
     */
    public boolean unique() default false;

    /**
     * Determines if the Index for the column is clustered.
     * 
     * @return Is clustered.
     */
    public boolean clustered() default false;
}
