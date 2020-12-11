package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.Book;
import org.santotomas.library_app.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CategoryDAO implements ImplentationDAO<Category>{

    private Database myDatabase;

    public CategoryDAO(Database myDatabase) {
        this.myDatabase = myDatabase;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return null;
    }

    public Category getByName(String name) {
        String sql = "SELECT id, name FROM category WHERE name = ?";
        Category category = null;

        ResultSet resultSet;
        try (PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                category = new Category(
                        id,
                        name1
                );
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return category;
    }

    @Override
    public Category getByUUID(String uuid) {
        String sql = "SELECT id, name FROM category WHERE id = ?";
        Category category = null;

        ResultSet resultSet;
        try (PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(uuid));
            resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(
                        id,
                        name
                );
            }
            resultSet.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return category;
    }

    @Override
    public int add(Category category) throws SQLException {
        return 0;
    }

    @Override
    public int update(Category category) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String uuid) throws SQLException {
        return 0;
    }
}
