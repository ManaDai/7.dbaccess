package sougou_ensyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.Driver;

public class exam3_5 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        String sql = null;
        String sql2 = null;

        try {

            con = DriverManager.getConnection(url, user, password);
            sql = """
                    begin;
                        delete from members
                        where id = 1
                        """;

            sql2 = """
                    delete from members
                    where id = 2
                    commit;
                    """;

            pstmt = con.prepareStatement(sql);
            pstmt2 = con.prepareStatement(sql2);
            int numOfUpdate = pstmt.executeUpdate();
            int numOfUpdate2 = pstmt2.executeUpdate();
            System.out.println(numOfUpdate + numOfUpdate2 + "件のデータを操作しました。");

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
