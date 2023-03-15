package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MainTest {

    @Test
    void testDBConnection() {
        DataSource dataSource = MyDataSourceFactory.getDataSource();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select id, name, username from user");
            while (resultSet.next()) {
                System.out.println("User ID=" + resultSet.getInt("id") + ", Name=" + resultSet.getString("name"));
            }
            // Assertions.ass pass if statement?
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}