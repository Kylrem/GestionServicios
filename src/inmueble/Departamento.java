package inmueble;

import usuario.User;

/**
 * Esta es una clase que representa el objeto Departamento.
 * Proporciona varios métodos para interactuar con el objeto. Hereda de Inmueble.
 * @author Ismael
 * @version 1.0
 */
public class Departamento extends Inmueble {
	
	private String portal;
	private String puerta;
	private int piso;
	
	
	/**

	Constructor de la clase Departamento que inicializa los atributos heredados de Inmueble
	y los atributos especificos del departamento.
	@param idInmueble El identificador del inmueble
	@param propietario El usuario propietario del inmueble
	@param nombre El nombre del inmueble
	@param metrosConstruidos Los metros construidos del inmueble
	@param numero El número de la dirección del inmueble
	@param calle La calle del inmueble
	@param portal El portal del departamento
	@param puerta La puerta del departamento
	@param piso El piso donde se encuentra el departamento
	*/
	public Departamento(int idInmueble, User propietario, String nombre, int metrosConstruidos, int numero,	String calle, String portal, String puerta, int piso) 
	{
		super(idInmueble, propietario, nombre, metrosConstruidos, numero, calle);
		this.portal = portal;
		this.puerta = puerta;
		this.piso = piso;
	}

	/**

	Retorna el portal del departamento.
	@return El portal del departamento
	*/
	public String getPortal() {
	return portal;
	}
	/**

	Establece el portal del departamento.
	@param portal El nuevo portal del departamento
	*/
	public void setPortal(String portal) {
	this.portal = portal;
	}
	/**

	Retorna la puerta del departamento.
	@return La puerta del departamento
	*/
	public String getPuerta() {
	return puerta;
	}
	/**

	Establece la puerta del departamento.
	@param puerta La nueva puerta del departamento
	*/
	public void setPuerta(String puerta) {
	this.puerta = puerta;
	}
	/**

	Retorna el piso donde se encuentra el departamento.
	@return El piso del departamento
	*/
	public int getPiso() {
	return piso;
	}
	/**

	Establece el piso donde se encuentra el departamento.
	@param piso El nuevo piso del departamento
	*/
	public void setPiso(int piso) {
	this.piso = piso;
	}
	}
