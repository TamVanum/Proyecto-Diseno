package org.santotomas.library_app.dao;

import org.santotomas.library_app.models.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceDAO<T> {
    public ArrayList<T> getAll() throws SQLException;
    public T getById();
    public void insert(T t) throws SQLException;
    public void update(T t);
    public void delete(T t);
}
