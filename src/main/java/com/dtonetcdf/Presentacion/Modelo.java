/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dtonetcdf.Presentacion;

import com.dtonetcdf.ListCellRenderer.MyCellRenderer;
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

    public Sistema getSistema() {
        if (sistema == null) {
            sistema = new Sistema();
        }
        return sistema;
    }


    public void mostrarDatos(){
        getSistema().getVariableDTO().setVarSeleccionada(getVista().getList().getSelectedValue());
        getVistaDatos().getjTextArea().setText(getSistema().getVariableDTO().getImprimible());
        getVistaDatos().setVisible(true);

    }

    public void abrirArchivo(){
        int valor = getVista().getPicker().showOpenDialog(null);
        if (valor == JFileChooser.APPROVE_OPTION) {
            NetcdfFile file = null;
            try {
                getSistema().getArchivoDTO().setRuta(getVista().getPicker().getSelectedFile().getAbsolutePath().toString());
                for (Variable var :  getSistema().abrirarchivo().getVariables()) {
                    try {
                        getVista().getL1().addElement(var);
                    } catch (Exception es) {

                    }
                }
                getVista().setLayout(null);
                getVista().setList(new JList<>(getVista().getL1()));
                getVista().getList().setBounds(10, 10, 500, 500);
                getVista().getList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                getVista().getList().setCellRenderer(new MyCellRenderer());
                getVista().add(getVista().getList());
                getVista().add(getVista().getMostrarDatos());
                getVista().setVisible(true);

            } catch (IOException ioe) {
                System.out.println("trying to open " + getVista().getPicker().getSelectedFile().getAbsolutePath().toString() + ioe);
            }
        }
        getVista().repaint();


    }

}
