package com.dtonetcdf.Presentacion;



import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public final class ControlVista implements MouseListener, ActionListener, ComponentListener, ChangeListener  {

    private final Vista vista;
    private final Modelo modelo;


    public Modelo getModelo() {
        return modelo;
    }

    public ControlVista(Vista ventana) {
        this.vista = ventana;
        modelo = ventana.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();

            if (boton == vista.getMostrarDatos()) {
                getModelo().mostrarDatos();
            }
        }else if(e.getSource() instanceof JMenuItem)
        {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            if(menuItem==vista.getMenuAbrir()){
                getModelo().abrirArchivo();

            }
        }




        }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
