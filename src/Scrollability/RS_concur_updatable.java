package Scrollability;


import java.sql.*;
// Updatable ResultSet
public class RS_concur_updatable {

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
            stmt = conn.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT roll, name from student ";
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.absolute(3)){
                rs.updateString(2,"Raghav");
                rs.updateRow();
            }
            rs.beforeFirst();
        while (rs.next()) {

                String first = rs.getString("name");
                System.out.println("Name  :" +first );
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
