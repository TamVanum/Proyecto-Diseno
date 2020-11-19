package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements InterfaceDAO<User> {

    Database conn;

    public UserDAO() {
        try {
            conn = Database.getInstance("localhost", "3306", "library", "root", "1324");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        String sql = "SELECT uuid, user_name, password, permission FROM user;";
        ResultSet rs = conn
                .getConnection()
                .createStatement()
                .executeQuery(sql);
        ArrayList<User> users = new ArrayList<>();

        if ( !rs.next() ) {
            System.out.println("no data");
        } else {

            do {
                users.add(new User(
                        rs.getString("uuid"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("permission")
                ));
            } while (rs.next());
        }
        return users;
    }

    @Override
    public User getById() {
        return null;
    }

    @Override
    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO users";
        //conn.getConnection().createStatement().executeUpdate("sada");
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
