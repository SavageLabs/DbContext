package io.illyria.dbcontext;

public final class App {
    private final AppDbContext _ctx;

    public App() {
        this._ctx = new AppDbContext();
    }

    public void useContext() {
        this._ctx.customs.add(new CustomModel("Hello", "World"));
    }

}
