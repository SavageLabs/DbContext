package io.illyria.dbcontext;

/**
 * Sample DbContext
 */
public final class AppDbContext extends DbContext {
    public AppDbContext() {
        super(new DbConnection("localhost", "SampleApp", "admin", "password"));
    }

    public DbSet<CustomModel> customs = new DbSet<CustomModel>();

    public DbSet<CustomModel> autoCustoms;
}
