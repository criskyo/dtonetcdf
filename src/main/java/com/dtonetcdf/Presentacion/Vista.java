package com.dtonetcdf.Presentacion;

import com.dtonetcdf.ListCellRenderer.MyCellRenderer;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class Vista extends javax.swing.JFrame{




    private javax.swing.JMenu menuArchivo;

    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JToolBar jToolBar1;


    private JDialog dialog;
    private JSlider slider ;
    private final Modelo modelo;
    JList<Variable> list ;

    public Vista(Modelo aThis) {
        modelo = aThis;
        initComponents();


        this.setVisible(true);
    }




    private void initComponents() {


        jMenuBar2 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();






        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        //jToolBar1.setRollover(true);



        menuArchivo.setText("Archivo");

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuAbrir);
        jMenuBar2.add(menuArchivo);



        setJMenuBar(jMenuBar2);

    }




    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed


        JFileChooser picker = new JFileChooser();
        int valor = picker.showOpenDialog(null);
        if(valor == JFileChooser.APPROVE_OPTION)
        { NetcdfFile file = null;
            try {

                System.out.println(picker.getSelectedFile().getAbsolutePath());
           file = NetcdfFile.open(picker.getSelectedFile().getAbsolutePath().toString());

                List<Variable> vars = file.getVariables();
                System.out.println("Total de variables "+vars.size());
                JFrame f= new JFrame();
                DefaultListModel<Variable> l1 = new DefaultListModel<>();
                //DefaultListModel<String> l1 = new DefaultListModel<>();
                for( Variable var: vars){
                    try {


                        System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");
                        String text="  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:";
                        int [] size = var.getShape();
                        for(int i=0; i<size.length;++i){
                            System.out.print(" " +size[i]);
                            text = text + " " +size[i];
                        }
                        System.out.println(")");
                        text = text +")";
                        //System.out.println("ranges "+var.getRanges());
                        //System.out.println("read "+var.read());

                        l1.addElement(var);

                        System.out.println("/*/*/*/*/*/*/*/*/*/");

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }




                list = new JList<>(l1);
                list.setBounds(10,10, 2300,500);
                list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                list.setLayoutOrientation(JList.VERTICAL_WRAP);
                list.setCellRenderer(new MyCellRenderer());
                list.setAutoscrolls(true);

                f.add(list);
                f.setSize(2300,800);

                f.setVisible(true);
                JButton boton1;
                boton1=new JButton("Finalizar");
                boton1.setBounds(300,250,100,30);
                add(boton1);
                boton1.addActionListener(this::actionPerformed);




            } catch (IOException ioe) {
                System.out.println("trying to open " + picker.getSelectedFile().getAbsolutePath().toString()+ ioe);
            } finally {
                if (null != file) try {
                    file.close();
                } catch (IOException ioe) {
                    System.out.println("trying to close " + picker.getSelectedFile().getAbsolutePath().toString()+ ioe);
                }
            }
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("test");

        }
    }



