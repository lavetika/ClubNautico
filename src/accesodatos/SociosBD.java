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
import objetosnegocio.Socio;

/**
 *
 * @author laura
 */
public class SociosBD extends ConexionBD{
    public void guardar(Socio socio){
        try{
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("INSERT INTO Socios(dni,nombre) VALUES('%s','%s')", 
                     socio.getDni(), socio.getNombre());
            comando.executeUpdate(sql);
            conexion.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }                
    }
    
    public void actualizar(Socio socio){
        try{
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("UPDATE socios SET dni = '%s', nombre = '%s' WHERE idSocio = %d;", 
                    socio.getDni(), socio.getNombre(), socio.getIdSocio());
            comando.executeUpdate(sql);
            conexion.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }                
    }
    
    public ArrayList<Socio> consultar(){
        ArrayList<Socio> listaSocios = new ArrayList<>();
        try{            
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = "SELECT idsocio, dni, nombre FROM socios;";
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                int id = resultado.getInt("idsocio");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                
                Socio socio = new Socio(id, dni, nombre);
                listaSocios.add(socio);
            }
            conexion.close();
            return listaSocios;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return listaSocios;
        }
    }
        
    public Socio consultar(int idSocio){        
        try{            
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idsocio, dni, nombre FROM barcos.socios WHERE idsocio = %d;", idSocio);
            ResultSet resultado = comando.executeQuery(sql);
            if(resultado.next()){
               int id = resultado.getInt("idsocio");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                Socio socio = new Socio(id, dni, nombre);
                return socio;
            }
            conexion.close();
            return null;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Socio> buscar(String texto){
        ArrayList<Socio> listaSocios = new ArrayList<>();
        try{
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("SELECT idsocio, dni, nombre FROM socios WHERE nombre LIKE '%%%s%%';", texto);
            ResultSet resultado = comando.executeQuery(sql);
            while(resultado.next()){
                int id = resultado.getInt("idsocio");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                
                Socio socio = new Socio(id, dni, nombre);
                listaSocios.add(socio);
            }
            conexion.close();
            return listaSocios;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return listaSocios;
        }
         
    }
    public void eliminar(int idSocio){
        try{
            Connection conexion = this.crearConexion();
            Statement comando = conexion.createStatement();
            String sql = String.format("DELETE FROM socios WHERE idSocio = %d;", idSocio);
            comando.executeUpdate(sql);
            comando.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}