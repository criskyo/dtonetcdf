package com.dtonetcdf.persistencia;

import ucar.nc2.NCdumpW;
import ucar.nc2.Variable;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class VariableDTO {

    private Variable varSeleccionada;




    public Variable getVarSeleccionada() {
        return varSeleccionada;
    }

    public void setVarSeleccionada(Variable varSeleccionada) {
        this.varSeleccionada = varSeleccionada;
    }

    public String getImprimible(){

        try {
        StringWriter out = new StringWriter();
        PrintWriter writerObj = new PrintWriter(out);
        NCdumpW.printArray(varSeleccionada.read(), varSeleccionada.getName(),
                writerObj, null);

            return out.toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return "";
    }

}
