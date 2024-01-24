package sougou_ensyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exam3_3 {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/student";
        String user = "postgres";
        String password = "postgres";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;

        try {

            con = DriverManager.getConnection(url, user, password);
            sql = """
                    begin;
                        select m.name as mname
                        ,m.birth_day
                        ,m.gender
                        ,c.name as cname
                        from members as m
                        inner join colors as c
                        on m.color_id = c.id
                        order by m.id
                        commit;
                            """;

            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString("mname");
                String birth_day = rs.getString("birth_day");
                String gender = rs.getString("gender");
                String color_name = rs.getString("cname");

                System.out.print("name=" + name);
                System.out.print(" birthday=" + birth_day);
                System.out.print(" gender" + gender);
                System.out.println(" color_name=" + color_name);
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
