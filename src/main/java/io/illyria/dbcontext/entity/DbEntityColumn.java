package io.illyria.dbcontext.entity;

import java.lang.reflect.Field;

import io.illyria.dbcontext.annotations.Column;

public class DbEntityColumn {

    protected String columnName;

    protected String columnType;

    public DbEntityColumn(Field field) {
        this.toColumn(field);
    }

    public String getName() {
        return this.columnName;
    }

    public String getType() {
        return this.columnType;
    }

    @Override
    public String toString() {
        return this.columnName;
    }

    public DbEntityColumn toColumn(Field field) {
        return this.toColumn(
                field.isAnnotationPresent(Column.class) && field.getDeclaredAnnotation(Column.class).name() != ""
                        ? field.getDeclaredAnnotation(Column.class).name()
                        : field.getName());
    }

    public DbEntityColumn toColumn(String column) {
        this.columnName = column;
        return this;
    }
}
