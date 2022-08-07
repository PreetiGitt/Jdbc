package procedure;

import java.sql.*;

public class StoredProcedure {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sakila";
    static final String USER = "root";
    static final String PASS = "grahmbell";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();// becomes local variable to try block
            String sql = "SELECT first_name, last_name from actor where actor_id= 4";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                //       int id = rs.getInt("id");
                //     int age = rs.getInt("age");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");

                // System.out.print("ID: " + id);
                //System.out.print(", Age: " + age);
                System.out.println(", First: " + first);
                System.out.println(", Last: " + last);
            } else {
                System.out.println("no record found");
            }

            rs.close();
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
