package org.itstep;

import java.sql.*;

public class DBWork implements Runnable {
    Connection connection;
    Statement statement;

    public DBWork() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3355/some_base", "user_db", "password");
            statement = connection.createStatement();
        } catch (SQLException exception) {
            System.out.println("SQL Exception");
        } catch (Exception exception) {
            System.out.println("Any Exception");
        }
    }

    @Override
    public void run() {
        // createTable();
        try {
            // create();
            read();
            // update();
            // delete();

        } catch (SQLException exception) {
            System.out.println("SQL Exception");
            System.out.println(exception.getMessage());
        }
    }

    private void create() throws SQLException {
        int rows = statement.executeUpdate("INSERT products(ProductName, Price) VALUES ('iPhone X', 76000)," +
                "('Galaxy S9', 45000), ('Nokia 9', 36000)");
        System.out.printf("Added %d rows\n", rows);
    }

    private void read() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int price = resultSet.getInt(3);
            System.out.printf("%d. %s - %d \n", id, name, price);
        }
    }

    private void update() throws SQLException {
        int rows = statement.executeUpdate("UPDATE products SET Price = Price - 5000");
        System.out.printf("Updated %d rows\n", rows);
    }

    private void delete() throws SQLException {
        int rows = statement.executeUpdate("DELETE FROM Products WHERE Id = 3");
        System.out.printf("%d row(s) deleted\n", rows);
    }


    private void createTable() {
        try {
            String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException exception) {
            System.out.println("SQL Exception");
            System.out.println(exception.getMessage());
        }
    }
}
