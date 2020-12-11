package org.santotomas.library_app.table.models;

import org.santotomas.library_app.models.Book;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.sql.Date;
import java.util.List;

public class BookTableModel extends AbstractTableModel {

    private static final String[] COLS = new String[]{
            "ISBN",
            "Titulo",
            "Descripcion",
            "Precio",
            "Categoria",
            "Autor(a)",
            "Stock",
            "Fecha Salida"
    };

    private List<Book> books;

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    public void refreshTable(List<Book> books) {
        this.books = books;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return COLS.length;
    }

    @Override
    public String getColumnName(int i) {
        return COLS[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        switch (i) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return Integer.class;
            case 7:
                return Date.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Book book = books.get(row);
        switch (col) {
            case 0:
                return book.getIsbn();
            case 1:
                return book.getTitle();
            case 2:
                return book.getDescription();
            case 3:
                return book.getPrice();
            case 4:
                return book.getCategoryId();
            case 5:
                return book.getAuthor();
            case 6:
                return book.getStock();
            case 7:
                return book.getRelease_date();
            default:
                return null;
        }
    }
}
