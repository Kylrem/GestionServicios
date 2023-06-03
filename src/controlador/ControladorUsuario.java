package controlador;

import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import bdclass.*;
import usuario.User;
import vista.*;


/**

*ControladorUsuario es la clase encargada de manejar las operaciones y la lógica de negocio relacionadas con los usuarios.
*Desde la creación de nuevos usuarios hasta el inicio de sesión y la visualización de las propiedades de un usuario.
*También se encarga de realizar altas, bajas y modificaciones de usuarios en la base de datos.
*@author Ismael
*@version 1.0
*/
public class ControladorUsuario {

	private static User us;
	
	/**

	*Método que se encarga de iniciar sesión en el programa a través de un DNI y una contraseña.
	*Si el DNI o la contraseña están vacíos, muestra un mensaje de error. Si los datos son correctos, crea una nueva ventana de consola y la muestra.
	*@param dni El DNI del usuario.
	*@param pass La contraseña del usuario.
	*/
	public static void iniciarSesion(String dni, String pass) {
	    if(dni.isEmpty() || pass.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Algun campo esta vacio.");
	    } else {
	        UsuariosDAO bd = new UsuariosDAO();
	        if(bd.entrarPrograma(dni, pass)) {
	        	us=bd.getLoger();
	            Consola conso = new Consola(new ControladorUsuario());
	            conso.setVisible(true);
	        }
	    }
	}
	
	/**

	*Método que muestra las propiedades de un usuario.
	*@param user El usuario cuyas propiedades se quieren mostrar.
	*@return Las propiedades del usuario.
	*/
	public String mostrarPropiedadesUsuario(User user) {
	    InmuebleDAO inmuebleDAO = new InmuebleDAO();
	    String propiedades = inmuebleDAO.mostrarPropiedades(user);
	    return propiedades;
	}

	/**

	*Método que registra un nuevo usuario en la base de datos.
	*@param usuario El usuario que se quiere registrar.
	*@param isAdmin Un valor booleano que indica si el usuario que se quiere registrar es administrador o no.
	*/
	public static void alta(User usuario, boolean isAdmin) {
		UsuariosDAO bd = new UsuariosDAO();
		if(isAdmin == true) {
			
			bd.registrarUsuario(usuario,isAdmin);
		}else {
			bd.registrarUsuario(usuario,isAdmin);
		}

	}	
	

	/**

	*Método que elimina un usuario de la base de datos.
	*@param usuario El usuario que se quiere eliminar.
	*/
	public static void baja(User usuario) {
		UsuariosDAO bd = new UsuariosDAO();
		
		bd.eliminarUsuario(usuario);
	}

	/**

	*Método que modifica un usuario en la base de datos.
	*@param usuario El usuario que se quiere modificar.
	*/
	public static void modificar(User usuario) {
		UsuariosDAO bd = new UsuariosDAO();
		
		bd.modificaUsuario(usuario);
		
		
	}
	
	/**

	*Método que devuelve el usuario que ha iniciado sesión.
	*@return El usuario que ha iniciado sesión.
	*/
	public User getLoger() {
		return us;
	}
}

