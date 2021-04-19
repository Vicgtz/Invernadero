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
public class invernadero {
   private Integer id;
    private String nombre;
    private String ubicacion;
    private usuario encargado;
    private String correo;
    private String telefono;

    public invernadero(Integer id, String nombre, String ubicacion, usuario encargado, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.encargado = encargado;
        this.correo = correo;
        this.telefono = telefono;
    }

    public invernadero(String nombre, String ubicacion, usuario encargado, String correo, String telefono) {
       
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.encargado = encargado;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(usuario encargado) {
        this.encargado = encargado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "invernadero{" + "id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", encargado=" + encargado + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    
    
}
