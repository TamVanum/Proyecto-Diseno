package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.Book;
import org.santotomas.library_app.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BookDAO implements ImplentationDAO<Book> {

    private Database myDatabase;

    public BookDAO(Database myDatabase) {
        this.myDatabase = myDatabase;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        String sql = "SELECT isbn, title, description, price, category_id_fk, author, state, stock, release_date " +
                "FROM book ORDER BY title ASC";
        List<Book> books = new ArrayList<Book>();
        ResultSet resultSet = myDatabase.getConn().createStatement().executeQuery(sql);

        if ( resultSet.next() ) {
            do {
                books.add(new Book(
                        resultSet.getString("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getInt("category_id_fk"),
                        resultSet.getString("author"),
                        resultSet.getString("state"),
                        resultSet.getInt("stock"),
                        resultSet.getDate("release_date")
                ));
            } while (resultSet.next() );
            return books;
        }

        return Collections.EMPTY_LIST;
    }

    @Override
    public Book getByUUID(String uuid) throws SQLException {
        String sql = "SELECT isbn, title, description, price, category_id_fk, author, state, stock, release_date " +
                "FROM user WHERE uuid = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if ( resultSet.next() ) {
                    String isbn = resultSet.getString("isbn");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    int price = resultSet.getInt("price");
                    int categori_id_fk = resultSet.getInt("category_id_fk");
                    String author = resultSet.getString("author");
                    String estate = resultSet.getString("estate");
                    int stock = resultSet.getInt("stock");
                    Date release = resultSet.getDate("release_date");

            return new Book(
                    isbn,
                    title,
                    description,
                    price,
                    categori_id_fk,
                    author,
                    estate,
                    stock,
                    release
            );
        }

        return null;
    }

    @Override
    public int add(Book book) throws SQLException {
        String sql = "INSERT INTO book VALUES " +
                "(UUID(), ?, ?, ?, ?, ?, ?, ?, NOW())";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getDescription());
        preparedStatement.setInt(3, book.getPrice());
        preparedStatement.setInt(4, book.getCategoryId());
        preparedStatement.setString(5, book.getAuthor());
        preparedStatement.setString(6, book.getEstate());
        preparedStatement.setInt(7, book.getStock());
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }

    @Override
    public int update(Book book) throws SQLException {
        String sql = "UPDATE book SET title = ?, description = ?, price = ?, category_id_fk = ?, author = ?, " +
                "state = ?, stock = ?, release_date = NOW() " +
                "WHERE isbn = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getDescription());
        preparedStatement.setInt(3, book.getPrice());
        preparedStatement.setInt(4, book.getCategoryId());
        preparedStatement.setString(5, book.getAuthor());
        preparedStatement.setString(6, book.getEstate());
        preparedStatement.setInt(7, book.getStock());
        preparedStatement.setString(8, book.getIsbn());
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }

    @Override
    public int delete(String uuid) throws SQLException {
        String sql = "DELETE FROM book WHERE isbn = ?";

        PreparedStatement preparedStatement = myDatabase.getConn().prepareStatement(sql);
        preparedStatement.setString(1, uuid);
        int rowAffected = preparedStatement.executeUpdate();

        return rowAffected;
    }
}
