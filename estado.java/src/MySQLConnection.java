import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    
    public static Connection getConnection()throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            System.out.println("My SQL JDBC driver not found" + e.getMessage());
            throw new SQLException("Error loading driver", e);
        }

        String url = "jdbc:mysql://localhost:3306/cidadesestados?useSSL=false&serverTimezone=UTC";
        String username = "root"; 
        String password = "123456";
      
        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;
    }


}
