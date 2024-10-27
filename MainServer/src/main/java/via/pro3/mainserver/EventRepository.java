package via.pro3.mainserver;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class EventRepository {
    private DatabaseSingleton database;

    public EventRepository(DatabaseSingleton database) {
        this.database = database;
    }

    public synchronized void createUser(String user, String password) {
        String sql = "INSERT INTO users (userid, email, password) VALUES " +
                "(?, ?, ?)";
        try (PreparedStatement statement = database.getConnection().prepareStatement(sql)) {
            statement.setObject(1, UUID.randomUUID());
            statement.setString(2, user);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}