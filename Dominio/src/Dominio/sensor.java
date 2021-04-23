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
public class sensor {
    private Integer id;
    private String clave;
    private String marca;
    private String invernadero;
    private String numero;
    private String correo;
   

    public sensor(Integer id, String clave, String marca, String invernadero, String numero, String correo) {
        this.id = id;
        this.clave = clave;
        this.marca = marca;
        this.invernadero = invernadero;
        this.numero = numero;
        this.correo = correo;
    }
    /**
     *
     * @param clave
     * @param marca
     * @param invernadero
     * @param numero
     * @param correo
     */
    public sensor( String clave, String marca, String invernadero, String numero, String correo){
        
        this.clave = clave;
        this.marca = marca;
        this.invernadero = invernadero;
        this.numero = numero;
        this.correo = correo;
        
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getInvernadero() {
        return invernadero;
    }

    public void setInvernadero(String invernadero) {
        this.invernadero = invernadero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    

    

    @Override
    public String toString() {
        return "sensor{" + "id=" + id + ", clave=" + clave + ", marca=" + marca + ", invernadero=" + invernadero + ", numero=" + numero + ", correo=" + correo +  '}';
    }

    
    
    

    
    
    
    

   
    
}
