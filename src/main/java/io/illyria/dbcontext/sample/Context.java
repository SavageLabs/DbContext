package io.illyria.dbcontext.sample;

import io.illyria.dbcontext.DbContext;
import io.illyria.dbcontext.DbSet;
import io.illyria.dbcontext.sample.models.User;

public final class Context extends DbContext {
    public Context() {
        super("");
    }

    public DbSet<User> Users;
}
