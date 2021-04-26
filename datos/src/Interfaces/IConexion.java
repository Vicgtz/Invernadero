/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import Dominio.sensor;

/**
 *
 * @author Equipo 04
 */
public interface IConexion {
    public boolean conectar();
    public boolean desconectar();
    public boolean hayConexion();
    public boolean insertarSensor(sensor entidad);
    public ArrayList<sensor> consultarSensores();
            
}

