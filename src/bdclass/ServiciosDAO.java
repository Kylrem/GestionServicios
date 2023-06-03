package bdclass;

import java.sql.*;

import javax.swing.JOptionPane;

import servicio.ServicioTarifaPlana;
import servicio.Servicios;


/**

*Esta clase se encarga de realizar operaciones en la base de datos relacionadas con los servicios.
*@author Ismael
*@version 1.0
*/
public class ServiciosDAO {
	/**

	Registra un nuevo servicio en la base de datos.

	@param servicio El servicio a registrar.
	*/
	public void registrarServicio(ServicioTarifaPlana servicio) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
	        
			PreparedStatement prestat = con.prepareStatement("insert into servicios values(?,?,?,?,?)");
			
			prestat.setInt(1, servicio.getIdServicio());
			prestat.setString(2, servicio.getNombreServicio());
			prestat.setString(3, servicio.getConcepto());
			prestat.setBoolean(4, servicio.isEsComunitario());
			prestat.setFloat(5, servicio.getPrecio());

			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	/**

	Elimina un servicio de la base de datos.

	@param servicio El servicio a eliminar.
	*/
	public void eliminarServicio(ServicioTarifaPlana servicio) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("DELETE FROM servicios WHERE IDServicio = ?");
			
			prestat.setInt(1, servicio.getIdServicio());
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	
	/**

	Busca un servicio en la base de datos por su ID y lo devuelve.

	@param id El ID del servicio a buscar.

	@return El servicio encontrado, o null si no se encuentra.
	*/
	public ServicioTarifaPlana muestraServicio(int id) {
		Servicios serv = new ServicioTarifaPlana();
		try{
			
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			
			PreparedStatement prestat = con.prepareStatement("select * from servicios where IDServicio = ?");
			
			prestat.setInt(1, id);	
			
			ResultSet res = prestat.executeQuery();
			if(res.next()) {
				serv = new ServicioTarifaPlana(res.getInt("IDServicio"),res.getString("NombreServicio"),res.getString("Concepto"),res.getBoolean("esComunitario"),res.getFloat("Precio"));
				

			}
			else {
				JOptionPane.showMessageDialog(null, "Servicio inexistente");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
		return  (ServicioTarifaPlana) serv;
		
	}
	
	
	/**

	Modifica un servicio existente en la base de datos.

	@param servicio El servicio a modificar.
	*/
	public void modificaServicio(ServicioTarifaPlana servicio) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("update servicios set NombreServicio = ?, Concepto = ?, esComunitario = ?, Precio = ? where IDServicio = ?");
			
			
			prestat.setInt(5, servicio.getIdServicio());
			prestat.setString(1, servicio.getNombreServicio());
			prestat.setString(2, servicio.getConcepto());
			prestat.setBoolean(3, servicio.isEsComunitario());
			prestat.setFloat(4, servicio.getPrecio());
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
}
