package org.santotomas.library_app.dao;

import java.sql.*;

public class Database {

    private Connection conn;

    public Database(String ip, String db, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = String.format("jdbc:mariadb://%s:%d/%s", ip, 3306, db);
        conn = DriverManager.getConnection(url, user, password);
    }

    public Connection getConn() {
        return conn;
    }
}
