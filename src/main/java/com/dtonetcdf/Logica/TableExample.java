package com.dtonetcdf.Logica;

import com.dtonetcdf.ListCellRenderer.NetcdfTableModel;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TableExample extends javax.swing.JFrame {

    JTable jt;

    TableExample() {


        try {
            NetcdfFile file = null;
            file = NetcdfFile.open("/home/bg-d-cortiz/Escritorio/outN.1");

        List<Variable> vars = file.getVariables();
            for (Variable var : vars) {
                try {
                    System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");

                    int[] size = var.getShape();
                    for (int i = 0; i < size.length; ++i) {
                        System.out.print(" " + size[i]);

                    }
                    System.out.println(")");

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            NetcdfTableModel netcdfTableModel= new NetcdfTableModel(vars);

       //JTextArea jt= new JTextArea("test ", 10000, 10000);

        jt = new JTable();
        jt.setModel(netcdfTableModel);
        jt.setBounds(30, 40, 200, 300);
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount() ==2)
                System.out.println("row mouse"+ jt.getSelectedRow());

            }
        });
        JScrollPane sp = new JScrollPane(jt);


        setSize(300, 400);


        add(sp);
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void actionPerformed(ActionEvent e) {

        System.out.println("row"+ jt.getSelectedRow());


    }

    public static void main(String[] args) {
        new TableExample();
    }

}


