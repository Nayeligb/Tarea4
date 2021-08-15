
package modelo;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private final String base = "regitros";
    private final String user = "root";
    private final String password = "ngb12345";
    private final String url = "jdbc:mysql://localhost:3306/" +base;
    private Connection conec= null;
    
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conec = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conec;
    }

   
}
