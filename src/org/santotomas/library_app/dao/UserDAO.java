package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserDAO implements ImplentationDAO<User> {

    private Database myDatabase;

    public UserDAO(Database myDatabase) {
        this.myDatabase = myDatabase;
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT uuid, user_name, permission FROM user";
        List<User> users = new ArrayList<User>();
        ResultSet resultSet = myDatabase.getConn().createStatement().executeQuery(sql);

        if ( resultSet.next() ) {
            do {
                users.add(new User(
                        resultSet.getString("uuid"),
                        resultSet.getString("user_name"),
                        resultSet.getString("permission")
                ));
            } while (resultSet.next() );
            return users;
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public User getByUUID(String uuid) throws SQLException {
        String sql = "SELECT uuid, user_name, permission FROM user " +
                "WHERE uuid = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if ( resultSet.next() ) {
            String userUuid = resultSet.getString("uuid");
            String userName = resultSet.getString("user_name");
            String permission = resultSet.getString("permission");

            return new User(userUuid, userName, permission);
        }

        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    public User login(String user_name, String password) throws SQLException {
        String sql = "SELECT uuid, user_name, permission FROM user " +
                "WHERE user_name = ? AND password = SHA2(?, 512) AND permission = 'Admin'";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if ( resultSet.next() ) {
            String uuid = resultSet.getString("uuid");
            String userName = resultSet.getString("user_name");
            String permission = resultSet.getString("permission");

            return new User(uuid, userName, permission);
        }

        return null;
    }

    @Override
    public int add(User user) throws SQLException {
        String sql = "INSERT INTO user VALUES (UUID, ?, SHA2(?, 512), ?)";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getPermission());
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }

    @Override
    public int update(User user) throws SQLException {
        String sql = "UPDATE user SET user_name = ?, permission = ? " +
                "WHERE uuid = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPermission());
        preparedStatement.setString(3, user.getUuid());
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }

    @Override
    public int delete(String uuid) throws SQLException {
        String sql = "DELETE FROM user WHERE uuid = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }
}
