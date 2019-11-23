package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Specifies the Table option for the type.
 */
@Target(ElementType.TYPE)
public @interface Table {

    /**
     * Name of the database table.
     * 
     * @return The table name.
     */
    public String name();

    /**
     * Name of the database schema where the table is located. (Optional)
     * 
     * @return The schema name.
     */
    public String schemaName() default "dbo";
}
