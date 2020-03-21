/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetosnegocio.Barco;
import objetosnegocio.Socio;

/**
 *
 * @author laura
 */
public class BarcosBD extends ConexionBD {

    public void guardar(Barco barco) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("INSERT INTO Barcos(matricula,nombre,numamarre,cuota,idsocio) VALUES('%s','%s','%s','%f','%d')",
                    barco.getMatricula(), barco.getNombre(), barco.getNumamarre(), barco.getCuota(), barco.getIdSocio().getIdSocio());
            comando.executeUpdate(sql);
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void actualizar(Barco barco) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("UPDATE barcos SET matricula = '%s', nombre = '%s', numamarre = '%s', cuota = '%f', idsocio = '%d' WHERE idbarco = %d;",
                    barco.getMatricula(), barco.getNombre(), barco.getNumamarre(), barco.getCuota(), barco.getIdSocio().getIdSocio(), barco.getIdBarco());
            comando.executeUpdate(sql);
            conexion.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public ArrayList<Barco> consultar() {
        ArrayList<Barco> listaBarcos = new ArrayList<>();
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = "SELECT idbarco, matricula, nombre, numamarre, cuota, idsocio FROM barcos;";
            ResultSet resultado = comando.executeQuery(sql);
            while (resultado.next()) {
                int id = resultado.getInt("idbarco");
                String matricula = resultado.getString("matricula");
                String nombre = resultado.getString("nombre");
                int numamarre = resultado.getInt("numamarre");
                float cuota = resultado.getFloat("cuota");
                int idSocio = resultado.getInt("idsocio");

                Barco barco = new Barco(id, matricula, nombre, numamarre, cuota, obtenerSocio(idSocio));
                listaBarcos.add(barco);
            }
            return listaBarcos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaBarcos;
        }
    }

    public Barco consultar(int idBarco) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idbarco, matricula, nombre, numamarre, cuota, idsocio FROM barcos.barcos WHERE idbarco = %d;", idBarco);
            ResultSet resultado = comando.executeQuery(sql);
            if (resultado.next()) {
                int id = resultado.getInt("idbarco");
                String matricula = resultado.getString("matricula");
                String nombre = resultado.getString("nombre");
                int numamarre = resultado.getInt("numamarre");
                float cuota = resultado.getFloat("cuota");
                int idSocio = resultado.getInt("idsocio");
                Barco barco = new Barco(id, matricula, nombre, numamarre, cuota, obtenerSocio(idSocio));
                return barco;
            }
            return null;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public ArrayList<Barco> buscar(String texto) {
        ArrayList<Barco> listaBarcos = new ArrayList<>();
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idbarco, matricula, nombre, numamarre, cuota, "
                    + "idsocio FROM barcos WHERE nombre LIKE '%%%s%%';", texto);
            ResultSet resultado = comando.executeQuery(sql);
            while (resultado.next()) {
                int id = resultado.getInt("idbarco");
                String matricula = resultado.getString("matricula");
                String nombre = resultado.getString("nombre");
                int numamarre = resultado.getInt("numamarre");
                float cuota = resultado.getFloat("cuota");
                int idSocio = resultado.getInt("idsocio");
//                Socio socioBuscado = new Socio();
//                socioBuscado
                Barco barco = new Barco(id, matricula, nombre, numamarre, cuota, obtenerSocio(idSocio));
                listaBarcos.add(barco);
            }
            conexion.close();
            return listaBarcos;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaBarcos;
        }

    }

    public void eliminar(int idBarco) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("DELETE FROM barcos WHERE idbarco = %d;", idBarco);
            comando.executeUpdate(sql);
            comando.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Socio obtenerSocio(int idSocio) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT barcos.idbarco, barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, "
                    + "barcos.idsocio, socios.dni, socios.nombre FROM barcos INNER JOIN socios ON barcos.idsocio=socios.idsocio "
                    + "WHERE barcos.idsocio=%d", idSocio);
            ResultSet resultado = comando.executeQuery(sql);
            if (resultado.next()) {
                int id = resultado.getInt("idsocio");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                Socio socio = new Socio(id, dni, nombre);
                return socio;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
