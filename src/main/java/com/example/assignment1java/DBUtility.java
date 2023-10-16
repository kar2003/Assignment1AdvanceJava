package com.example.assignment1java;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtility {
    private static  final String url = "jdbc:mysql://172.31.22.43:3306/Karuna200520838";
    private static final String username = "Karuna200520838";
    private static final String password = "wGtT4nObpO";
    String sql = "SELECT * FROM MilkEggCheesePrices"; // Check this SQL query
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }

    public static ResultSet executeQuery() {
        Connection connection = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String sql = "SELECT * FROM MilkCheeseEggsPrices";
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }

        return resultSet;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


