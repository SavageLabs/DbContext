package io.illyria.dbcontext.entity;

import java.lang.reflect.Field;
import java.util.HashSet;

import io.illyria.dbcontext.annotations.Column;
import io.illyria.dbcontext.annotations.Table;

/**
 * Defines a database table entity.
 */
public final class DbEntity {

    private String tableName;

    private HashSet<DbEntityColumn> tableColumns;

    public DbEntity(Class<?> entity) {
        this.toTable(entity).mapColumns(entity);
    }

    protected DbEntity toTable(Class<?> table) {
        return toTable(table.isAnnotationPresent(Table.class) ? table.getDeclaredAnnotation(Table.class).name()
                : table.getSimpleName());
    }

    protected DbEntity toTable(String tableName) {
        this.tableName = tableName;
        return this;
    }

    protected DbEntity mapColumns(Class<?> entity) {
        this.tableColumns = new HashSet<DbEntityColumn>();
        for (Field field : entity.getFields()) {
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            } else
                this.tableColumns.add(new DbEntityColumn(field));
        }
        return this;
    }

    public String getTable() {
        return this.tableName;
    }

    public HashSet<DbEntityColumn> getColumns() {
        return this.tableColumns;
    }
}
