/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.usuario;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class DAOusuario  extends CRUD<usuario> {

    @Override
    public void guardar(usuario entidad) {
        try{
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();           
            String sql = String.format("INSERT INTO `invernadero`.`usuario` (`nombre`, `puesto`, `correo`, `telefono`) VALUES ('%s', '%s', '%s', '%s');", 
                    entidad.getNombre(), entidad.getPuesto(), entidad.getCorreo(), entidad.getTelefono());
            comando.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        } 
    }

    @Override
    public void eliminar(usuario entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<usuario> obtener() {
       ArrayList<usuario> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idusuario, nombre, puesto, correo, telefono FROM invernadero.usuario;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idusuario");
                String nombre = resultado.getString("nombre");
                String puesto = resultado.getString("puesto");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                
                
               usuario p = new usuario(id, nombre, puesto, correo, telefono);
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
    public usuario ObtenerUno(String textoBusqueda) {
       ArrayList<usuario> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idusuario, nombre, puesto, correo, telefono FROM invernadero.usuario;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idusuario");
                String nombre = resultado.getString("nombre");
                String puesto = resultado.getString("puesto");
                String correo = resultado.getString("correo");
                String telefono = resultado.getString("telefono");
                
                
               usuario p = new usuario(id, nombre, puesto, correo, telefono);
                listaP.add(p);
            }
            conexion.close();
             for(usuario p : listaP)
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
