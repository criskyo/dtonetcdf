package com.dtonetcdf.ListCellRenderer;

import ucar.nc2.Variable;

import javax.swing.*;
import java.awt.*;

public class MyCellRenderer extends JLabel implements ListCellRenderer<Variable> {

    public MyCellRenderer()
    {
        setOpaque(true);
    }


    @Override
    public Component getListCellRendererComponent(JList<? extends Variable> list, Variable value, int index, boolean isSelected, boolean cellHasFocus) {

        String text=value.getDescription() +" " + value.getName() + " (Tipo: " + value.getDataType().name() + ", Dimensiones: " + value.getDimensionsString() + ", Tamaño:";
        int [] size = value.getShape();
        for(int i=0; i<size.length;++i){

            text = text + " " +size[i];
        }

        text = text +")";
        setText(text);

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }


        return this;
    }



  /*  @Override
    public Component getListCellRendererComponent(JList<?> list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {

        if (value instanceof Variable) {

            Variable var = (Variable) value;

            String text="  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:";
            int [] size = var.getShape();
            for(int i=0; i<size.length;++i){

                text = text + " " +size[i];
            }

            text = text +")";
        setText(text);

        Color background;
        Color foreground;

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = Color.BLUE;
            foreground = Color.WHITE;

            // check if this cell is selected
        } else if (isSelected) {
            background = Color.RED;
            foreground = Color.WHITE;

            // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };

        setBackground(background);
        setForeground(foreground);
        }
        return this;
    }*/
}
