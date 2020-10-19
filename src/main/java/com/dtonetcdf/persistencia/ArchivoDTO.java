package com.dtonetcdf.persistencia;

import ucar.nc2.NetcdfFile;

public class ArchivoDTO {

    private NetcdfFile netcdfFile;
    private String ruta;


    public NetcdfFile getNetcdfFile() {
        return netcdfFile;
    }

    public void setNetcdfFile(NetcdfFile netcdfFile) {
        this.netcdfFile = netcdfFile;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

}
