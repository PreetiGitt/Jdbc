package two;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*from  w  w  w.  j  a va2  s.  c  om*/
public class DbPreparedStatement {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db2";
    static final String USER = "root";
    static final String PASS = "grahmbell";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //  Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "insert into Student values(?,?,?,?)";
            stmt = conn.prepareStatement(sql);// becomes local variable to try block
            stmt.setString(1, "Antriksh");
            stmt.setInt(2, 7);

            stmt.setString(3, "Astronomy");
            int rows = stmt.executeUpdate();
            if (rows >= 1)
                System.out.println(rows + "row/s affected");
            else
                System.out.println("No update");
            stmt.close();
            conn.close();
        } catch (SQLException se) {
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
