package io.illyria.dbcontext;

import java.util.Collection;
import java.util.HashSet;

/**
 * Defines a collection of entities within the context.
 *
 * @param <TEntity> The type that defines the collection.
 */
public final class DbSet<TEntity> {

    /**
     * Creates a new set of entities to use within the context;
     */
    public DbSet() {
    }

    /**
     * Creates a new set of entities with the specified entries for the context.
     * 
     * @param entries The entries to be part of the collection.
     */
    public DbSet(Collection<TEntity> entries) {
        this.entities.addAll(entries);
    }

    /**
     * The collection of entities in current scope.
     */
    private final HashSet<TEntity> entities = new HashSet<TEntity>();

    /**
     * Adds a new entity to the context.
     *
     * @param entity The new entity instance to add.
     */
    public void add(TEntity entity) {
        this.entities.add(entity);
    }

    /**
     * Adds multiple entities to the context.
     *
     * @param entities The collection of entity instances to add.
     */
    public void addRange(Collection<TEntity> entities) {
        this.entities.addAll(entities);
    }

}
