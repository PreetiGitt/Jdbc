package Scrollability;


import java.sql.*;

/*rs.refreshRow()==== for updating any changes in database
        while java application is still running*/
//error: ResultSet Not updatable

public class Four {

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
            stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY );
            String sql = "SELECT  name from student ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String first = rs.getString("name");
                System.out.println("Name  :" +first );
            }
            System.in.read();
            System.out.println("\n\n");
            System.out.println("After Previous \n\n");
            while (rs.previous()) {
                rs.refreshRow();
                String first = rs.getString("name");
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
