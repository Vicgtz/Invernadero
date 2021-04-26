/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dominio.sensor;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Equipo 04
 */
public class ConexionBD implements IConexion {

    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuarioBD = "root";
    private final String passBD = "12345678";
    private final String servidorBD = "localhost";
    private final String nombreBD = "invernadero";
    private final String puertoBD = "3306";
    private Connection conn = null;

    public ConexionBD() {
    }

    @Override
    public boolean conectar() {
        boolean correcto = false;
        String url = "jdbc:mysql://" + servidorBD + ":" + puertoBD + "/" + nombreBD + "?useSSL=false";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuarioBD, passBD);
            correcto = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            correcto = false;
        }
        return correcto;
    }

    @Override
    public boolean desconectar() {
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean hayConexion() {

        try {
            return conn.isValid(1);
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean insertarSensor(sensor entidad) {
        String sql = "INSERT INTO invernadero.sensor (clave, marca, invernadero, numero, correo) VALUES (" + entidad.getClave() + ", " + entidad.getMarca() 
                + ", " + entidad.getInvernadero() + ", " + entidad.getNumero()+", '" + entidad.getCorreo()+ "')";
        try {
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    @Override
    public ArrayList<sensor> consultarSensores() {
        String SQL = "SELECT * FROM sensores";
        try {
            ArrayList sensores = new ArrayList<sensor>();
            // PreparedStatement
            PreparedStatement pstm = conn.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery(SQL);
            while (rs.next()) {
                sensor s = new sensor(rs.getString("idSensor"),rs.getString("clave"),rs.getString("invernadaro"), rs.getString("numero"),rs.getString("correo"));
                sensores.add(s);
            }
            pstm.close();
            return sensores;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
