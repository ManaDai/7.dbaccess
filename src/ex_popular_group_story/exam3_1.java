package ex_popular_group_story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class exam3_1 {

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
                    drop table if exists colors;
                    create table colors(
                        id integer primary key
                        ,name text
                    )
                    """;

            pstmt = con.prepareStatement(sql);
            int numOfUpdate = pstmt.executeUpdate();
            System.out.println(numOfUpdate + "件のデータを操作しました。");

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
