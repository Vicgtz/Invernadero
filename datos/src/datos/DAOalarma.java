/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Dominio.alarma;
import Dominio.usuario;
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
      try{
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();           
            String sql = String.format("INSERT INTO `invernadero`.`alarma` (`tipo`, `cantidad`) VALUES ('%s', '%s');", 
                    entidad.getTipo(), entidad.getCantidad());
            comando.executeUpdate(sql);
            conexion.close();
        }
        catch(Exception ex){
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
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idalarma, tipo, cantidad FROM invernadero.alarma;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idalarma");
                String tipo = resultado.getString("tipo");
                String cantidad = resultado.getString("cantidad");
              
                
               alarma p = new alarma(id, tipo, cantidad);
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
    public alarma ObtenerUno(String textoBusqueda) {
    ArrayList<alarma> listaP = new ArrayList<>();
        try{            
            java.sql.Connection conexion = this.getConexion();
            java.sql.Statement comando = conexion.createStatement();
            String sql = "SELECT idalarma, tipo, cantidad FROM invernadero.alarma;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next())
            {                
                int id = resultado.getInt("idalarma");
                String tipo = resultado.getString("tipo");
                String cantidad = resultado.getString("cantidad");
              
                
               alarma p = new alarma(id, tipo, cantidad);
                listaP.add(p);
            }
            conexion.close();
            for(alarma p : listaP)
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
