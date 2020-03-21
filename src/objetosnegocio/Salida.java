/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosnegocio;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author laura
 */
public class Salida {
    private int idSalida;
    private Barco barco;
    private Date fechaHora;
    private String destino;

    public Salida(){};
    public Salida(int idSalida, Barco idBarco, Date fechaHora, String destino) {
        this.idSalida = idSalida;
        this.barco = idBarco;
        this.fechaHora = fechaHora;
        this.destino = destino;
    }
    
    public Salida(Barco idBarco, Date fechaHora, String destino) {
        this.barco = idBarco;
        this.fechaHora = fechaHora;
        this.destino = destino;
    }
    public Salida(String destino, Barco idBarco) {
        this.barco = idBarco;
        this.destino = destino;
    }
     public Salida(int idSalida, Barco idBarco, String destino) {
        this.barco = idBarco;
        this.destino = destino;
        this.idSalida = idSalida;
    }
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public Barco getIdBarco() {
        return barco;
    }

    public void setIdBarco(Barco idBarco) {
        this.barco = idBarco;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fecha) {
        this.fechaHora=fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idSalida;
        hash = 29 * hash + Objects.hashCode(this.fechaHora);
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
        final Salida other = (Salida) obj;
        if (this.idSalida != other.idSalida) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idSalida=" + idSalida + ", idBarco=" + barco.getIdBarco() + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
