package com.dtonetcdf.Persistencia;

import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

import java.util.List;

public class ArchivoDTO {

    private NetcdfFile netcdfFile;
    private String ruta;
    private List<Variable> variables;


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

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }
}
