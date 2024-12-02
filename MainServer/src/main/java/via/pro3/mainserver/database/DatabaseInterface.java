package via.pro3.mainserver.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DatabaseInterface
{
 Connection getConnection() throws SQLException;

 void execute (PreparedStatement statement);

 void disconnect();
}
