package serviciosuscripcion;

import controlador.ControladorServicioSuscripcion;
import java.util.Date;

import inmueble.Inmueble;
import servicio.Servicios;
/**
 * La clase ServicioSuscripcion representa una suscripción de un servicio a un inmueble.
 * Contiene información acerca del servicio, el inmueble, la fecha de alta, la fecha de baja,
 * y si la suscripción está activa o no.
 * @author Ismael
 * @version 1.0
 */
public class ServicioSuscripcion {

	private Servicios servicio;
	private Inmueble inmueble;
	private String fechaAlta;
	private String fechaBaja;
	private boolean enActivo;
	
	
	/**
	 * Constructor de la clase ServicioSuscripcion.
	 * 
	 * @param servicio el servicio asociado a la suscripción
	 * @param inmueble el inmueble asociado a la suscripción
	 * @param fechaAlta la fecha de alta de la suscripción
	 * @param fechaBaja la fecha de baja de la suscripción
	 * @param enActivo indica si la suscripción está activa o no
	 */
	public ServicioSuscripcion(Servicios servicio, Inmueble inmueble, String fechaAlta, String fechaBaja, boolean enActivo) {
		super();
		this.servicio = servicio;
		this.inmueble = inmueble;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.enActivo = enActivo;
	}

	/**
	 * Obtiene el servicio asociado a la suscripción.
	 * 
	 * @return el servicio asociado a la suscripción
	 */
	public Servicios getServicio() {
		return servicio;
	}

	/**
	 * Establece el servicio asociado a la suscripción.
	 * 
	 * @param servicio el servicio asociado a la suscripción
	 */
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}

	/**
	 * Obtiene el inmueble asociado a la suscripción.
	 * 
	 * @return el inmueble asociado a la suscripción
	 */
	public Inmueble getInmueble() {
		return inmueble;
	}

	/**
	 * Establece el inmueble asociado a la suscripción.
	 * 
	 * @param inmueble el inmueble asociado a la suscripción
	 */
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	/**
	 * Obtiene la fecha de alta de la suscripción.
	 * 
	 * @return la fecha de alta de la suscripción
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Establece la fecha de alta de la suscripción.
	 * 
	 * @param fechaAlta la fecha de alta de la suscripción
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Obtiene la fecha de baja de la suscripción.
	 * 
	 * @return la fecha de baja de la suscripción
	 */
	public String getFechaBaja() {
		return fechaBaja;
	}
	
	/**
	 * Establece la fecha de baja de la suscripción.
	 * 
	 * @param fechaBaja la fecha de baja de la suscripción
	 */
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	/**
	 * Obtiene el estado de la suscripción.
	 * 
	 * @return la estado de la suscripción
	 */
	public boolean isEnActivo() {
		return enActivo;
	}
	/**
	 * Establece el estado de la suscripción.
	 * 
	 * @param enActivo el estado de la suscripción
	 */
	public void setEnActivo(boolean enActivo) {
		this.enActivo = enActivo;
	}
	/**

	Anula una suscripción del servicio especificado.
	@param suscrito el servicio de suscripción a anular.
	*/
	public void anularSus(ServicioSuscripcion suscrito) {
		ControladorServicioSuscripcion.anularSus(suscrito);
	}
	/**

	Establece una suscripción para el servicio especificado.
	@param suscrito el servicio de suscripción a establecer.
	*/
	public void establecerSus(ServicioSuscripcion suscrito) {
		ControladorServicioSuscripcion.establecerSus(suscrito);
		
	}
	/**

	Obtiene los inmuebles asociados a un servicio específico.
	@param nombreServicio el nombre del servicio del cual se desean obtener los inmuebles.
	*/
	public void obtenerInmueblesPorServicio(String nombreServicio) {
		ControladorServicioSuscripcion.mostrarInmueblesPorServicio(nombreServicio);
		
	}
	
}
