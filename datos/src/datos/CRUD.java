/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public abstract class CRUD<T> {
    private static String CADENA_CONEXION = "jdbc:mysql://localhost/invernadero?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USUARIO = "root";
    private static String CONTRASENIA = "12345678"; //Alter: 64224Cas

    protected Connection getConexion() throws SQLException {
        try {
            Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
            return conexion;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    public abstract void guardar(T entidad);

    public abstract void eliminar(T entidad);

    public abstract ArrayList<T> obtener();

    public abstract T ObtenerUno(String textoBusqueda);
}


