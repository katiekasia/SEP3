package via.pro3.mainserver.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DatabaseInterface
{
 Connection getConnection();

 void execute (PreparedStatement statement);

 void disconnect();
}
