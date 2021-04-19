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
public class alarma {
    private Integer id;
    private String tipo;
    private String cantidad;

    public alarma(Integer id, String tipo, String cantidad) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

   public alarma( String tipo, String cantidad) {
        
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "alarma{" + "id=" + id + ", tipo=" + tipo + ", cantidad=" + cantidad + '}';
    }
   
    
}
