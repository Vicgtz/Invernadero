/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author DELL
 */
public class sensor {
    private Integer id;
    private String clave;
    private String marca;
    private invernadero invernadero;

    public sensor(Integer id, String clave, String marca, invernadero invernadero) {
        this.id = id;
        this.clave = clave;
        this.marca = marca;
        this.invernadero = invernadero;
    }

     public sensor( String clave, String marca, invernadero invernadero) {
       
        this.clave = clave;
        this.marca = marca;
        this.invernadero = invernadero;
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

    public invernadero getInvernadero() {
        return invernadero;
    }

    public void setInvernadero(invernadero invernadero) {
        this.invernadero = invernadero;
    }

    @Override
    public String toString() {
        return "sensor{" + "id=" + id + ", clave=" + clave + ", marca=" + marca + ", invernadero=" + invernadero + '}';
    }
    
    
}
