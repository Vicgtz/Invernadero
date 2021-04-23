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
public class sensoresDatos {
   private Integer id;
    private Date fecha;
    private sensor sensor;
    private float temperatura;
    private float humedad;
   

    public sensoresDatos(Integer id, Date fecha, sensor sensor, float temperatura, float humedad) {
        this.id = id;
        this.fecha = fecha;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.humedad = humedad;
       
    }

    public sensoresDatos( Date fecha, sensor sensor, float temperatura, float humedad) {
        
        this.fecha = fecha;
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.humedad = humedad;
        
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

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

  

    @Override
    public String toString() {
        return "sendorDatos{" + "id=" + id + ", fecha=" + fecha + ", sensor=" + sensor + ", temperatura=" + temperatura + ", humedad=" + humedad + ", telefono="  + '}';
    }
     
    
    
}
