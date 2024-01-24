import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSample {

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
            sql = "SELECT id, name, age FROM employees ORDER BY age;";
            // この書き方もある！今後はこれ推奨とのこと。
            // sql = """
            // // select
            // // id
            // // ,name
            // // ,age
            // // from employees

            // // """;
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.print("id=" + id);
                System.out.print("　name=" + name);
                System.out.print("　age=" + age);
                System.out.println();
            }
        } catch (SQLException ex) {
            System.out.println("SQL関連の例外が発生しました");
            System.out.println("発行したSQLは「" + sql + "」です");
            ex.printStackTrace();

        } finally {
            try {
                if (con != null) {
                    con.close();

                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();

                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
