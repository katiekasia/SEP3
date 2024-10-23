import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class EventRepository {
    private DatabaseSingleton database;

    public EventRepository(DatabaseSingleton database) {
        this.database = database;
    }

    public synchronized void createUser(String user) {
        String sql = "INSERT INTO users (userid, email) VALUES " +
                "(?, ?)";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setObject(1, UUID.randomUUID());
            statement.setString(2, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}