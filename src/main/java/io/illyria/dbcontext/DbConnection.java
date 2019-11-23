package io.illyria.dbcontext;

/**
 * Database connection builder.
 */
public final class DbConnection {

    /**
     * Stored connection to use.
     */
    private final String _connection;

    /**
     * Builds a new connection with the specified settings.
     * 
     * @param server   The server hostname or ip to
     * @param database The default database name to append to.
     * @param username Authentication username.
     * @param password Authentication password.
     */
    public DbConnection(String server, String database, String username, String password) {
        this(server, 3306, database, username, password);
    }

    /**
     * Builds a new connection with the specified settings.
     * 
     * @param server   The server hostname or ip to
     * @param port     Service port used by the SQL.
     * @param database The default database name to append to.
     * @param username Authentication username.
     * @param password Authentication password.
     */
    public DbConnection(String server, int port, String database, String username, String password) {
        this(server, port, database, username, password, false);
    }

    /**
     * Builds a new connection with the specified settings.
     * 
     * @param server   The server hostname or ip to
     * @param port     Service port used by the SQL.
     * @param database The default database name to append to.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param useSsl   Wether or not require an SSL connection.
     */
    public DbConnection(String server, int port, String database, String username, String password, boolean useSsl) {
        this(server, port, database, username, password, useSsl, false);
    }

    /**
     * Builds a new connection with the specified settings.
     * 
     * @param server         The server hostname or ip to
     * @param port           Service port used by the SQL.
     * @param database       The default database name to append to.
     * @param username       Authentication username.
     * @param password       Authentication password.
     * @param useSsl         Wether or not require an SSL connection.
     * @param useCompression Wether or not compression should be used.
     */
    public DbConnection(String server, int port, String database, String username, String password, boolean useSsl,
            boolean useCompression) {
        this(server, port, database, username, password, useSsl, useCompression, false);
    }

    /**
     * Builds a new connection with the specified settings.
     * 
     * @param server         The server hostname or ip to
     * @param port           Service port used by the SQL.
     * @param database       The default database name to append to.
     * @param username       Authentication username.
     * @param password       Authentication password.
     * @param useSsl         Wether or not require an SSL connection.
     * @param useCompression Wether or not compression should be used.
     * @param usePooling     Wether or not pooling should be used.
     */
    public DbConnection(String server, int port, String database, String username, String password, boolean useSsl,
            boolean useCompression, boolean usePooling) {
        this._connection = "Server" + server + ";Port=" + port + "Database=" + database + ";Uid" + username
                + ";Password=" + password + ";SslMode=" + (useSsl ? "Required" : "Preferred") + ";UseCompression="
                + useCompression + ";Pooling=" + usePooling;
    }

    /**
     * Returns the connection.
     */
    @Override
    public String toString() {
        return this._connection;
    }
}
