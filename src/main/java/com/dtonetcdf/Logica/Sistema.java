package com.dtonetcdf.Logica;

import com.dtonetcdf.persistencia.ArchivoDTO;
import com.dtonetcdf.persistencia.VariableDTO;
import ucar.nc2.NetcdfFile;

import java.io.IOException;

public class Sistema {

    private ArchivoDTO ArchivoDTO;
    private VariableDTO variableDTO;




    public ArchivoDTO getArchivoDTO() {
        if (ArchivoDTO == null) {
            ArchivoDTO = new ArchivoDTO();
        }
        return ArchivoDTO;
    }

    public void setArchivoDTO(ArchivoDTO archivoDTO) {
        ArchivoDTO = archivoDTO;
    }

    public VariableDTO getVariableDTO() {
        if(variableDTO==null){
            variableDTO = new VariableDTO();
        }
        return variableDTO;
    }

    public void setVariableDTO(VariableDTO variableDTO) {
        this.variableDTO = variableDTO;
    }

    public NetcdfFile abrirarchivo() throws IOException {
        getArchivoDTO().setNetcdfFile(NetcdfFile.open(getArchivoDTO().getRuta()));
        return getArchivoDTO().getNetcdfFile();
    }


}
