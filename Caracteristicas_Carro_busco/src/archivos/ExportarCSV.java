/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author user
 */
public class ExportarCSV {

    public ExportarCSV() {
    }

    public void exportarResultados(String subCategoria[], String marca[], String modelo[], String anio[],
            String estado[], String color[], String combustible[], String kilometraje[], String motor[], String asientos[],
            String transmision[], String timon[], String traccion[], String estilo[], String cilindros[], String trenManejo[],
            String chasis[], float precio[], String monedaSimbolo[], String fecha[], String estadoPublicacion[],
            String pais[], String departamento[]
    ) throws IOException {

        String outputFile = "C:/Users/user/Google Drive/Detalle_Carro_busco/bd_caracteristicas_carro_busco.csv";

        boolean alreadyExists = new File(outputFile).exists();

        if (alreadyExists) {
            File bd_detalle_10 = new File(outputFile);
            bd_detalle_10.delete();
        }

        CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');

        csvOutput.write("id");
        csvOutput.write("subCategoria");
        csvOutput.write("marca");
        csvOutput.write("modelo");
        csvOutput.write("anio");
        csvOutput.write("estado");
        csvOutput.write("color");
        csvOutput.write("combustible");
        csvOutput.write("kilometraje");
        csvOutput.write("motor");
        csvOutput.write("asientos");
        csvOutput.write("transmision");
        csvOutput.write("timon");
        csvOutput.write("traccion");
        csvOutput.write("estilo");
        csvOutput.write("cilindros");
        csvOutput.write("trenManejo");
        csvOutput.write("chasis");
        csvOutput.write("precio");
        csvOutput.write("monedaSimbolo");
        csvOutput.write("fecha");
        csvOutput.write("estadoPublicacion");
        csvOutput.write("pais");
        csvOutput.write("departamento");

        csvOutput.endRecord();

        for (int j = 0; j < 100000; j++) {

            if (!subCategoria[j].equalsIgnoreCase("")) {

                csvOutput.write(j + "");
                csvOutput.write(subCategoria[j]);
                csvOutput.write(marca[j]);
                csvOutput.write(modelo[j]);
                csvOutput.write(anio[j]);
                csvOutput.write(estado[j]);
                csvOutput.write(color[j]);
                csvOutput.write(combustible[j]);
                csvOutput.write(kilometraje[j]);
                csvOutput.write(motor[j]);
                csvOutput.write(asientos[j]);
                csvOutput.write(transmision[j]);
                csvOutput.write(timon[j]);
                csvOutput.write(traccion[j]);
                csvOutput.write(estilo[j]);
                csvOutput.write(cilindros[j]);
                csvOutput.write(trenManejo[j]);
                csvOutput.write(chasis[j]);
                csvOutput.write(precio[j] + "");
                csvOutput.write(monedaSimbolo[j]);
                csvOutput.write(fecha[j]);
                csvOutput.write(estadoPublicacion[j]);
                csvOutput.write(pais[j]);
                csvOutput.write(departamento[j]);

                csvOutput.endRecord();

            }

        }

        csvOutput.close();

    }

}
