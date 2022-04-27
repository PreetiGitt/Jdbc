package Assignment;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {
    static  String JDBC_DRIVER;
    static String DB_URL ;
    static  String USER ;
    static  String PASS ;
    private  static Connection con;
    static{


        try {
            FileInputStream  is = new FileInputStream("Jdbc.properties");;
            Properties properties=new Properties();



            properties.load(is);
            JDBC_DRIVER = properties.getProperty(" JDBC_DRIVER");
            DB_URL=properties.getProperty("DB_URL");
            USER=properties.getProperty("USER" );
            PASS=properties.getProperty("PASS");
            Class.forName(JDBC_DRIVER);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }


        catch(ClassNotFoundException sqlException){
            System.out.println("failed to load driver");
        }

    }
       public static Connection getConnected() {
        try {
            if((con==null)|| (con.isClosed()))
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        }
          catch(SQLException e)
          {            System.out.println("failed to make connection");
          }
           return con;
       }

    }


