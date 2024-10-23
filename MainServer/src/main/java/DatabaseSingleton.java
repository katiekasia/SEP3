import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private final Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=sep3";
    private static final String USER = "postgres";
    private static final String PSWD = "admin";

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

    public synchronized Connection getConnection(){
        return connection;
    }

    public synchronized void execute(PreparedStatement statement){
        try
        {
            statement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

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