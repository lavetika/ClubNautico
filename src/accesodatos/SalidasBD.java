/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import objetosnegocio.Barco;
import objetosnegocio.Salida;

/**
 *
 * @author laura
 */
public class SalidasBD extends ConexionBD{
    
     public void guardar(Salida salida){
        try{
            Connection conexion = this.crearConexion();
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            Statement comando = conexion.createStatement();
            String sql = String.format("INSERT INTO Salidas(fechahora,destino,idbarco) VALUES('%s','%s','%d')", 
                     formater.format(salida.getFechaHora()), salida.getDestino(), salida.getIdBarco().getIdBarco());
            comando.executeUpdate(sql);
            conexion.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }                
    }
    
    public void actualizar(Salida salida){
        try{
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("UPDATE salidas SET fechahora = '%s', destino = '%s', idbarco = '%d' WHERE idsalida = %d;", 
            formater.format(salida.getFechaHora()), salida.getDestino(), salida.getIdBarco().getIdBarco(), salida.getIdSalida());
            comando.executeUpdate(sql);
            conexion.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }                
    }
    
    public ArrayList<Salida> consultar(){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<Salida> listaSalida = new ArrayList<>();
        try{            
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = "SELECT idsalida, fechahora, destino, idbarco FROM salidas;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                int id = resultado.getInt("idsalida");
                Date fechahora = resultado.getDate("fechahora");
                String destino = resultado.getString("destino");
                int idbarco = resultado.getInt("idbarco");
                
                Salida salida = new Salida(id, obtenerBarco(idbarco), fechahora, destino);
                listaSalida.add(salida);
            }
            return listaSalida;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return listaSalida;
        }
    }
        
    public Salida consultar(int idSalida){        
        try{            
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idsalida, fechahora, destino, idbarco FROM barcos.salidas WHERE idsalida = %d;", idSalida);
            ResultSet resultado = comando.executeQuery(sql);
            if(resultado.next()){
                int id = resultado.getInt("idsalida");
                Date fechahora = resultado.getDate("fechahora");
                String destino = resultado.getString("destino");
                int idbarco = resultado.getInt("idbarco");
                Salida salida = new Salida(id, obtenerBarco(idbarco), fechahora, destino);
                return salida;
            }
            return null;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    public ArrayList<Salida> buscar(String texto) {
        ArrayList<Salida> listaSalidas = new ArrayList<>();
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idsalida, fechahora, destino, idbarco FROM salidas WHERE destino LIKE '%%%s%%';", texto);
            ResultSet resultado = comando.executeQuery(sql);
            while (resultado.next()) {
                int id = resultado.getInt("idsalida");
                Date fechahora = resultado.getDate("fechahora");
                String destino = resultado.getString("destino");
                int idbarco = resultado.getInt("idbarco");
                Salida salida = new Salida(id, obtenerBarco(idbarco), fechahora, destino);
                listaSalidas.add(salida);
            }
            conexion.close();
            return listaSalidas;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return listaSalidas;
        }

    }

    public void eliminar(int idsalida) {
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("DELETE FROM Salidas WHERE idsalida = %d;", idsalida);
            comando.executeUpdate(sql);
            comando.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Barco obtenerBarco(int idBarco) {
        BarcosBD barcosBD = new BarcosBD();
        try {
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT salidas.idsalida, salidas.fechahora, salidas.destino, salidas.idbarco, barcos.matricula, barcos.nombre, barcos.numamarre, barcos.cuota, barcos.idsocio \n"
                    + "FROM salidas\n"
                    + "INNER JOIN barcos ON salidas.idbarco=barcos.idbarco\n"
                    + "WHERE salidas.idbarco=%d", idBarco);
            ResultSet resultado = comando.executeQuery(sql);
            if (resultado.next()) {
                int id = resultado.getInt("idbarco");
                String matricula = resultado.getString("matricula");
                String nombre = resultado.getString("nombre");
                int numamarre = resultado.getInt("numamarre");
                float cuota = resultado.getFloat("cuota");
                int idSocio = resultado.getInt("idsocio");
                Barco barco = new Barco(id, matricula, nombre, numamarre, cuota, barcosBD.obtenerSocio(idSocio));
                return barco;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

}
