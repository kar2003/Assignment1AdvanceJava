package com.example.assignment1java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MilkPriceController implements Initializable {
    @FXML
    private BarChart<String, Number> barChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadBarChartData();
    }

    private void loadBarChartData() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        Connection connection = null;
        try {
            connection = DBUtility.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT country, milkprice FROM Karuna200520838.MilkCheeseEggsPrices");

            while (resultSet.next()) {
                String country = resultSet.getString("country");
                double milkPrice = resultSet.getDouble("milkprice");
                series.getData().add(new XYChart.Data<>(country, milkPrice));
                System.out.println("Country: " + country + ", Milk Price: " + milkPrice);
            }

            barChart.getData().add(series);

            resultSet.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeConnection(connection);
        }
    }
}
