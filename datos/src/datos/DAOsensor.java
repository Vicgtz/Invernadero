/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import Dominio.sensor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class DAOsensor extends CRUD<sensor> {

    @Override
    public void guardar(sensor entidad) {
        try {
            Connection conexion = this.getConexion();
            String sql = "INSERT INTO invernadero.sensor (clave, marca, invernadero, numero, correo) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getClave());
            ps.setString(2, entidad.getMarca());
           
           
            ps.setString(3, entidad.getInvernadero());
            ps.setString(4, entidad.getNumero());
            ps.setString(5, entidad.getCorreo());
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } 
    }

    @Override
    public void eliminar(sensor entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<sensor> obtener() {
       ArrayList<sensor> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            String sql = "SELECT * FROM invernadero.sensor;";
             PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {                
                int id = rs.getInt(1);
                String clave = rs.getString(2);
                String marca = rs.getString(3);
                String invernadero = rs.getString(4);
                String numero = rs.getString(5);
                String correo = rs.getString(6);
                
                
               listaP.add(new sensor(id, clave, marca, invernadero, numero, correo)) ;
                
            }
            conexion.close();
            
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            
        }
        
        return listaP;
    }

    @Override
    public sensor ObtenerUno(String textoBusqueda) {
     sensor s = null;
         try {
            Connection conexion = this.getConexion();
            String sql = "SELECT * FROM invernadero.sensor WHERE idsensor = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(textoBusqueda));
            ResultSet rs = ps.executeQuery();

            

            rs.next();
              int id = rs.getInt(1);
                String clave = rs.getString(2);
                String marca = rs.getString(3);
                String invernadero = rs.getString(4);
                String numero = rs.getString(5);
                String correo = rs.getString(6);
                
                
               s = new sensor(id, clave, marca, invernadero, numero, correo) ;
                
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    return s;
    }
}
