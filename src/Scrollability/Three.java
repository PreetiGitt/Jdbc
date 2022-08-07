package Scrollability;


import java.sql.*;

/*from  w  w  w.  j  a va2  s.  c  om*/
public class Three {

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
            stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY );
            String sql = "SELECT first_name from actor limit 10 ";
            ResultSet rs = stmt.executeQuery(sql);
            rs.setFetchSize(5);
            while (rs.next()) {

                String first = rs.getString("first_name");
                System.out.println("Name  :" +first );
            }
            System.out.println("\n\n");
            System.out.println("After Previous \n\n");
            //Works!!
            while (rs.previous()) {

                String first = rs.getString("first_name");
                System.out.println("Name: " +first );
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
