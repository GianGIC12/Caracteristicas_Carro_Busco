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
    String[] subCategoria, monedaSimbolo, fecha, estadoPublicacion, pais, departamento;

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
        pais = new String[100000];
        departamento = new String[100000];

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
            pais[i] = "";
            departamento[i] = "";

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

        objCon.desconectar();

    }

    public void completarPrecios() throws SQLException {

        Conexion objCon = new Conexion();

        objCon.conectar();

        sql = "select id,idSubcategoria,precio,moneda_simbolo,fchPublicacion,estado,idPais,idDpto from db_todobusco_prod.mod_aviso_aviso where idCategoria=2";

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

            String fechita = "";
            if (rs.getString("fchPublicacion") != null) {

                fechita = rs.getString("fchPublicacion").substring(0, 10);

                System.out.println("" + fechita + "*******************");

            }else {
                
                fechita="1900-01-01";
                
            }

            fecha[idAviso] = fechita;

            String paises = "";

            if (rs.getInt("idPais") == 1) {

                paises = "Nicaragua";

            } else if (rs.getInt("idPais") == 38) {

                paises = "Costa Rica";

            } else {

                paises = "No definido";

            }

            String departamentos = "";

            if (rs.getInt("idDpto") == 1) {

                departamentos = "Carazao";

            } else if (rs.getInt("idDpto") == 2) {

                departamentos = "Chinandega";

            } else if (rs.getInt("idDpto") == 3) {

                departamentos = "Granada";

            } else if (rs.getInt("idDpto") == 4) {

                departamentos = "Leon";

            } else if (rs.getInt("idDpto") == 5) {

                departamentos = "Managua";

            } else if (rs.getInt("idDpto") == 6) {

                departamentos = "Masaya";

            } else if (rs.getInt("idDpto") == 7) {

                departamentos = "Rivas";

            } else if (rs.getInt("idDpto") == 8) {

                departamentos = "Boaco";

            } else if (rs.getInt("idDpto") == 9) {

                departamentos = "Chontales";

            } else if (rs.getInt("idDpto") == 10) {

                departamentos = "Esteli";

            } else if (rs.getInt("idDpto") == 11) {

                departamentos = "Jinotega";

            } else if (rs.getInt("idDpto") == 12) {

                departamentos = "Madriz";

            } else if (rs.getInt("idDpto") == 13) {

                departamentos = "Matagalpa";

            } else if (rs.getInt("idDpto") == 14) {

                departamentos = "Nueva Segobia";

            } else if (rs.getInt("idDpto") == 15) {

                departamentos = "Rio San Juan";

            } else if (rs.getInt("idDpto") == 16) {

                departamentos = "Caribe Norte";

            } else if (rs.getInt("idDpto") == 17) {

                departamentos = "Caribe Sur";

            } else if (rs.getInt("idDpto") == 18) {

                departamentos = "Alajuela";

            } else if (rs.getInt("idDpto") == 19) {

                departamentos = "Cartago";

            } else if (rs.getInt("idDpto") == 20) {

                departamentos = "Guanacaste";

            } else if (rs.getInt("idDpto") == 21) {

                departamentos = "Heredia";

            } else if (rs.getInt("idDpto") == 22) {

                departamentos = "Limon";

            } else if (rs.getInt("idDpto") == 23) {

                departamentos = "Puntarenas";

            } else if (rs.getInt("idDpto") == 24) {

                departamentos = "San Jose";

            } else {

                departamentos = "No Definido";

            }

            pais[idAviso] = paises;
            departamento[idAviso] = departamentos;

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
                        + ";" + pais[i] + ";" + departamento[i]
                );

            }

        }

    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String[] getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String[] kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String[] getMotor() {
        return motor;
    }

    public void setMotor(String[] motor) {
        this.motor = motor;
    }

    public String[] getEstado() {
        return estado;
    }

    public void setEstado(String[] estado) {
        this.estado = estado;
    }

    public String[] getMarca() {
        return marca;
    }

    public void setMarca(String[] marca) {
        this.marca = marca;
    }

    public String[] getModelo() {
        return modelo;
    }

    public void setModelo(String[] modelo) {
        this.modelo = modelo;
    }

    public String[] getAnio() {
        return anio;
    }

    public void setAnio(String[] anio) {
        this.anio = anio;
    }

    public String[] getCombustible() {
        return combustible;
    }

    public void setCombustible(String[] combustible) {
        this.combustible = combustible;
    }

    public String[] getTransmision() {
        return transmision;
    }

    public void setTransmision(String[] transmision) {
        this.transmision = transmision;
    }

    public String[] getTimon() {
        return timon;
    }

    public void setTimon(String[] timon) {
        this.timon = timon;
    }

    public String[] getTraccion() {
        return traccion;
    }

    public void setTraccion(String[] traccion) {
        this.traccion = traccion;
    }

    public String[] getEstilo() {
        return estilo;
    }

    public void setEstilo(String[] estilo) {
        this.estilo = estilo;
    }

    public String[] getCilindros() {
        return cilindros;
    }

    public void setCilindros(String[] cilindros) {
        this.cilindros = cilindros;
    }

    public String[] getTrenManejo() {
        return trenManejo;
    }

    public void setTrenManejo(String[] trenManejo) {
        this.trenManejo = trenManejo;
    }

    public String[] getChasis() {
        return chasis;
    }

    public void setChasis(String[] chasis) {
        this.chasis = chasis;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String[] getAsientos() {
        return asientos;
    }

    public void setAsientos(String[] asientos) {
        this.asientos = asientos;
    }

    public String[] getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String[] subCategoria) {
        this.subCategoria = subCategoria;
    }

    public String[] getMonedaSimbolo() {
        return monedaSimbolo;
    }

    public void setMonedaSimbolo(String[] monedaSimbolo) {
        this.monedaSimbolo = monedaSimbolo;
    }

    public String[] getFecha() {
        return fecha;
    }

    public void setFecha(String[] fecha) {
        this.fecha = fecha;
    }

    public String[] getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public void setEstadoPublicacion(String[] estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public float[] getPrecio() {
        return precio;
    }

    public void setPrecio(float[] precio) {
        this.precio = precio;
    }

    public String[] getPais() {
        return pais;
    }

    public void setPais(String[] pais) {
        this.pais = pais;
    }

    public String[] getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String[] departamento) {
        this.departamento = departamento;
    }

}
