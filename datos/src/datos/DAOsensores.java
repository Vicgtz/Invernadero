/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


import Dominio.sensor;
import Dominio.sensoresDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author DELL
 */
public class DAOsensores extends CRUD<sensoresDatos> {

    @Override
    public void guardar(sensoresDatos entidad) {
        try {
            Connection conexion = this.getConexion();
            String sql = "INSERT INTO invernadero.sensoresdatos (fecha, sensor, temperatura, humedad) VALUES (?,?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(sql);
            java.sql.Date date = new java.sql.Date(entidad.getFecha().getTime());
            
            ps.setDate(1, date);
            ps.setInt(2, entidad.getSensor().getId());          
            ps.setFloat(3, entidad.getTemperatura());
            ps.setFloat(4, entidad.getHumedad());
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    
    }

    @Override
    public void eliminar(sensoresDatos entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<sensoresDatos> obtener() {
        ArrayList<sensoresDatos> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
           
            String sql = "SELECT * FROM invernadero.sensoresdatos;";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            CRUD sensor = new DAOsensor();
            while(rs.next())
            {                
                int id = rs.getInt(1);
                Date fecha = rs.getDate(2);
                sensor sen = (sensor) sensor.ObtenerUno(rs.getInt(2) + "");
                float temperatura = rs.getFloat("temperatura");
                float humedad = rs.getFloat("humedad");
                
               
               sensoresDatos p = new sensoresDatos(id, fecha, sen, temperatura, humedad);
                listaP.add(p);
            }
            conexion.close();
            return listaP;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return listaP;
        }
    }

    @Override
    public sensoresDatos ObtenerUno(String textoBusqueda) {
        sensoresDatos da=null; 
        try {
            Connection conexion = this.getConexion();
            String sql = "SELECT * FROM invernadero.sensoresdatos WHERE idsensoresdatos = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(textoBusqueda));
            ResultSet rs = ps.executeQuery();

            CRUD  sensor = new DAOsensor();

            rs.next();
                int id = rs.getInt(1);
                Date fecha = rs.getDate(2);
                sensor sen = (sensor) sensor.ObtenerUno(rs.getInt(2) + "");
                float temperatura = rs.getFloat("temperatura");
                float humedad = rs.getFloat("humedad");
                da = new sensoresDatos(id, fecha, sen, temperatura, humedad);

            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return da;
    }
    
}
