package com.dtonetcdf.ListCellRenderer;

import ucar.nc2.Variable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class NetcdfTableModel extends AbstractTableModel {


    List<Variable> vars;
    String[] headerList = { "Nombre", "Descripcion", "Tipo","Dimensiones","Tamaño" };



    public NetcdfTableModel (List<Variable> list){
        vars=list;
    }

    @Override
    public int getColumnCount() {
        return headerList.length;
    }


    @Override
    public int getRowCount() {
        return vars.size();
    }

    public String getColumnName(int col) {
        return headerList[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Variable var =null;
        var=vars.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return var.getName()==null?"":var.getName().toString() ;
            case 1:
                return var.getDescription()==null?"":var.getDescription().toString();
            case 2:
                return var.getDataType()==null?"":var.getDataType().toString();
            case 3:
                return var.getDimensions()==null?"":var.getDimensions().toString();
            case 4:
                int[] size = var.getShape();
                String shape= "";
                for (int i = 0; i < size.length; ++i) {
                    System.out.print(" " + size[i]);
                    shape = shape + " "+size[i];

                }

                return var.getDimensions()==null?"":var.getDimensions().toString();

            default:
                return "";
        }


    }
}
