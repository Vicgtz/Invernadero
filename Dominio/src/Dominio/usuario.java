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
public class usuario {
    private Integer id;
    private String nombre;
    private String puesto;
    private String correo;
    private String telefono;

    public usuario(Integer id, String nombre, String puesto, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.correo = correo;
        this.telefono = telefono;
    }

    public usuario( String nombre, String puesto, String correo, String telefono) {
       
        this.nombre = nombre;
        this.puesto = puesto;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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
        return "usuario{" + "id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
    
    
    
}
