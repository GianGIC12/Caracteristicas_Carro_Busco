/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import conexion.Conexion;
import gestion.Consultas;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Consultas e= new Consultas();
        
        e.iniciar();
        
        e.completarCaracteristicas();
        e.completarPrecios();
        
        e.mostrarVehiculos();
        
        
    }
    
}
