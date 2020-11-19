package org.santotomas.library_app.dao;

import java.sql.SQLException;
import java.util.List;

public interface ImplentationDAO<T> {
    public List<T> getAll() throws SQLException;
    public T getByUUID(String uuid) throws SQLException;
    public int add(T t) throws SQLException;
    public int update(String uuid, T obj) throws SQLException;
    public int delete(String uuid) throws SQLException;

}
