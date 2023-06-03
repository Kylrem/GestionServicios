package controlador;

import servicio.ServicioTarifaPlana;
import bdclass.ServiciosDAO;
/**

*Clase ControladorServicio que se encarga de gestionar las operaciones relacionadas con los servicios, tales como alta,
*baja y modificación de los mismos.
 * @author Ismael
 * @version 1.0
*/
public class ControladorServicio {
	/**

	*Función que registra un servicio en la base de datos.

	*@param servicio objeto de tipo ServicioTarifaPlana que se quiere registrar.
	*/
	public static void altaServicio(ServicioTarifaPlana servicio) {
		
	    ServiciosDAO bd = new ServiciosDAO();
	    bd.registrarServicio(servicio);
	}
	/**

	*Función que elimina un servicio de la base de datos.
	*@param servicio objeto de tipo ServicioTarifaPlana que se quiere eliminar.
	*/
	public static void bajaServicio(ServicioTarifaPlana servicio) {
		
		ServiciosDAO bd = new ServiciosDAO();
		bd.eliminarServicio(servicio);
		
	}
	/**

	*Función que muestra un servicio de la base de datos.
	*@param servicio objeto de tipo ServicioTarifaPlana que se quiere mostrar.
	*/
	public static void modificarServicio(ServicioTarifaPlana servicio) {
		
		ServiciosDAO bd = new ServiciosDAO();
		bd.modificaServicio(servicio);
		
	}
	
}
