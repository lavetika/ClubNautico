/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;

import java.util.Objects;

/**
 *
 * @author laura
 */
public class Socio {
    private int idSocio;
    private String dni, nombre;
    
    public Socio (){
        
    }
    public Socio(int idSocio, String dni, String nombre) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
    }
    
    public Socio(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idSocio;
        hash = 53 * hash + Objects.hashCode(this.dni);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if (this.idSocio != other.idSocio) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, NOMBRE: %s", idSocio, nombre);
    }
    
    
}
