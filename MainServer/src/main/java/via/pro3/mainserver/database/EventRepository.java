package via.pro3.mainserver.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.SQLException;

public class EventRepository implements EventInterface {
    private DatabaseInterface database;

    public EventRepository(DatabaseInterface database) {
        this.database = database;
    }
@Override
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

    @Override
    public synchronized void createAppointment(LocalDateTime dateAndTime)
    {
        String sql = "INSERT INTO appointments (appointmentId, dateAndTime) VALUES"
            + "(?, ?)";
        try(PreparedStatement statement = database.getConnection().prepareStatement(sql))
        {
            statement.setObject(1, UUID.randomUUID());
           statement.setObject(2, dateAndTime);
           statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}