package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class exam4 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = null;

        try {
            con = DriverManager.getConnection(url, user, password);

            sql = """
                    update members
                    set name ='大道寺真名'
                    ,birth_day = '1996-09-20'
                    ,gender = '女'
                    ,color_id =1
                    where id = 1;

                    """;

            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを操作しました");
        } catch (SQLException ex) {

            System.out.println("SQL = " + sql);
            ex.printStackTrace();

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (pstmt != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
