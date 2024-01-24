import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class exam1 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String name = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;

        try {

            con = DriverManager.getConnection(url, user, sql);
            sql = """
                    select id
                    ,name
                    from departments
                    order by id
                    """;

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String departmentName = rs.getString("name");

                System.out.print("id=" + id);
                System.out.print(" name=" + departmentName);
                System.out.println();

            }
        } catch (SQLException ex) {
            System.out.println("SQL関連の例外が発生しました");
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    con.close();
                }
                if (rs != null) {
                    con.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
