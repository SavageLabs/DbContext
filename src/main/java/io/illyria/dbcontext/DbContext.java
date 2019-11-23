package io.illyria.dbcontext;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CompletableFuture;

/**
 * Database O/RM context manager.
 */
public abstract class DbContext {
    /**
     * Connection broker with the SQL Server.
     */
    private final Connection _connection;

    /**
     * Initializes a new Connection.
     *
     * @param connectionString Connection string to connect to the server.
     */
    public DbContext(String connectionString) {
        this._connection = this.buildConnection(connectionString);

        this.buildModel();
    }

    /**
     * Initializes a new Connection.
     *
     * @param connection Connection to use to connect to the server.
     */
    public DbContext(DbConnection connection) {
        this(connection.toString());
    }

    /**
     * Builds a new Connection to the server with the provided connection string.
     *
     * @param _connectionString The connection string to use for the connection.
     * @return null if unable to create a connection, otherwise the connection
     *         instance.
     */
    private Connection buildConnection(String _connectionString) {
        try {
            return DriverManager.getConnection(_connectionString);
        } catch (Exception ignore) {
            return null;
        }
    }

    /**
     * Closes the current connection, if any.
     */
    protected void dispose() {
        try {
            if (this.isConnected())
                this._connection.close();
        } catch (Exception ignore) {
        }
    }

    /**
     * Allows to interact with the connection directly.
     *
     * @return The current connection being used by the O/RM handler.
     */
    protected Connection geConnection() {
        return this._connection;
    }

    /**
     * Checks wether the current connection is usable or not.
     *
     * @return true if usable, otherwise false.
     */
    protected boolean isConnected() {
        try {
            return this._connection != null && !this._connection.isClosed();
        } catch (Exception ignore) {
            return false;
        }
    }

    /**
     * Executes a query script against the current connection.
     *
     * @param query The SQL query to run within the connection.
     * @return Results provided by the query, null if failed.
     */
    protected ResultSet queryScript(String query) {
        try {
            if (!this.isConnected())
                this.geConnection();

            PreparedStatement statement = this._connection.prepareStatement(query);

            return statement.executeQuery();
        } catch (Exception ignore) {
            return null;
        }
    }

    /**
     * Executes a query script asynchronously against the current connection.
     *
     * @param query The SQL query to run async within the connection.
     * @return Results provided by the query, null if failed.
     */
    protected CompletableFuture<ResultSet> queryScriptAsync(String query) {
        return CompletableFuture.supplyAsync(() -> this.queryScript(query));
    }

    /**
     * Executes an update query against the current connection.
     *
     * @param query The update query to run within the connection.
     * @return The response code provided by the engine, zero if failed.
     */
    protected Integer updateScript(String query) {
        try {
            if (!this.isConnected())
                this.geConnection();

            PreparedStatement statement = this._connection.prepareStatement(query);

            return statement.executeUpdate();
        } catch (Exception ignore) {
            return 0;
        }
    }

    /**
     * Executes an update query asynchrounously against the current connection.
     *
     * @param query The update query to run async within the connection.
     * @return The response code provided by the engine, zero if failed.
     */
    protected CompletableFuture<Integer> updateScriptAsync(String query) {
        return CompletableFuture.supplyAsync(() -> this.updateScript(query));
    }

    /**
     * Builds the context model to use against the database.
     */
    private void buildModel() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            DbContextModel shadow = new DbContextModel(field.getClass());
        }
    }

    /**
     * Creates a table upon a class type.
     */
    private final class DbContextModel {

        /**
         * Table name where the entity will be held in database.
         */
        private String tableName;

        /**
         * Column names that belongs to the table.
         */
        private String[] columnStrings;

        /**
         * Builds a new table model refence from a class type.
         *
         * @param <TContextEntity> The entity to construct the table from.
         * @param entity           The class entity to build the table from.
         */
        public <TContextEntity> DbContextModel(Class<TContextEntity> entity) {
            this.tableName = entity.getName();
            this.columnStrings = this.calculateColumns(entity);
        }

        /**
         * Calculates the columns to be appended to the table.
         *
         * @param <TContextEntity> The entity to construct the table from.
         * @param entity           The class entity to build the table from.
         * @return An array of column names.
         */
        private <TContextEntity> String[] calculateColumns(Class<TContextEntity> entity) {
            throw new UnsupportedOperationException("This has not been implemented yet.");
        }
    }
}
