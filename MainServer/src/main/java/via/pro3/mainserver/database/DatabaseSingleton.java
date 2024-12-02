package via.pro3.mainserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class DatabaseSingleton implements DatabaseInterface {
    private static DatabaseSingleton instance;
    private final Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep3";
    private static final String USER = "postgres";
    private static final String PSWD = "VIAVIAVIA";

    private DatabaseSingleton(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,USER,PSWD);
        }catch (SQLException e ){
            e.printStackTrace();
        }
        this.connection = conn;
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
    public synchronized Connection getConnection(){
        return connection;
    }

    @Override
    public synchronized void execute(PreparedStatement statement){
        try
        {
            statement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
@Override
    public synchronized void disconnect(){
        try
        {
            this.connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}