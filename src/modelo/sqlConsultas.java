package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class sqlConsultas extends Conexion {

    public boolean registrar(registros usr) throws SQLException  {
        PreparedStatement prst = null;
        Connection con = getConexion();
        String insert = "INSERT INTO registros(nombreUsuario, nombre ,apellido ,correo, telefono, contrasena) VALUES(?,?,?,?,?,?)";

        try {
            prst = con.prepareStatement(insert);
            prst.setString(1, usr.getNombreUsuario());
            prst.setString(2, usr.getNombre());
            prst.setString(3, usr.getApellido());
            prst.setString(4, usr.getCorreo());
            prst.setString(5, usr.getTelefono());
            prst.setString(6, usr.getPassword());
            prst.execute();

            return true;

        } catch (SQLException ex) {

            Logger.getLogger(sqlConsultas.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public boolean Log(registros rgs) throws SQLException {
        PreparedStatement prst = null;
        ResultSet res = null;
        Connection con = getConexion();

        String sql = "SELECT id, nombreUsuario, contrasena, nombre FROM registros WHERE nombreUsuario = ?";

        try {
            prst = con.prepareStatement(sql);
            prst.setString(1, rgs.getNombreUsuario());
            res = prst.executeQuery();

            if (res.next()) {

                if (rgs.getPassword().equals(res.getString(3))) {
                    rgs.setId(res.getInt(1));
                    rgs.setNombre(res.getString(4));

                    return true;
                } else {

                    return false;
                }
            }

            return false;

        } catch (SQLException ex) {

            Logger.getLogger(sqlConsultas.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

}


