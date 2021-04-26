/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Conexion.ConexionBD;
import Interfaces.IConexion;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import Dominio.sensor;
import org.json.JSONObject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author anacastillo
 */
@Path("wsSensores")
public class wsSensores {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public wsSensores() {
    }

    /**
     * Retrieves representation of an instance of WebServices.wsSensores
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/sensores")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonSensor() {
        IConexion c = new ConexionBD();
        if (c.conectar()) {
            ArrayList<sensor> sensor = c.consultarSensores();
            if (sensor != null) {
                JSONObject j;
                String datos = "{sensor:[";
                for (sensor sen : sensor) {
                    int idSensor = sen.getId();
                    String clave = sen.getClave();
                    String invernadero = sen.getInvernadero();
                    String correo = sen.getCorreo();
                    String num = sen.getNumero();
                    datos = datos + "{idSensor:" + idSensor + ","
                            + "idSensor:" + idSensor + ","
                            + "clave:" + clave + "},"
                            + "invernadero:" + invernadero + ","
                            + "num:" + num + ","
                            + "correo:" + correo + ","
                            + "}";

                    if (sensor.indexOf(sen) < sensor.size() - 1) {
                        datos += ",";
                    }
                }
                datos += "]}";
                j = new JSONObject(datos);
                return j.toString(1);
            } else {
                return "ERROR_BD";
            }
        } else {
            return "ERROR_BD";
        }
    }

    /**
     * PUT method for updating or creating an instance of wsSensores
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
}
