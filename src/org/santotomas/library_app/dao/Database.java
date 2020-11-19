package org.santotomas.library_app.dao;

import java.sql.*;

public class Database {

    private static Database instance;
    public Connection connection;

    public Database (
            String host, String port, String db, String user, String password
    ) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");

        String uri = "jdbc:mysql://";
        uri += host + ":" + port + "/" + db + "?";
        uri += "user=" + user + "&password=" + password;

        this.connection = DriverManager.getConnection(uri);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance(
            String host, String port, String db, String user, String password
    ) throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new Database(host, port, db, user, password);
        }
        return instance;
    }
}
