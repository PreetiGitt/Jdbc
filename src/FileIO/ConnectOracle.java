package FileIO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectOracle {
    static final String ODBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "oracle";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
           // Class.forName(ODBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql="insert into InsertImage values(?,?)";
            stmt=conn.prepareStatement(sql);
            stmt.setString( 1, "F1" );
            FileInputStream fis = new FileInputStream( "C:\\Users\\DELL\\Pictures\\Saved Pictures\\Pic1.jpg" );
            stmt.setBlob( 2, fis );


            int rows=stmt.executeUpdate();
            if(rows>=1)
                System.out.println(rows+"row/s affected");
            else
                System.out.println("No update");

            stmt.close();
            conn.close();
        }
        catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
