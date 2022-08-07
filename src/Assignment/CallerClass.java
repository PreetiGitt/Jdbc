package Assignment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CallerClass {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {


                conn = ConnectionClass.getConnected();

            String sql = "insert into Student values(?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, "Nitya");
            preparedStatement.setInt(2, 15);

            preparedStatement.setString(3, "Revenue");
            preparedStatement.setDate(4, Date.valueOf("2022-04-28"));//---->> adding date as attribute
         int rows=preparedStatement.executeUpdate();
            if(rows>=1)
                System.out.println(rows+"row/s affected");
            else
                System.out.println("No update");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
}

