/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Consultas {

    String sql;
    String[] kilometraje, motor, estado, marca, modelo, anio, combustible, transmision,
            timon, traccion, estilo, cilindros, trenManejo, chasis, color, asientos;
    String[] subCategoria, monedaSimbolo, fecha, estadoPublicacion;
    float[] precio;

    public Consultas() {

        kilometraje = new String[100000];
        motor = new String[100000];
        estado = new String[100000];
        marca = new String[100000];
        modelo = new String[100000];
        anio = new String[100000];
        combustible = new String[100000];
        transmision = new String[100000];
        timon = new String[100000];
        traccion = new String[100000];
        estilo = new String[100000];
        cilindros = new String[100000];
        trenManejo = new String[100000];
        chasis = new String[100000];
        color = new String[100000];
        asientos = new String[100000];

        //****************************//
        subCategoria = new String[100000];
        monedaSimbolo = new String[100000];
        fecha = new String[100000];
        precio = new float[100000];
        estadoPublicacion = new String[100000];

    }

    public void iniciar() {

        for (int i = 0; i < 100000; i++) {

            kilometraje[i] = "";
            motor[i] = "";
            estado[i] = "";
            marca[i] = "";
            modelo[i] = "";
            anio[i] = "";
            combustible[i] = "";
            transmision[i] = "";
            timon[i] = "";
            traccion[i] = "";
            estilo[i] = "";
            cilindros[i] = "";
            trenManejo[i] = "";
            chasis[i] = "";
            color[i] = "";
            asientos[i] = "";

            //***************//
            subCategoria[i] = "";
            monedaSimbolo[i] = "";
            fecha[i] = "";
            precio[i] = 0.0f;
            estadoPublicacion[i] = "";

        }

    }

    public void completarCaracteristicas() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select id,idAviso,idCaracteristica,valor from mod_aviso_caracteristicas_x_aviso where idCaracteristica>=19 and idCaracteristica<=34";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            /**
             * System.out.println(rs.getString("id")+ ","
             * +rs.getString("idAviso") + "," + rs.getString("idCaracteristica")
             * + "," + rs.getString("valor"));
             */
            String idCaracteristica = rs.getString("idCaracteristica");
            int id = Integer.parseInt(rs.getString("idAviso"));

            if (idCaracteristica.equalsIgnoreCase("19")) {

                kilometraje[id] = rs.getString("valor");

            } else if (idCaracteristica.equalsIgnoreCase("20")) {
                motor[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("21")) {
                estado[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("22")) {
                marca[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("23")) {
                modelo[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("24")) {
                anio[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("25")) {
                combustible[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("26")) {
                transmision[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("27")) {
                timon[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("28")) {
                traccion[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("29")) {
                estilo[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("30")) {
                cilindros[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("31")) {
                trenManejo[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("32")) {
                chasis[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("33")) {
                color[id] = rs.getString("valor");
            } else if (idCaracteristica.equalsIgnoreCase("34")) {
                asientos[id] = rs.getString("valor");
            }

        }

        /**
         * for (int i = 0; i < 100000; i++) {
         *
         * if (marca[i].equalsIgnoreCase("")) {
         *
         * }else{
         *
         *
         * System.out.println(i+","+marca[i]+","+modelo[i]+","+anio[i]+","+estado[i]+","+color[i]
         * +","+combustible[i]+","+kilometraje[i]+","+motor[i]+","+asientos[i]
         * +","+transmision[i]+","+timon[i]+","+traccion[i]+","+estilo[i]+","
         * +cilindros[i]+","+trenManejo[i]+","+chasis[i]);
         *
         * }
         *
         *
         *
         *
         * }
         *
         */
        objCon.desconectar();

    }

    public void completarPrecios() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select id,idSubcategoria,precio,moneda_simbolo,fchPublicacion,estado from db_todobusco_prod.mod_aviso_aviso where idCategoria=2";

        PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            /**
             * System.out.println(rs.getInt("id")+ ","
             * +rs.getInt("idSubcategoria") + "," + rs.getFloat("precio") + ","
             * + rs.getString("moneda_simbolo") + "," +
             * rs.getString("fchPublicacion"));
             */
            int idAviso = rs.getInt("id");
            int idSubcategoria = rs.getInt("idSubcategoria");
            int estadoP = rs.getInt("estado");

            if (idSubcategoria == 11) {
                subCategoria[idAviso] = "Auto";
            } else if (idSubcategoria == 12) {
                subCategoria[idAviso] = "Moto";
            } else if (idSubcategoria == 13) {
                subCategoria[idAviso] = "Camion y Bus";
            } else if (idSubcategoria == 14) {
                subCategoria[idAviso] = "Yate y Barco";
            } else if (idSubcategoria == 15) {
                subCategoria[idAviso] = "Equipo Pesado";
            }

            if (estadoP == 0) {
                estadoPublicacion[idAviso] = "Despublicado";
            } else if (estadoP == 1) {
                estadoPublicacion[idAviso] = "Publicado";
            } else if (estadoP == 2) {
                estadoPublicacion[idAviso] = "Caducado";
            } else if (estadoP == 3) {
                estadoPublicacion[idAviso] = "Eliminado";
            } else if (estadoP == 4) {
                estadoPublicacion[idAviso] = "Pendiente de Pago";
            } else if (estadoP == 5) {
                estadoPublicacion[idAviso] = "Moderado";
            } else if (estadoP == 6) {
                estadoPublicacion[idAviso] = "De Baja";
            } else if (estadoP == 7) {
                estadoPublicacion[idAviso] = "Vendido";
            } else if (estadoP == 8) {
                estadoPublicacion[idAviso] = "Pendiente de Publicacion";
            } else {
                estadoPublicacion[idAviso] = "No Definido";
            }

            precio[idAviso] = rs.getFloat("precio");
            monedaSimbolo[idAviso] = rs.getString("moneda_simbolo");
            fecha[idAviso] = rs.getString("fchPublicacion");

        }
        /**
         * for (int i = 0; i < 100000; i++) {
         *
         * if (subCategoria[i].equalsIgnoreCase("")) {
         *
         * }else{
         * System.out.println(i+","+subCategoria[i]+","+precio[i]+","+monedaSimbolo[i]+","+fecha[i]
         * );
         *
         * }
         *
         * }
         *
         */

        objCon.desconectar();
    }

    public void mostrarTotales() {

        System.out.println("//**********INICIO************//");

        for (int i = 0; i < 100000; i++) {

            System.out.println(i + "," + subCategoria[i]
                    + "," + marca[i] + "," + modelo[i] + "," + anio[i] + "," + estado[i] + "," + color[i]
                    + "," + combustible[i] + "," + kilometraje[i] + "," + motor[i] + "," + asientos[i]
                    + "," + transmision[i] + "," + timon[i] + "," + traccion[i] + "," + estilo[i] + ","
                    + cilindros[i] + "," + trenManejo[i] + "," + chasis[i]
                    + "," + precio[i] + "," + monedaSimbolo[i] + "," + fecha[i]
            );

        }

    }

    public void mostrarVehiculos() {

        System.out.println("id;subCategoria;marca;modelo;anio;estado;color"
                + ";combustible;kilometraje;motor;asientos"
                + ";transmision;timon;traccion;estilo"
                + ";cilindros;trenManejo;chasis"
                + ";precio;monedaSimbolo;fecha;estadoPublicacion");

        for (int i = 0; i < 100000; i++) {

            if (subCategoria[i].equalsIgnoreCase("")) {

            } else {

                System.out.println(i + ";" + subCategoria[i]
                        + ";" + marca[i] + ";" + modelo[i] + ";" + anio[i] + ";" + estado[i] + ";" + color[i]
                        + ";" + combustible[i] + ";" + kilometraje[i] + ";" + motor[i] + ";" + asientos[i]
                        + ";" + transmision[i] + ";" + timon[i] + ";" + traccion[i] + ";" + estilo[i] + ";"
                        + cilindros[i] + ";" + trenManejo[i] + ";" + chasis[i]
                        + ";" + precio[i] + ";" + monedaSimbolo[i] + ";" + fecha[i] + ";" + estadoPublicacion[i]
                );

            }

        }

    }

}
