/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.invernadero;
import Dominio.usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAOinvernadero extends CRUD<invernadero> {

    @Override
    public void guardar(invernadero entidad) {
        try{
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();           
            String sql = String.format("INSERT INTO `invernadero`.`invernadero` (`nombre`, `ubicacion`, `encargado`, `telefono`, `correo`) VALUES ('%s', '%s', '%s', '%s', '%s');", 
                    entidad.getNombre(), entidad.getUbicacion(), entidad.getEncargado(), entidad.getTelefono(),entidad.getCorreo());
            comando.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        } 
    }

    @Override
    public void eliminar(invernadero entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<invernadero> obtener() {
        ArrayList<invernadero> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idinvernadero, nombre, ubicacion, encargado, telefono, correo FROM invernadero.invernadero;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idinvernadero");
                String nombre = resultado.getString("nombre");
                String ubicacion = resultado.getString("puesto");
                int encargado = resultado.getInt("encargado");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                
                usuario u =(usuario) new DAOusuario().ObtenerUno(encargado+"");
               invernadero p = new invernadero(id, nombre, ubicacion, u, telefono, correo);
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
    public invernadero ObtenerUno(String textoBusqueda) {
       ArrayList<invernadero> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idinvernadero, nombre, ubicacion, encargado, telefono, correo FROM invernadero.invernadero;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idinvernadero");
                String nombre = resultado.getString("nombre");
                String ubicacion = resultado.getString("puesto");
                int encargado = resultado.getInt("encargado");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                
                usuario u =(usuario) new DAOusuario().ObtenerUno(encargado+"");
               invernadero p = new invernadero(id, nombre, ubicacion, u, telefono, correo);
                listaP.add(p);
            }
            conexion.close();
            
            for(invernadero p : listaP)
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
