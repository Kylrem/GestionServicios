package bdclass;

import java.sql.*;

import javax.swing.JOptionPane;

import usuario.Admin;
import usuario.User;
import usuario.Vecino;

/**
*Esta clase se encarga de gestionar la conexión y operaciones con la base de datos de los usuarios.
*@author Ismael
*@version 1.0
*/
public class UsuariosDAO {

	private User loger;
	
	private boolean isAdministrador;
	
	/**

	Método que permite a un usuario iniciar sesión en el sistema.
	@param dni DNI del usuario que intenta iniciar sesión.
	@param pass Contraseña del usuario que intenta iniciar sesión.
	@return true si el usuario inicia sesión correctamente, false en caso contrario.
	*/
	public boolean entrarPrograma(String dni, String pass) {
	    try {
	        ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
	    
	        PreparedStatement prestat = con.prepareStatement("SELECT * FROM user WHERE DNI=? AND Password=?");
	    
	        prestat.setString(1, dni);
	        prestat.setString(2, pass);        
	        ResultSet res = prestat.executeQuery();
	        
	        if (res.next()) {
	            isAdministrador = res.getBoolean("isAdmin");
	            
	            if (isAdministrador) {
	                JOptionPane.showMessageDialog(null, "Bienvenido Administrador " + res.getString("Nombre") + " " + res.getString("PrimerApellido") + " " + res.getString("SegundoApellido"));
	                loger = new Admin(res.getInt("ID"), res.getString("Nombre"), res.getString("PrimerApellido"), res.getString("SegundoApellido"), res.getString("DNI"), res.getString("Password"), res.getInt("Telefono"), res.getString("email"));
	                return true;
	            } else {
	                JOptionPane.showMessageDialog(null, "Bienvenido Vecino " + res.getString("Nombre") + " " + res.getString("PrimerApellido") + " " + res.getString("SegundoApellido"));
	                loger = new Vecino(res.getInt("ID"), res.getString("Nombre"), res.getString("PrimerApellido"), res.getString("SegundoApellido"), res.getString("DNI"), res.getString("Password"), res.getInt("Telefono"), res.getString("email"));
	                return true;
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Usuario o contraseña equivocados");
	            return false;
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al conectar");
	        return false;
	    }
	}
	
	/**
	Método que permite registrar un nuevo usuario en la base de datos.
	@param usuario Usuario que se desea registrar.
	@param isAdmin true si el usuario es un administrador, false si es un vecino.
	*/
	public void registrarUsuario(User usuario, boolean isAdmin) {
	    try {
	        ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();

	        PreparedStatement prestat = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?)");

	        prestat.setInt(1, usuario.getId());
	        prestat.setString(2, usuario.getNombre());
	        prestat.setString(3, usuario.getApellido1());
	        prestat.setString(4, usuario.getApellido2());
	        prestat.setString(5, usuario.getDni());
	        prestat.setString(6, usuario.getPass());
	        prestat.setInt(7, usuario.getTel());
	        prestat.setString(8, usuario.getEmail());
	        prestat.setBoolean(9, isAdmin);

	        prestat.executeUpdate();

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al conectar");
	    }
	}	
	
	/**
	Método que permite eliminar un usuario de la base de datos.
	@param usuario Usuario que se desea eliminar.
	*/
	public void eliminarUsuario(User usuario) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("DELETE FROM user WHERE ID = ?");
			
			prestat.setInt(1, usuario.getId());
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	
	/**

	Devuelve un objeto User que representa el usuario con el ID especificado.
	@param id el ID del usuario a mostrar
	@return el objeto User que representa el usuario encontrado, o un objeto Vecino vacío si el usuario no existe
	*/
	public User muestraUsuario(int id) {
		User usuario = new Vecino();
		try{
			
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			
			PreparedStatement prestat = con.prepareStatement("select * from user where ID = ?");
			
			prestat.setInt(1, id);	
			
			ResultSet res = prestat.executeQuery();
			if(res.next()) {
				usuario = new Vecino(res.getInt("ID"),res.getString("Nombre"),res.getString("PrimerApellido"),res.getString("SegundoApellido"),res.getString("DNI"),res.getString("Password"),res.getInt("Telefono"),res.getString("email"));
				

			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario inexistente");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
		return usuario;
		
	}
	
	
	/**

	Modifica los datos de un usuario en la base de datos.
	@param usuario el objeto User con los nuevos datos del usuario
	*/
	public void modificaUsuario(User usuario) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("update user set Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, DNI = ?, Password = ?, Telefono = ?, email = ? where ID = ?");
			
			
			prestat.setString(1, usuario.getNombre());
			prestat.setString(2, usuario.getApellido1());
			prestat.setString(3, usuario.getApellido2());
			prestat.setString(4, usuario.getDni());
			prestat.setString(5, usuario.getPass());
			prestat.setInt(6, usuario.getTel());
			prestat.setString(7, usuario.getEmail());
			prestat.setInt(8, usuario.getId());
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}

	
	
	/**

	Devuelve el objeto User que representa el usuario que ha iniciado sesión en la aplicación.
	@return el objeto User que representa el usuario que ha iniciado sesión
	*/
	public User getLoger() {
        return loger;
    }
}
