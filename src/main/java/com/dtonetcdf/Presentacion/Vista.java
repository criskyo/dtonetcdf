package com.dtonetcdf.Presentacion;

import ucar.nc2.Variable;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class Vista extends javax.swing.JFrame {


    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuAbrir;
    private JFileChooser picker;
    private final Modelo modelo;
    private ControlVista control;
    private JList<Variable> list;
    private DefaultListModel<Variable> l1;



    private JButton mostrarDatos;

    public ControlVista getControl() {
        if(control == null){
            control = new ControlVista(this);
        }
        return control;
    }


    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();
        this.setVisible(true);
    }




    private void initComponents() {
        jMenuBar2 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        setMenuAbrir(new JMenuItem());

        setPicker(new JFileChooser());
        setL1(new DefaultListModel<>());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        menuArchivo.setText("Archivo");

        getMenuAbrir().setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        getMenuAbrir().setText("Abrir");
        getMenuAbrir().addActionListener(getControl());
        menuArchivo.add(getMenuAbrir());
        jMenuBar2.add(menuArchivo);
        setJMenuBar(jMenuBar2);



        setMostrarDatos(new JButton("mostrar datos"));
        getMostrarDatos().setBounds(600, 600, 100, 30);

        getMostrarDatos().addActionListener(getControl());


    }


    public Modelo getModelo() {
        return modelo;
    }

    public JFileChooser getPicker() {
        return picker;
    }

    public void setPicker(JFileChooser picker) {
        this.picker = picker;
    }

    public JList<Variable> getList() {
        return list;
    }

    public void setList(JList<Variable> list) {
        this.list = list;
    }

    public DefaultListModel<Variable> getL1() {
        return l1;
    }

    public void setL1(DefaultListModel<Variable> l1) {
        this.l1 = l1;
    }

    public JButton getMostrarDatos() {
        return mostrarDatos;
    }

    public void setMostrarDatos(JButton mostrarDatos) {
        this.mostrarDatos = mostrarDatos;
    }


    public JMenuItem getMenuAbrir() {
        return menuAbrir;
    }

    public void setMenuAbrir(JMenuItem menuAbrir) {
        this.menuAbrir = menuAbrir;
    }
}



