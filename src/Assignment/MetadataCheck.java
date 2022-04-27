package Assignment;

import java.sql.*;

public class MetadataCheck {



        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/db2";
        static final String USER = "root";
        static final String PASS = "grahmbell";

        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try {
                //  Class.forName(JDBC_DRIVER);----->>> without loading driver
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql="select * from Student";
               stmt= conn.createStatement();
                ResultSet resultSet= stmt.executeQuery(sql);
               ResultSetMetaData RsMD=resultSet.getMetaData();//--->>>>>>>> Interface to get meta data
                System.out.println("First Column is  " +RsMD.getColumnName(1));
                System.out.println("2nd Column is  "+ RsMD.getColumnName(2));

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


