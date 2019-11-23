package io.illyria.dbcontext.sample;

import io.illyria.dbcontext.sample.models.User;

public final class App {
    private static final Context _ctx = new Context();

    public static void main(String[] _args) {
        System.out.println("Got executed");
        if (_ctx.Users != null)
            _ctx.Users.add(new User());
    }
}
