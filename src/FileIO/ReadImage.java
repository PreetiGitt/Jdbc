package FileIO;


import java.io.*;
import java.sql.*;


/*from  w  w  w.  j  a va2  s.  c  om*/
public class ReadImage {
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

                  String sql = "select * from file1";
                  stmt = conn.createStatement();
                  ResultSet rs = stmt.executeQuery(sql);
                  rs.next();
                  System.out.println("The Filename is  "+rs.getString(1));
                 InputStream is=rs.getBinaryStream(2);

                  FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\DELL\\Pictures\\Saved Pictures\\Pic2.jpg" ));
                    byte [] arr= new byte[1024];
                    int size=0;
                    while((size=is.read(arr))!=-1) {
                        fos.write(arr,0,size);

                    }

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
