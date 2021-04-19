/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class sendorDatos {
   private Integer id;
    private Date fecha;
    private sensor sensor;
    private String temperatura;
    private String humedad;
    private String telefono;

    public sendorDatos(Integer id, Date fecha, sensor sensor, String temperatura, String humedad, String telefono) {
        this.id = id;
        this.fecha = fecha;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.telefono = telefono;
    }

    public sendorDatos( Date fecha, sensor sensor, String temperatura, String humedad, String telefono) {
        
        this.fecha = fecha;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.telefono = telefono;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public sensor getSensor() {
        return sensor;
    }

    public void setSensor(sensor sensor) {
        this.sensor = sensor;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "sendorDatos{" + "id=" + id + ", fecha=" + fecha + ", sensor=" + sensor + ", temperatura=" + temperatura + ", humedad=" + humedad + ", telefono=" + telefono + '}';
    }
     
    
    
}
