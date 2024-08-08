package de.jaaaaames.varo.sql;

import java.sql.*;

public class SQLHandler {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/varo";
    private static final String JDBC_USER = "s";
    private static final String JDBC_PASSWORD = "";
    public static Connection connection;

    public static boolean isConnected() {
        return (connection != null);
    }

    public static PreparedStatement getStatement(String sql) {
        if (isConnected()) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                return preparedStatement;
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static ResultSet getResult(String sql) {
        if(isConnected()) {
            try {
                PreparedStatement preparedStatement = getStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static void connectDatabase() {
        if(!(isConnected())) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                System.out.println("[Database] Connection was successfully!");
            } catch(SQLException exception) {
                System.out.println("[Database] Connection was not established. Error");
                exception.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
