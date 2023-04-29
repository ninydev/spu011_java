package org.itstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWork implements Runnable
{Connection connection;
    public DBWork() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3355/some_base", "user_db", "password");
        }
        catch (SQLException exception){
            System.out.println("SQL Exception");
        }
        catch (Exception exception) {
            System.out.println("Any Exception");
        }
    }
    @Override
    public void run() {
        createTable();
    }

    private void createTable() {
        try {
            String sqlCommand = "CREATE TABLE products (Id INT PRIMARY KEY AUTO_INCREMENT, ProductName VARCHAR(20), Price INT)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
        } catch (SQLException exception){
            System.out.println("SQL Exception");
            System.out.println(exception.getMessage());
        }
    }
}
