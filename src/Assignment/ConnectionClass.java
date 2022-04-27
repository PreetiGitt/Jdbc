package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionClass {
    static Connection conn;
    static String JDBC_DRIVER;
    static String DB_URL;
    static String USER;
    static String PASS;
 ;
    static {
        try {
            FileInputStream fileInputStream= new FileInputStream("jdbc.properties");
            Properties prop=new Properties();
            prop.load(fileInputStream);
            JDBC_DRIVER= prop.getProperty("JDBC_DRIVER");
            DB_URL= prop.getProperty("DB_URL");
            USER= prop.getProperty("USER");
            PASS= prop.getProperty("PASS");
           // Class.forName("JDBC_DRIVER");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
    public  static Connection getConnected() throws SQLException {
        if((conn==null)|| (conn.isClosed()))
            conn=DriverManager.getConnection(DB_URL, USER, PASS);
        else
            System.out.println("Already connected");
        return conn;
    }


}
