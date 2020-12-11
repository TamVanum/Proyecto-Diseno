package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.Book;
import org.santotomas.library_app.models.CategoryBook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryBookDAO implements ImplentationDAO<CategoryBook> {

    private Database myDatabase;

    public CategoryBookDAO(Database myDatabase) {
        this.myDatabase = myDatabase;
    }

    @Override
    public List<CategoryBook> getAll() {
        String sql = "SELECT id, category_id_fk, book_id_fk " +
                "FROM category_book";
        List<CategoryBook> categoryBooks = null;

        try (ResultSet resultSet = myDatabase.getConn().createStatement().executeQuery(sql);) {
            if ( resultSet.next() ) {
                categoryBooks = new ArrayList<>();
                do {
                    categoryBooks.add(new CategoryBook(
                            resultSet.getInt("id"),
                            resultSet.getInt("category_id_fk"),
                            resultSet.getInt("book_id_fk")
                    ));
                } while (resultSet.next() );
            }
        } catch (SQLException e) {
            e.getMessage();
        }

        return categoryBooks;
    }

    @Override
    public CategoryBook getByUUID(String uuid){
        /*
        String sql = "SELECT id, category_id_fk, book_id_fk " +
                "FROM category_book WHERE isbn = ?";
        CategoryBook categoryBook = null;

        try (PreparedStatement ps = myDatabase.getConn().prepareStatement(sql)) {
            ps.setString(1, uuid);
            try (ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    categoryBook = new CategoryBook(
                            rs.getInt("id"),
                            rs.getInt("category_id_fk"),
                            rs.getInt("book_id_fk")
                    );
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
         */
        return null;
    }

    @Override
    public CategoryBook getById(int id) {
        String sql = "SELECT id, category_id_fk, book_id_fk " +
                "FROM category_book WHERE id = ?";
        CategoryBook categoryBook = null;

        try (PreparedStatement ps = myDatabase.getConn().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    categoryBook = new CategoryBook(
                            rs.getInt("id"),
                            rs.getInt("category_id_fk"),
                            rs.getInt("book_id_fk")
                    );
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }

        return categoryBook;
    }

    @Override
    public int add(CategoryBook categoryBook) {
        String sql = "INSERT INTO category_book (category_id_fk, book_id_fk) VALUES (?, ?)";
        int rowsAffected = 0;
        try ( PreparedStatement ps = myDatabase.getConn().prepareStatement(sql) ) {
            ps.setInt(1, categoryBook.getCategory_id_fk());
            ps.setInt(2, categoryBook.getBook_id_fk());
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return rowsAffected;
    }

    @Override
    public int update(CategoryBook categoryBook) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String uuid) {
        String sql = "DELETE FROM category_book WHERE id = ?";
        int rowsAffected = 0;
        try ( PreparedStatement ps = myDatabase.getConn().prepareStatement(sql) ) {
            ps.setInt(1, Integer.parseInt(uuid));
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return rowsAffected;
    }
}
