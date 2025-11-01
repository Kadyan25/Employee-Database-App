package com.example;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployees {
    private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employees;";

    public void selectAllRecords() throws SQLException {
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                double salary = rs.getDouble("salary");
                System.out.println(id + ", " + name + ", " + email + ", " + country + ", " + salary);
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }
}

