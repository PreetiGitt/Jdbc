package Scrollability;


import java.sql.*;

/*
double blocks of rs.next()===BUT no double output
 */
public class One {

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
            String sql = "SELECT first_name from actor limit 5 ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String first = rs.getString("first_name");
                System.out.println("Name  :" +first );
            }
            while (rs.next()) {

                String first = rs.getString("first_name");
                System.out.println("Name" +first );
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
