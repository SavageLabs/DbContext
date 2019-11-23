package io.illyria.dbcontext.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Determines the field column is NOT NULL in the table.
 */
@Target(ElementType.FIELD)
public @interface Required {
}
