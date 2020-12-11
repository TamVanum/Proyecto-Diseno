package org.santotomas.library_app.table.render;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BookTableRender extends JLabel implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        if (column == 0){

        }

        if (column == 1){

        }

        if (column == 2){

        }

        if (column == 3){

        }

        if (column == 4){
            Integer val = (Integer) value;
            if (val)
        }

        if (column == 5){

        }

        if (column == 6){
            Integer val = (Integer) value;
            setText(val.toString());
            if (val <= 10){
                setForeground(Color.red);
            }else if (val > 10 && val <= 50){
                setForeground(Color.blue);
            }else{
                setForeground(Color.green);
            }
        }


        if (column == 7){

        }


        return this;
    }
}
