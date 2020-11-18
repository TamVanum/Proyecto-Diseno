package org.santotomas.library_app.dao;

import java.sql.*;

public class Database {

    public Database () throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conection = DriverManager.getConnection("jdbc:mysql://69.10.61.242:3306/RAN_usuariosrolescomentarios?" +
                "user=alumno_rancagua&" +
                "password=ran2020");

        PreparedStatement psQuery = conection.prepareStatement(
                "SELECT message.id, user.username, message.message FROM message " +
                        "INNER JOIN user ON message.user_id_fk = user.id " +
                        "ORDER BY id ASC");

        ResultSet rs = psQuery.executeQuery();

        while (rs.next()) {
            System.out.println( rs.getInt("id") + "\t| " + rs.getString("username") + " : " + rs.getString("message"));
        }

        rs.close();
        psQuery.close();
        conection.close();
    }
}
