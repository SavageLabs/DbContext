package io.illyria.dbcontext.sample.models;

import io.illyria.dbcontext.annotations.Index;
import io.illyria.dbcontext.annotations.Key;
import io.illyria.dbcontext.annotations.Length;
import io.illyria.dbcontext.annotations.Required;
import io.illyria.dbcontext.annotations.Table;

@Table(name = "Users")
public final class User {

    @Key
    @Required
    public String id;

    @Required
    @Length(size = 18)
    @Index
    public String name;

    @Required
    @Index
    public String email;

}
