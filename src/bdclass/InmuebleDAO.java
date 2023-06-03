package bdclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import usuario.User;

/**

*Clase que se encarga de realizar operaciones en la tabla "inmueble" de la base de datos, como mostrar las propiedadesde un usuario.
*@author Ismael
*@version 1.0
*/
public class InmuebleDAO {
	/**

	Método que muestra las propiedades de un usuario en función de su DNI y contraseña.

	@param user objeto de la clase User que contiene la información del usuario.

	@return devuelve un String con la información de las propiedades del usuario o un String vacío si el usuario no tiene propiedades o	se produce algún error al realizar la consulta.
	*/
	 public String mostrarPropiedades(User user) {
	        try {
	            PreparedStatement prestat = ConexionBD.getConnection().prepareStatement(
	                    "SELECT * FROM `inmueble` WHERE IDPropietario = (select ID from user where DNI = ? and Password = ?)");
	            prestat.setString(1, user.getDni());
	            prestat.setString(2, user.getPass());

	            ResultSet res = prestat.executeQuery();
	            if (res.next()) {
	                if (res.getString("Portal") == null) {
	                    return "Usuario " + user.getNombre() + " " + user.getApellido1() + " " + user.getApellido2()
	                            + ". Propietario de Calle " + res.getString("Calle") + ", " + res.getString("Numero");
	                } else {
	                    return "Usuario " + user.getNombre() + " " + user.getApellido1() + " " + user.getApellido2()
	                            + ". Propietario de Calle " + res.getString("Calle") + ", " + res.getString("Numero") + " Portal "
	                            + res.getString("Portal") + ", " + res.getString("Piso") + res.getString("Puerta");
	                }

	            } else {
	                JOptionPane.showMessageDialog(null, "Usuario sin Propiedades");
	                return "";
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al conectar");
	            return "";
	        }
	    }
	}


