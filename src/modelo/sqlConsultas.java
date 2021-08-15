package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class sqlConsultas extends Conexion {
    
    public boolean registrar(registros usr) throws SQLException
    {        
       PreparedStatement prst = null; 
        Connection con = getConexion();
        String insert = "INSERT INTO usuario(nombreUsuario, nombre ,apellido ,correo, telefono, contrasena) VALUES(?,?,?,?,?,?)";

        try{
           prst = con.prepareStatement(insert);
           prst.setString(1,usr.getNombreUsuario());
           prst.setString(2,usr.getNombre());
           prst.setString(3,usr.getApellido());
           prst.setString(4,usr.getCorreo());
           prst.setString(5,usr.getTelefono());
           prst.setString(6,usr.getPassword());
           prst.execute();
           
           return true;
           
        } catch (SQLException ex){
            
          Logger.getLogger(sqlConsultas.class.getName()).log(Level.SEVERE,null,ex);
          
          return false;
        }            
    }
    
  
}
