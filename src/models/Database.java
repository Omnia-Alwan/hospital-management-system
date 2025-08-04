package models;

import java.sql.*;

public class Database {
    private String user="root";
    private String pass="password";
    private String url= "jdbc:mysql://localhost/hospital";
    private Statement statement;
    private Connection connection;
    public Database(){
        try {
            connection= DriverManager.getConnection(url,user,pass);
            statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Statement getStatement() throws SQLException {
        return connection.createStatement();
    }
}
