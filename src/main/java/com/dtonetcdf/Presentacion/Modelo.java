/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dtonetcdf.Presentacion;

public class Modelo {
    private Vista paint;

    public void iniciar() {
        getVista().setSize(1800, 900);
        getVista().setVisible(true);

    }

    public Vista getVista() {
        if (paint == null) {
            paint = new Vista(this);
        }
        return paint;
    }

}
