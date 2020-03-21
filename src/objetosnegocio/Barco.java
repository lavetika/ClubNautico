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
public class Barco {
    private int idBarco, numamarre;
    private Socio idSocio;
    private String matricula, nombre;
    private float cuota;

    public Barco(int idBarco, String matricula , String nombre, int numamarre, float cuota) {
        this.idBarco = idBarco;
        this.numamarre = numamarre;
//        this.idSocio = idSocio;
        this.matricula = matricula;
        this.nombre = nombre;
    }
    public Barco(int idBarco, String matricula , String nombre, int numamarre, float cuota, Socio idSocio ) {
        this.idBarco = idBarco;
        this.numamarre = numamarre;
        this.idSocio = idSocio;
        this.matricula = matricula;
        this.nombre = nombre;
        this.cuota = cuota;
    }
    public Barco(String matricula , String nombre, int numamarre, float cuota, Socio idSocio ) {
//        this.idBarco = idBarco;
        this.numamarre = numamarre;
        this.idSocio = idSocio;
        this.matricula = matricula;
        this.nombre = nombre;
        this.cuota = cuota;
    }

    public int getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(int idBarco) {
        this.idBarco = idBarco;
    }

    public int getNumamarre() {
        return numamarre;
    }

    public void setNumamarre(int numamarre) {
        this.numamarre = numamarre;
    }

    public Socio getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idBarco;
        hash = 53 * hash + this.numamarre;
//        hash = 53 * hash + this.idSocio;
        hash = 53 * hash + Objects.hashCode(this.matricula);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Float.floatToIntBits(this.cuota);
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
        final Barco other = (Barco) obj;
        if (this.idBarco != other.idBarco) {
            return false;
        }
        if (this.numamarre != other.numamarre) {
            return false;
        }
        if (this.idSocio != other.idSocio) {
            return false;
        }
        if (Float.floatToIntBits(this.cuota) != Float.floatToIntBits(other.cuota)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " (" + idSocio.getNombre() +")" ;
    }
    
    
}
