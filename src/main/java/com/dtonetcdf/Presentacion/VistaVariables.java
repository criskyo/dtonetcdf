package com.dtonetcdf.Presentacion;

import javax.swing.*;

public class VistaVariables extends javax.swing.JFrame{
    private JScrollPane jScrollPane;
    private JTable tabla;
    private final Modelo modelo;


    public VistaVariables(Modelo aThis) {
        modelo = aThis;
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        setSize(300, 400);
    //        setjScrollPane(new JScrollPane(tabla));
    }


    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
}
