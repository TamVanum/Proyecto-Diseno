package org.santotomas.library_app.table.render;

import org.santotomas.library_app.dao.BookDAO;
import org.santotomas.library_app.dao.CategoryDAO;
import org.santotomas.library_app.dao.Database;
import org.santotomas.library_app.models.Book;
import org.santotomas.library_app.models.Category;
import org.santotomas.library_app.util.ImageUtil;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BookTableRender extends JLabel implements TableCellRenderer {

    private CategoryDAO categoryDao;
    private BookDAO bookDAO;
    private Database myDatabase;

    public BookTableRender(Database myDatabase) {
        this.myDatabase = myDatabase;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        Color color;
        color = Color.BLUE;

        Color color2;
        color2 = Color.BLACK;

        if (column == 0){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            setIcon(null);
            setText(String.valueOf(value));


        }

        if (column == 1){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            setIcon(null);
            setText(String.valueOf(value));

        }

        if (column == 2){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            setIcon(null);
            setText(String.valueOf(value));

        }

        if (column == 3){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            Integer val = (Integer) value;
            setText(val.toString());
            setForeground(Color.black);

        }

        if (column == 4){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }

            Integer val = (Integer) value;
            if (val == 1){
                setIcon(ImageUtil.getInstance().getIcon("ninos.png"));
            } else if (val == 2){
                setIcon(ImageUtil.getInstance().getIcon("joven.png"));
            } else if (val == 3){
                setIcon(ImageUtil.getInstance().getIcon("jovenAdulto.png"));
            } else if (val == 4){
                setIcon(ImageUtil.getInstance().getIcon("adulto.png"));
            } else if (val == 5){
                setIcon(ImageUtil.getInstance().getIcon("XXX.png"));
            } else{

            }
            categoryDao = new CategoryDAO(this.myDatabase);
            String nombre =categoryDao.getByUUID(String.valueOf(value)).getName();
            setText(nombre);

        }


        if (column == 5){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            setIcon(null);
            setText(String.valueOf(value));

        }

        if (column == 6){
            setIcon(null);
            Integer val = (Integer) value;
            setText(val.toString());
            if (val <= 10){
                setForeground(Color.red);
            }else if (val > 10 && val <= 50){
                setForeground(color);
            }else{
                setForeground(Color.green);
            }
        }


        if (column == 7){
            if (isSelected){
                setForeground(color);
            }else {
                setForeground(color2);
            }
            setIcon(null);
            setText(String.valueOf(value));

        }


        return this;
    }
}
