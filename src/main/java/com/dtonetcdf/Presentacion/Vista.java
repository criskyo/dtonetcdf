package com.dtonetcdf.Presentacion;

import com.dtonetcdf.ListCellRenderer.MyCellRenderer;
import ucar.ma2.Array;
import ucar.ma2.InvalidRangeException;
import ucar.nc2.NCdumpW;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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

                //////
                String data[][]={ {"101","Amit","670000"},
                        {"102","Jai","780000"},
                        {"101","Sachin","700000"}};
                String column[]={"ID","NAME","SALARY"};
                JTable jt=new JTable(data,column);

                //////


                DefaultListModel<Variable> l1 = new DefaultListModel<>();

                for( Variable var: vars){
                    try {


                        System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");

                        int [] size = var.getShape();
                        for(int i=0; i<size.length;++i){
                            System.out.print(" " +size[i]);

                        }
                        System.out.println(")");

                        //System.out.println("ranges "+var.getRanges());
                        //System.out.println("read "+var.read());

                        l1.addElement(var);

                        System.out.println("/*/*/*/*/*/*/*/*/*/");

                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }



                f.setLayout(null);
                setLayout(null);
                list = new JList<>(l1);
                list.setBounds(10,10, 500,500);
                list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                list.setCellRenderer(new MyCellRenderer());


                add(list);
                //f.setSize(1300,800);


                JButton boton1;
                boton1=new JButton("mostrar datos");
                boton1.setBounds(600,600,100,30);
                add(boton1);
                boton1.addActionListener(this::actionPerformed);
                setVisible(true);




            } catch (IOException ioe) {
                System.out.println("trying to open " + picker.getSelectedFile().getAbsolutePath().toString()+ ioe);
            } finally {
                /*if (null != file)
                    try {
                   // file.close();
               // } catch (IOException ioe) {
                    System.out.println("trying to close " + picker.getSelectedFile().getAbsolutePath().toString()+ ioe);
               // }
            */}
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("test");
        Variable vars =list.getSelectedValue();
        System.out.println("variables " + vars);
        JTextArea jt;
        jt = new JTextArea("test ",10000, 10000);

        try {

            //jt.setText(vars.read().toString());

                //Array data = vars.read("0:2:1, 0:19:1");
            Array data = vars.read();
            StringWriter out    = new StringWriter();
            PrintWriter writerObj = new PrintWriter(out);
            NCdumpW.printArray(data, vars.getName(),
                    writerObj, null);

            //System.out.println("var "+vars.read());
            //for (int i = 0; i < 100; i++) {
                //Array array=vars.read();
               // System.out.println(" array "+data.getSize());
                jt.setText(out.toString());
            //}
           // System.out.println("var "+vars.read().getSize());
       } catch (IOException ioException) {
            ioException.printStackTrace();
        }
       /*   catch (InvalidRangeException invalidRangeException) {
        invalidRangeException.printStackTrace();
    }*/
        JFrame f = new JFrame("Datos");
        jt.setBounds(10,10,1200,700);
        //JPanel p = new JPanel();
        /*JButton boton1;
        boton1=new JButton("mostrar datos");
        boton1.setBounds(600,600,100,30);
        f.add(boton1);*/
        //p.add(jt);
        f.add(jt);


       // f.add(jt);

        setLayout(null);
        f.setLayout(null);
        f.setSize(1300,800);


        f.setVisible(true);
        f.show();
    }
    }



