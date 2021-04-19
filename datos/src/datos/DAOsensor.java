/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.invernadero;
import Dominio.sensor;
import Dominio.usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAOsensor extends CRUD<sensor> {

    @Override
    public void guardar(sensor entidad) {
        try{
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();           
            String sql = String.format("INSERT INTO `invernadero`.`sensor` (`clave`, `marca`, `invernadero`) VALUES ('%s', '%s', '%s');", 
                    entidad.getClave(), entidad.getMarca(), entidad.getInvernadero());
            comando.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
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
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idsensor, clave, marca, invernadero FROM invernadero.sensor;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idinvernadero");
                String clave = resultado.getString("nombre");
                String marca = resultado.getString("puesto");
                int invernadero = resultado.getInt("encargado");
                
                
                invernadero i =(invernadero) new DAOinvernadero().ObtenerUno(invernadero+"");
               sensor p = new sensor(id, clave, marca, i);
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
    public sensor ObtenerUno(String textoBusqueda) {
      ArrayList<sensor> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idsensor, clave, marca, invernadero FROM invernadero.sensor;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idinvernadero");
                String clave = resultado.getString("nombre");
                String marca = resultado.getString("puesto");
                int invernadero = resultado.getInt("encargado");
                
                
                invernadero i =(invernadero) new DAOinvernadero().ObtenerUno(invernadero+"");
               sensor p = new sensor(id, clave, marca, i);
                listaP.add(p);
            }
            conexion.close();
            
            for(sensor p : listaP)
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
