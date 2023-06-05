package bdclass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

import controlador.ControladorServicioSuscripcion;
import inmueble.Inmueble;
import serviciosuscripcion.ServicioSuscripcion;
/**
*Esta clase contiene los métodos necesarios para la gestión de suscripciones a servicios por parte de los inmuebles.
*Permite establecer una nueva suscripción, anular una suscripción existente y mostrar los servicios a los que está suscrito un inmueble.
*@author Ismael
*@version 1.0
*/
public class ServiciosSuscripcionDAO {
	
	/**

	*Este método permite establecer una nueva suscripción a un servicio por parte de un inmueble.
	*@param suscripcion el objeto ServicioSuscripcion que contiene los datos de la suscripción que se desea establecer.
	*/
	public void establecerSuscripcion(ServicioSuscripcion suscripcion) {
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("insert into serviciosuscripcion values(?,?,?,?,?)");
			
			prestat.setInt(1, suscripcion.getServicio().getIdServicio());
			prestat.setInt(2, suscripcion.getInmueble().getIdInmueble());
			prestat.setString(3, suscripcion.getFechaAlta());
			prestat.setString(4, suscripcion.getFechaBaja());
			prestat.setBoolean(5, suscripcion.isEnActivo());

			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	
	/**

	*Este método permite anular una suscripción existente a un servicio por parte de un inmueble.
	*@param suscripcion el objeto ServicioSuscripcion que contiene los datos de la suscripción que se desea anular.
	*/
	public void anularSuscripcion(ServicioSuscripcion suscripcion) {
		
		try{

			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			PreparedStatement prestat = con.prepareStatement("update serviciosuscripcion set FechaBaja = ?, EnActivo = ? where IDServicio = ? and IDInmueble = ?");
			
			
			prestat.setString(1, suscripcion.getFechaBaja());
			prestat.setBoolean(2, suscripcion.isEnActivo());
			prestat.setInt(3, suscripcion.getServicio().getIdServicio());
			prestat.setInt(4, suscripcion.getInmueble().getIdInmueble());
			
			prestat.executeUpdate();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
	
	}
	
	
	//Falta reestablecer suscripcion, para que sea correcto al 100%
	
	/**

	*Este método permite mostrar los servicios a los que está suscrito un inmueble.
	*@param inmueble el objeto Inmueble del que se desea conocer sus suscripciones.
	*@return una cadena de texto con el nombre de los servicios a los que está suscrito el inmueble.
	*/
	public String mostrarSuscripcion(Inmueble inmueble) {
		String servicios = "Sin suscripciones";
		try{
			
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			
			PreparedStatement prestat = con.prepareStatement("select * from servicios se, serviciosuscripcion sus where sus.IDInmueble = ? and se.IDServicio = sus.IDServicio and sus.EnActivo = 1");
			
			prestat.setInt(1, inmueble.getIdInmueble());	
			
			ResultSet res = prestat.executeQuery();
			while(res.next()) {
				if(servicios == "Sin suscripciones") {
					servicios = res.getString("NombreServicio");}
				else {
					servicios = servicios+ ", "+res.getString("NombreServicio");
				}

			}

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
		return servicios;
		
	}
	/**

	Obtiene los inmuebles asociados a un servicio específico.

	@param nombreServicio el nombre del servicio del cual se desean obtener los inmuebles.

	@return una lista de cadenas de texto con los nombres de los inmuebles asociados al servicio.
	*/
	public List<String> obtenerInmueblesPorServicio(String nombreServicio) {
		List<String> nombreInmuebles = new ArrayList<>();
		try{
			
			ConexionBD conBD = new ConexionBD();
	        Connection con = conBD.getConnection();
			
			
			PreparedStatement prestat = con.prepareStatement("SELECT DISTINCT i.Nombre FROM serviciosuscripcion su JOIN inmueble i ON su.IDInmueble = i.IDInmueble JOIN servicios s ON su.IDServicio = s.IDServicio WHERE s.NombreServicio = ? AND su.EnActivo = true");
			
			prestat.setString(1, nombreServicio);	
			ResultSet res = prestat.executeQuery();
			
			while(res.next()) {
				String nombreInmueble = res.getString("Nombre");
				nombreInmuebles.add(nombreInmueble);

			}

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar");
		}
		return nombreInmuebles;
		
	}
	
    public static void main(String[] args) {
    	ServiciosSuscripcionDAO c = new ServiciosSuscripcionDAO();
        System.out.print(c.obtenerInmueblesPorServicio("Cortar el pasto"));
    }
}
