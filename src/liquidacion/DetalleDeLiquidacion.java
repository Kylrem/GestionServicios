package liquidacion;

import inmueble.Inmueble;
import servicio.Servicios;
/**
 * Esta es una clase que representa el objeto DetalleDeLiquidacion.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public class DetalleDeLiquidacion {
	
	
	private Inmueble inmueble;
	private Servicios servicio;
	private float importe;
	
	/**
	 * Constructor de la clase DetalleDeLiquidacion
	 * 
	 * @param inmueble El objeto Inmueble al que se asocia el detalle de liquidación
	 * @param servicio El objeto Servicios al que se asocia el detalle de liquidación
	 * @param importe El importe correspondiente al detalle de liquidación
	 */
	public DetalleDeLiquidacion(Inmueble inmueble, Servicios servicio, float importe) {
		super();
		this.inmueble = inmueble;
		this.servicio = servicio;
		this.importe = importe;
	}
	
	/**
	 * Método para obtener el objeto Inmueble asociado al detalle de liquidación
	 * 
	 * @return El objeto Inmueble asociado al detalle de liquidación
	 */
	public Inmueble getInmueble() {
		return inmueble;
	}
	
	/**
	 * Método para establecer el objeto Inmueble asociado al detalle de liquidación
	 * 
	 * @param inmueble El objeto Inmueble a asociar al detalle de liquidación
	 */
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	/**
	 * Método para obtener el objeto Servicios asociado al detalle de liquidación
	 * 
	 * @return El objeto Servicios asociado al detalle de liquidación
	 */
	public Servicios getServicio() {
		return servicio;
	}
	
	/**
	 * Método para establecer el objeto Servicios asociado al detalle de liquidación
	 * 
	 * @param servicio El objeto Servicios a asociar al detalle de liquidación
	 */
	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}
	
	/**
	 * Método para obtener el importe correspondiente al detalle de liquidación
	 * 
	 * @return El importe correspondiente al detalle de liquidación
	 */
	public float getImporte() {
		return importe;
	}
	
	/**
	 * Método para establecer el importe correspondiente al detalle de liquidación
	 * 
	 * @param importe El importe correspondiente al detalle de liquidación a establecer
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

}
