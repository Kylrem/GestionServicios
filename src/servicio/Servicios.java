package servicio;

import java.util.ArrayList;
import java.util.List;

import controlador.ControladorServicio;
import usuario.User;

/**
 * Esta es una clase que representa el objeto Servicios.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */

public abstract class Servicios {
	
	private int idServicio;
	private String nombreServicio;
	private String concepto;
	private boolean esComunitario;// si es true aplica a todos los inmuebles(las cuotas de comunidad por ejemplo)
	
	public Servicios() {

		this.esComunitario = esComunitario;
	}
	/**
	 * Crea un objeto Servicios con los parámetros especificados.
	 * 
	 * @param idServicio El identificador único del servicio.
	 * @param nombreServicio El nombre del servicio.
	 * @param concepto La descripción del concepto del servicio.
	 * @param esComunitario Si el servicio es comunitario o no.
	 */
	public Servicios(int idServicio, String nombreServicio, String concepto, boolean esComunitario) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.concepto = concepto;
		this.esComunitario = esComunitario;
	}


	/**
	 * Obtiene el identificador único del servicio.
	 * 
	 * @return El identificador único del servicio.
	 */
	public int getIdServicio() {
		return idServicio;
	}

	/**
	 * Establece el identificador único del servicio.
	 * 
	 * @param idServicio El identificador único del servicio.
	 */
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * Obtiene el nombre del servicio.
	 * 
	 * @return El nombre del servicio.
	 */
	public String getNombreServicio() {
		return nombreServicio;
	}

	/**
	 * Establece el nombre del servicio.
	 * 
	 * @param nombreServicio El nombre del servicio.
	 */
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	/**
	 * Obtiene la descripción del concepto del servicio.
	 * 
	 * @return La descripción del concepto del servicio.
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * Establece la descripción del concepto del servicio.
	 * 
	 * @param concepto La descripción del concepto del servicio.
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * Indica si el servicio es comunitario o no.
	 * 
	 * @return true si el servicio es comunitario, false en caso contrario.
	 */
	public boolean isEsComunitario() {
		return esComunitario;
	}

	/**
	 * Establece si el servicio es comunitario o no.
	 * 
	 * @param esComunitario true si el servicio es comunitario, false en caso contrario.
	 */
	public void setEsComunitario(boolean esComunitario) {
		this.esComunitario = esComunitario;
	}
	
	/**

	Permite dar de alta un servicio de tarifa plana
	@param servicio el servicio de tarifa plana a dar de alta
	*/
	public void alta(ServicioTarifaPlana servicio) {
	    ControladorServicio.altaServicio(servicio);
	}
	/**

	Permite dar de baja un servicio de tarifa plana
	@param servicio el servicio de tarifa plana a dar de baja
	*/
	public void baja(ServicioTarifaPlana servicio) {
	    ControladorServicio.bajaServicio(servicio);
	}
	/**

	Permite modificar un servicio de tarifa plana
	@param servicio el servicio de tarifa plana a modificar
	*/
	public void modificar(ServicioTarifaPlana servicio) {
	    ControladorServicio.modificarServicio(servicio);
	}
	/**

	Devuelve una cadena de texto con la información del servicio
	@return una cadena de texto con la información del servicio
	*/
	@Override
	public String toString() {
		return "Servicios [idServicio=" + idServicio + ", nombreServicio=" + nombreServicio + ", concepto=" + concepto
				+ ", esComunitario=" + esComunitario + "]";
	}

	
	
}
