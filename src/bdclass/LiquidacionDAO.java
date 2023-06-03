package bdclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import gasto.Gasto;
import liquidacion.Liquidacion;
import servicio.ServicioTarifaPlana;
import usuario.User;


/**
 *La clase LiquidacionDAO es responsable de gestionar las operaciones de creación, modificación y eliminación de una liquidación
  en la base de datos. Además, proporciona la funcionalidad de generar el detalle de liquidación para un usuario en particular y
  calcular el monto total de los servicios suscritos por el usuario.
 *@author Ismael
 *@version 1.0
 */
public class LiquidacionDAO {
	
	/**

	Registra una nueva liquidación en la base de datos. Si la liquidación ya existe, se agrega el gasto a la liquidación existente.
	@param liqui objeto de la clase Liquidacion a registrar
	@param gastos objeto de la clase Gasto a agregar a la liquidación
	*/
	public void registrarLiquidacion(Liquidacion liqui, Gasto gastos) {
		try{
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement pres = con.prepareStatement("select * from liquidacion where IDLiquidacion = ?");

			pres.setInt(1, liqui.getIdLiquidacion());
			
			ResultSet r = pres.executeQuery();
			
			if(!r.next()) {
			
			PreparedStatement prestat = con.prepareStatement("insert into gasto liquidacion(?,?,?,?)");
			
			prestat.setInt(1, liqui.getIdLiquidacion());
			prestat.setString(2, liqui.getFechaInicial());
			prestat.setString(3, liqui.getFechaFinal());
			prestat.setString(4, liqui.getNombrepago());
			
			prestat.executeUpdate();
			


			PreparedStatement prestat4 = con.prepareStatement("insert into liquidacion_gastos values(?,?)");
				
			prestat4.setInt(1, liqui.getIdLiquidacion());
			prestat4.setInt(2, gastos.getIdGasto());
				
			prestat4.executeUpdate();
			
			}else {
				PreparedStatement prestat4 = con.prepareStatement("insert into liquidacion_gastos values(?,?)");
				
				prestat4.setInt(1, liqui.getIdLiquidacion());
				prestat4.setInt(2, gastos.getIdGasto());
					
				prestat4.executeUpdate();
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
			e.printStackTrace();
		}
	
	}
	
	/**
	Elimina una liquidación de la base de datos.
	@param liqui objeto de la clase Liquidacion a eliminar
	*/
	public void eliminarLiquidacion(Liquidacion liqui) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat2 = con.prepareStatement("DELETE FROM liquidacion_gastos WHERE IDLiquidacion = ?");
			
			prestat2.setInt(1, liqui.getIdLiquidacion());
			
			prestat2.executeUpdate();
			
			PreparedStatement prestat3 = con.prepareStatement("DELETE FROM liquidacion_detalleliquidacion WHERE IDLiquidacion = ?");
			
			prestat3.setInt(1, liqui.getIdLiquidacion());
			
			prestat3.executeUpdate();
			
			PreparedStatement prestat = con.prepareStatement("DELETE FROM liquidacion WHERE IDLiquidacion = ?");
			
			prestat.setInt(1, liqui.getIdLiquidacion());
			
			prestat.executeUpdate();
			

			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
			e.printStackTrace();
		}
	
	}
	
	/**
	Modifica una liquidación existente en la base de datos.
	@param liqui objeto de la clase Liquidacion a modificar
	*/
	public void modificaLiquidacion(Liquidacion liqui) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("update liquidacion set FechaInicial = ?, FechaFinal = ?, NombrePago = ? where IDLiquidacion = ?");
			
			
			prestat.setString(1, liqui.getFechaInicial());
			prestat.setString(2, liqui.getFechaFinal());
			prestat.setString(3, liqui.getNombrepago());
			prestat.setInt(4, liqui.getIdLiquidacion());
			
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	/**
	Genera el detalle de la liquidación para un propietario y un servicio de tarifa plana específico
	@param liqui La liquidación a la que se agregará el detalle
	@param usuario El usuario propietario de un inmueble que tiene el servicio
	@param serv El servicio de tarifa plana al que se agregará el detalle
	 */
	public void generarDetalleLiquidacion(Liquidacion liqui, User usuario, ServicioTarifaPlana serv) {
		
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("SELECT * FROM `inmueble` WHERE IDPropietario = ?");
			
			prestat.setInt(1, usuario.getId());
			
			ResultSet res = prestat.executeQuery();
			
			int i = res.getInt("IDInmueble");
			
			PreparedStatement prestat2 = con.prepareStatement("SELECT * FROM `inmueble` WHERE IDPropietario = ?");
			
			prestat2.setInt(1, usuario.getId());
			
			ResultSet res2 = prestat2.executeQuery();
			
			
			PreparedStatement prestat4 = con.prepareStatement("insert into detalleliquidacion values(?,?,?,?)");
			
			prestat4.setInt(1, i);
			prestat4.setInt(2, serv.getIdServicio());
			prestat4.setFloat(3, serv.getPrecio());
			
			prestat4.executeUpdate();
			
			PreparedStatement prestat5 = con.prepareStatement("SELECT * FROM detalleliquidacion WHERE IDInmueble = ? AND IDServicio = ? ");
			
			prestat5.setInt(1, i);
			prestat5.setInt(2, serv.getIdServicio());
			
			ResultSet res5 = prestat5.executeQuery();
			
			int j = res.getInt("IDDetalleliquidacion");
			
			PreparedStatement prestat3 = con.prepareStatement("insert into liquidacion_detalleliquidacion values(?,?)");
			
			prestat3.setInt(1, liqui.getIdLiquidacion() );
			prestat3.setInt(2, j);
			
			prestat3.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
		
	}
	/**
	Obtiene el monto total de los servicios activos de tarifa plana para un propietario
	@param usuario El usuario propietario del inmueble
	@return El monto total de los servicios activos de tarifa plana del propietario en formato de cadena de texto
	*/
	public String montoTotalServicios(User usuario) {
		
		String sum = null;
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("select SUM(se.Precio) from servicios se, serviciosuscripcion sus, inmueble inm where inm.IDPropietario = ? AND sus.IDInmueble = inm.IDInmueble and se.IDServicio = sus.IDServicio and sus.EnActivo = 1");
			
			prestat.setInt(1, usuario.getId());
			
			ResultSet res = prestat.executeQuery();
			res.next();
		    sum = res.getString(1);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
			e.printStackTrace();
		}
	
		return sum;
	}
}
