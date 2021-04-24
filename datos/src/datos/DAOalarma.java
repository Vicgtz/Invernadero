/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.alarma;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAOalarma extends CRUD<alarma> {

    @Override
    public void guardar(alarma entidad) {
       try {
            Connection conexion = this.getConexion();
            String sql = "INSERT INTO invernadero.alarma (tipo, minimo, maximo) VALUES (?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getTipo());
            ps.setFloat(2, entidad.getMinimo());
            ps.setFloat(3, entidad.getMaximo());
            
            ps.executeUpdate();
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public void eliminar(alarma entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<alarma> obtener() {
        ArrayList<alarma> listaP = new ArrayList<>();
       try{            
            java.sql.Connection conexion = this.getConexion();
            String sql = "SELECT * FROM invernadero.alarma;";
             PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {                
                int id = rs.getInt(1);
                String tipo = rs.getString(2);
                float minimo = rs.getFloat(3);
                float maximo = rs.getFloat(4);
                
                
                
               listaP.add(new alarma(id, tipo, minimo, maximo)) ;
                
            }
            conexion.close();
            
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            
        }
       return listaP;
    }

    @Override
    public alarma ObtenerUno(String textoBusqueda) {
    alarma s = null;
         try {
            Connection conexion = this.getConexion();
            String sql = "SELECT * FROM invernadero.alarma WHERE idalarma = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(textoBusqueda));
            ResultSet rs = ps.executeQuery();

            

            rs.next();
              int id = rs.getInt(1);
                String tipo = rs.getString(2);
                float minimo = rs.getFloat(3);
                float maximo = rs.getFloat(4);
                
                
               s = new alarma(id, tipo, minimo, maximo) ;
                
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    return s;
    }
    
      
      
}
