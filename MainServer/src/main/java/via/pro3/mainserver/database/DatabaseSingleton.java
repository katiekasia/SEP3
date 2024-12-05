package via.pro3.mainserver.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class DatabaseSingleton implements DatabaseInterface {
    private static DatabaseSingleton instance;
    private final HikariDataSource dataSource;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep3";
    private static final String USER = "postgres";
    private static final String PSWD = "admin";

    private DatabaseSingleton(){
        // Configure HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PSWD);
        config.setMaximumPoolSize(10);  // Set the pool size
        dataSource = new HikariDataSource(config);
    }

    public static DatabaseSingleton getInstance(){
        if(instance == null){
            synchronized (DatabaseSingleton.class){
                if(instance == null){
                    instance = new DatabaseSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // Get a connection from the pool
        return dataSource.getConnection();
    }

    @Override
    public void execute(PreparedStatement statement) {
        try {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        // Close the data source and release all connections in the pool
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
