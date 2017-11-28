/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import archivos.ExportarCSV;
import conexion.Conexion;
import gestion.Consultas;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here

        Consultas c = new Consultas();

        c.iniciar();

        c.completarCaracteristicas();
        c.completarPrecios();

        c.mostrarVehiculos();

        ExportarCSV ex = new ExportarCSV();

        ex.exportarResultados(c.getSubCategoria(), c.getMarca(), c.getModelo(), c.getAnio(),
                c.getEstado(), c.getColor(), c.getCombustible(), c.getKilometraje(), c.getMotor(),
                c.getAsientos(), c.getTransmision(), c.getTimon(), c.getTraccion(), c.getEstilo(),
                c.getCilindros(), c.getTrenManejo(), c.getChasis(), c.getPrecio(),
                c.getMonedaSimbolo(), c.getFecha(), c.getEstadoPublicacion(),
                c.getPais(), c.getDepartamento());

    }

}
