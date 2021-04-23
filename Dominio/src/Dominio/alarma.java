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
    private float minimo;
    private float maximo;

    public alarma(Integer id, String tipo, float minimo, float maximo) {
        this.id = id;
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
    }

   public alarma( String tipo, float minimo, float maximo) {
       
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
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

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    @Override
    public String toString() {
        return "alarma{" + "id=" + id + ", tipo=" + tipo + ", minimo=" + minimo + ", maximo=" + maximo + '}';
    }

    

   
    
}
