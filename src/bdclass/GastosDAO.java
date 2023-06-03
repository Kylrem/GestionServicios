package bdclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import gasto.Gasto;
import gasto.Proveedor;
import servicio.Servicios;
import usuario.User;


/**
*La clase GastosDAO es responsable de manejar las operaciones de acceso a la base de datos relacionadas con los gastos.
*@author Ismael
*@version 1.0
*/
public class GastosDAO {
	
	/**
	 * Registra los gastos correspondientes a un proveedor y a un servicio en la base de datos.
	 * 
	 * @param gastos El objeto Gasto que contiene la información de los gastos a registrar.
	 * @param proveedores El objeto Proveedor que contiene la información del proveedor correspondiente.
	 * @param servicio El objeto Servicios que contiene la información del servicio correspondiente.
	 */
	public void registrarGastos(Gasto gastos, Proveedor proveedores, Servicios servicio) {
		int idProveedor = -100;
		int i = 0, y = 0;
		int[] idFactura = null;

		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement pres = con.prepareStatement("select * from gasto where IDGasto = ?");

			pres.setInt(1, gastos.getIdGasto());
			
			ResultSet r = pres.executeQuery();
			
			if(!r.next()) {
			
			PreparedStatement prestat = con.prepareStatement("insert into gasto values(?,?)");
			
			prestat.setInt(1, gastos.getIdGasto());
			prestat.setString(2, gastos.getFechaPago());
			
			prestat.executeUpdate();
			
			PreparedStatement prestat2 = con.prepareStatement("select * from proveedor where Nombre = ? and Telefono = ?");

			prestat2.setString(1, proveedores.getNombre());
			prestat2.setInt(2, proveedores.getTel());
			
			ResultSet res = prestat2.executeQuery();
			if(res.next()) {
				idProveedor = res.getInt("IDProveedor");}
			else {JOptionPane.showMessageDialog(null, "Proveedor inexistente");}
			
			
			PreparedStatement prestat3 = con.prepareStatement("select * from factura where IDProveedor = ?");
			
			prestat3.setInt(1, idProveedor);
			
			ResultSet res2 = prestat3.executeQuery();
			while(res2.next()) {
				i++;}
			idFactura = new int[i];
			res2.beforeFirst();
			
			while(res2.next()) {
				idFactura[y] = res2.getInt("IDFactura");
				y++;
				}

			PreparedStatement prestat4;
			
			for(int j=0;j<i;j++) {
				prestat4 = con.prepareStatement("insert into gastos_factura values(?,?)");
				
				prestat4.setInt(1, gastos.getIdGasto());
				prestat4.setInt(2, idFactura[j]);
				
				prestat4.executeUpdate();
			}
			}else {
				PreparedStatement prestat2 = con.prepareStatement("select * from proveedor where Nombre = ? and Telefono = ?");

				prestat2.setString(1, proveedores.getNombre());
				prestat2.setInt(2, proveedores.getTel());
				
				ResultSet res = prestat2.executeQuery();
				if(res.next()) {
					idProveedor = res.getInt("IDProveedor");}
				else {JOptionPane.showMessageDialog(null, "Proveedor inexistente");}
				
				
				PreparedStatement prestat3 = con.prepareStatement("select * from factura where IDProveedor = ?");
				
				prestat3.setInt(1, idProveedor);
				
				ResultSet res2 = prestat3.executeQuery();
				while(res2.next()) {
					i++;}
				idFactura = new int[i];
				res2.beforeFirst();
				
				while(res2.next()) {
					idFactura[y] = res2.getInt("IDFactura");
					y++;
					}

				PreparedStatement prestat4;
				
				for(int j=0;j<i;j++) {
					prestat4 = con.prepareStatement("insert into gastos_factura values(?,?)");
					
					prestat4.setInt(1, gastos.getIdGasto());
					prestat4.setInt(2, idFactura[j]);
					
					prestat4.executeUpdate();
				}
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
			e.printStackTrace();
		}
	
	}
	/**
	 * Elimina los gastos correspondientes a un objeto Gasto de la base de datos.
	 * 
	 * @param gastos El objeto Gasto que contiene la información de los gastos a eliminar.
	 */
	public void eliminarGastos(Gasto gastos) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat2 = con.prepareStatement("DELETE FROM gastos_factura WHERE IDGasto = ?");
			
			prestat2.setInt(1, gastos.getIdGasto());
			
			prestat2.executeUpdate();
			
			PreparedStatement prestat = con.prepareStatement("DELETE FROM gasto WHERE IDGasto = ?");
			
			prestat.setInt(1, gastos.getIdGasto());
			
			prestat.executeUpdate();
			

			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Obtiene los gastos correspondientes a un usuario de la base de datos.
	 * 
	 * @param usuario El objeto User que contiene la información del usuario correspondiente.
	 * 
	 * @return Una matriz de cadenas que contiene la información de los gastos correspondientes al usuario.
	 */
	public String[] muestraGastos(User usuario) {
		String[] gastosUsuario = null;
		int i = 0, y = 0;
		try{
			
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			
			PreparedStatement prestat = con.prepareStatement("select DISTINCT se.NombreServicio, se.Concepto, f.Importe from servicios se, serviciosuscripcion sus, inmueble inm, factura f, gastos_factura gf where inm.IDPropietario = ? AND sus.IDInmueble = inm.IDInmueble and se.IDServicio = sus.IDServicio AND sus.IDServicio = f.IDServicio and f.IDFactura = gf.IDFactura and sus.EnActivo = 1;");
			
			prestat.setInt(1, usuario.getId());	
			
			ResultSet res = prestat.executeQuery();

			
			while(res.next()) {
				i++;}
			gastosUsuario = new String[i];
			res.beforeFirst();
			
			while(res.next()) {
				gastosUsuario[y] = "Servicio de "+res.getString("NombreServicio")+", "+res.getString("Concepto")+". Con un importe de "+res.getString("Importe");
				y++;
				}
			
			
			
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
		return gastosUsuario;
		
	}
	
	
	/**
	* Modifica la información de un gasto en la base de datos.
	* @param gastos El objeto Gasto con la información actualizada.
	* @throws Exception Si hay un error al conectar con la base de datos.
	*/
	public void modificaGastos(Gasto gastos) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("update gasto set FechaPago = ? where IDGasto = ?");
			
			
			prestat.setString(1, gastos.getFechaPago());
			prestat.setInt(2, gastos.getIdGasto());
			
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
}
