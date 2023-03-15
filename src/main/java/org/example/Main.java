package org.example;

import javax.sql.DataSource;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        testDataSource();
    }

    private static void testDataSource() {
        DataSource ds = MyDataSourceFactory.getDataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, username from user");
            while (rs.next()) {
                System.out.println("User ID=" + rs.getInt("id") + ", Name=" + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}