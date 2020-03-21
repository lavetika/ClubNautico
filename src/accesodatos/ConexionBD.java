package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String CADENA_CONEXION = "jdbc:mysql://LocalHost/barcos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "12345678";
    
    public ConexionBD() {}
    
    protected Connection crearConexion() throws SQLException{
        Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASENIA);
        return conexion;
    }
    
}
