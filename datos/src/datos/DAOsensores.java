/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.invernadero;
import Dominio.sensor;
import Dominio.sensoresDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class DAOsensores extends CRUD<sensoresDatos> {

    @Override
    public void guardar(sensoresDatos entidad) {
        try{
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();           
            String sql = String.format("INSERT INTO `invernadero`.`sensoresdatos` (`fecha`, `sensor`, `temperatura`, `humedad`) VALUES ('%s', '%s', '%s', '%s');", 
                    entidad.getFecha() , entidad.getSensor(), entidad.getTemperatura(), entidad.getHumedad());
            comando.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
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
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idsensoresdatos, fecha, sensor, temperatura, humedad FROM invernadero.sensoresdatos;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idsensoresdatos");
                Date fecha = resultado.getDate("fecha");
                int sen = resultado.getInt("sensor");
                String temperatura = resultado.getString("temperatura");
                String humedad = resultado.getString("humedad");
                
                sensor s =(sensor) new DAOsensor().ObtenerUno(sen+"");
               sensoresDatos p = new sensoresDatos(id, fecha, s, temperatura, humedad);
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
         ArrayList<sensoresDatos> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idsensoresdatos, fecha, sensor, temperatura, humedad FROM invernadero.sensoresdatos;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idsensoresdatos");
                Date fecha = resultado.getDate("fecha");
                int sen = resultado.getInt("sensor");
                String temperatura = resultado.getString("temperatura");
                String humedad = resultado.getString("humedad");
                
                sensor s =(sensor) new DAOsensor().ObtenerUno(sen+"");
               sensoresDatos p = new sensoresDatos(id, fecha, s, temperatura, humedad);
                listaP.add(p);
            }
            conexion.close();
             for(sensoresDatos p : listaP)
            {
                String idP = p.getId()+"";
                if(idP.equalsIgnoreCase(textoBusqueda))
                {
                    return p;
                }                
            }
            return null;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}
