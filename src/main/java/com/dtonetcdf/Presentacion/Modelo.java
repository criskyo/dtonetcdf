/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dtonetcdf.Presentacion;

import com.dtonetcdf.ListCellRenderer.MyCellRenderer;
import com.dtonetcdf.ListCellRenderer.NetcdfTableModel;
import com.dtonetcdf.Logica.Sistema;

import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import javax.swing.*;
import java.io.IOException;


public class Modelo {
    private Vista vista;

    private VistaDatos vistaDatos;
    private Sistema sistema;

    public void iniciar() {
        getVista().setSize(1800, 900);
        getVista().setVisible(true);

    }

    public Vista getVista() {
        if (vista == null) {
            vista = new Vista(this);
        }
        return vista;
    }

    public VistaDatos getVistaDatos() {
        if (vistaDatos == null) {
            vistaDatos = new VistaDatos(this);
        }
        return vistaDatos;
    }

   /* public VistaVariables getVistaVariables() {
        if (vistaVariables == null) {
            vistaVariables = new VistaVariables(this);
        }
        return vistaVariables;
    }*/

    public Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }


    public void mostrarDatos(){


    }

    public void abrirArchivo(){
        int valor = getVista().getPicker().showOpenDialog(null);
        if (valor == JFileChooser.APPROVE_OPTION) {
            NetcdfFile file = null;
            try {
                getSistema().getArchivoDTO().setRuta(getVista().getPicker().getSelectedFile().getAbsolutePath().toString());
                getVista().setTabla(new JTable());
                NetcdfTableModel netcdfTableModel= new NetcdfTableModel(getSistema().abrirarchivo().getVariables());
                getVista().getTabla().setModel(netcdfTableModel);
                getVista().getTabla().setBounds(30, 40, 200, 300);
                getVista().getTabla().addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if(evt.getClickCount() ==2)
                        getSistema().getVariableDTO().setVarSeleccionada(getSistema().getArchivoDTO().getVariables().get(getVista().getTabla().getSelectedRow()));
                        getVistaDatos().getjTextArea().setText(getSistema().getVariableDTO().getImprimible());
                        getVistaDatos().setVisible(true);

                    }
                });
                getVista().setjScrollPane(new JScrollPane(getVista().getTabla()));
                getVista().add(getVista().getjScrollPane());

                getVista().setVisible(true);

            } catch (IOException ioe) {
                System.out.println("trying to open " + getVista().getPicker().getSelectedFile().getAbsolutePath().toString() + ioe);
            }
        }
        getVista().repaint();
        getVistaDatos().repaint();



    }

}
