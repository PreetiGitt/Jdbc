package FileIO;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*from  w  w  w.  j  a va2  s.  c  om*/
public class InsertVideo1 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db2";
    static final String USER = "root";
    static final String PASS = "grahmbell";

    public static void main(String[] args) {
        Connection conn = null;
       PreparedStatement stmt = null;
              try {
           Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           // String sql="insert into Student values(?,?,?,?)";
         //   stmt = conn.prepareStatement(sql);// becomes local variable to try block
                  String sql = "INSERT INTO file1 VALUES(?, ?);";
                  stmt = conn.prepareStatement(sql);

                 stmt.setString( 1, "F1" );
                  FileInputStream fis = new FileInputStream( "C:\\Users\\DELL\\Dropbox\\PC\\Downloads\\simple.mp4" );
                  stmt.setBlob( 2, fis );
           stmt.executeUpdate();
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
