package two;


import java.sql.*;


/*from  w  w  w.  j  a va2  s.  c  om*/
public class DbPreparedStatementSetDate {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db2";
    static final String USER = "root";
    static final String PASS = "grahmbell";

    public static void main(String[] args) {
        Connection conn = null;
       PreparedStatement stmt = null;
              try {
          //  Class.forName(JDBC_DRIVER);----->>> without loading driver
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql="insert into Student values(?,?,?,?)";
            stmt = conn.prepareStatement(sql);// becomes local variable to try block
                  stmt.setString(1,"Zaid");
                  stmt.setInt(2,8);

                 stmt.setString(3,"HRM");
                 stmt.setDate(4, Date.valueOf("2022-04-14"));//---->> adding date as attribute
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
