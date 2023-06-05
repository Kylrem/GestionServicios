package controlador;

import bdclass.ServiciosSuscripcionDAO;
import inmueble.Inmueble;
import serviciosuscripcion.ServicioSuscripcion;


/**

*Clase ControladorServicioSuscripcion encargada de manejar las operaciones relacionadas con las suscripciones de servicios.
*Permite anular o establecer una suscripción en la base de datos mediante el uso de objetos de tipo ServicioSuscripcion y el uso de la clase ServiciosSuscripcionDAO.
*@author Ismael
*@version 1.0
*/
public class ControladorServicioSuscripcion {

	
	/**

	Método estático que anula una suscripción en la base de datos.
	@param suscrito objeto de tipo ServicioSuscripcion que contiene la información de la suscripción a anular.
	*/
	public static void anularSus(ServicioSuscripcion suscrito) {
		ServiciosSuscripcionDAO bd = new ServiciosSuscripcionDAO();
		bd.anularSuscripcion(suscrito);
	}
	/**

	Método estático que establece una nueva suscripción en la base de datos.
	@param suscrito objeto de tipo ServicioSuscripcion que contiene la información de la nueva suscripción a establecer.
	*/
	public static void establecerSus(ServicioSuscripcion suscrito) {
		ServiciosSuscripcionDAO bd = new ServiciosSuscripcionDAO();
		bd.establecerSuscripcion(suscrito);
	}
	
	/**
	Muestra las suscripciones de servicios activas de un inmueble dado.
	@param in el inmueble del cual se quieren mostrar las suscripciones activas.
	*/
	public static void mostrarSuscripcionesUser(Inmueble in) {
		ServiciosSuscripcionDAO bd = new ServiciosSuscripcionDAO();
		
		bd.mostrarSuscripcion(in);
		
		
	}
	/**

	Muestra los inmuebles asociados a un servicio específico.
	@param in el nombre del servicio del cual se desean obtener los inmuebles.
	*/
	public static void mostrarInmueblesPorServicio(String in) {
		ServiciosSuscripcionDAO bd = new ServiciosSuscripcionDAO();
		
		bd.obtenerInmueblesPorServicio(in);
		
		
	}

	
	
}

