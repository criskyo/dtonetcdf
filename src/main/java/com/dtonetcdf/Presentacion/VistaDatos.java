package com.dtonetcdf.Presentacion;

import javax.swing.*;

public class VistaDatos extends javax.swing.JFrame {

    private JTextArea jTextArea;
    JScrollPane sp;
    private final Modelo modelo;

    public VistaDatos(Modelo aThis){
        modelo = aThis;
        initComponents();
    }

    private void initComponents() {

        jTextArea=  new JTextArea("test ", 10000, 10000);
        sp = new JScrollPane(jTextArea);
        jTextArea.setBounds(30, 40, 200, 300);
        setSize(800,800);
        add(sp);
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }
}
