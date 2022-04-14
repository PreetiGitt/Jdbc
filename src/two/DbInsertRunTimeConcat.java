package two;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*from  w  w  w.  j  a va2  s.  c  om*/
public class DbInsertRunTimeConcat {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db2";
    static final String USER = "root";
    static final String PASS = "grahmbell";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;


        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();// becomes local variable to try block
                String sql= "insert into Student values (" +"'Kavya'"+","+ "6"+ ","+ "'archeology'"+")";
                stmt.executeUpdate(sql);
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
