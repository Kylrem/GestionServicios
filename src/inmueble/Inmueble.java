package inmueble;

import usuario.User;

/**
 * Esta es una clase que representa el objeto Inmueble.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public abstract class Inmueble {
	
	protected int idInmueble;
	protected User propietario;
	protected String nombre;
	protected int metrosConstruidos;
	protected int numero;
	protected String calle;
	
	
	/**

	Constructor de la clase Inmueble
	@param idInmueble El id del inmueble
	@param propietario El propietario del inmueble
	@param nombre El nombre del inmueble
	@param metrosConstruidos La cantidad de metros construidos del inmueble
	@param numero El número de la calle del inmueble
	@param calle El nombre de la calle del inmueble
	*/
	public Inmueble(int idInmueble, User propietario, String nombre, int metrosConstruidos, int numero, String calle) {
	super();
	this.idInmueble = idInmueble;
	this.propietario = propietario;
	this.nombre = nombre;
	this.metrosConstruidos = metrosConstruidos;
	this.numero = numero;
	this.calle = calle;
	}
	/**

	Devuelve el id del inmueble.
	@return El id del inmueble
	*/
	public int getIdInmueble() {
	return idInmueble;
	}
	/**

	Establece el id del inmueble.
	@param idInmueble El id del inmueble a establecer
	*/
	public void setIdInmueble(int idInmueble) {
	this.idInmueble = idInmueble;
	}
	/**

	Devuelve el propietario del inmueble.
	@return El propietario del inmueble
	*/
	public User getPropietario() {
	return propietario;
	}
	/**

	Establece el propietario del inmueble.
	@param propietario El propietario del inmueble a establecer
	*/
	public void setPropietario(User propietario) {
	this.propietario = propietario;
	}
	/**

	Devuelve el nombre del inmueble.
	@return El nombre del inmueble
	*/
	public String getNombre() {
	return nombre;
	}
	/**

	Establece el nombre del inmueble.
	@param nombre El nombre del inmueble a establecer
	*/
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	/**

	Devuelve la cantidad de metros construidos del inmueble.
	@return La cantidad de metros construidos del inmueble
	*/
	public int getMetrosConstruidos() {
	return metrosConstruidos;
	}
	/**

	Establece la cantidad de metros construidos del inmueble.
	@param metrosConstruidos La cantidad de metros construidos del inmueble a establecer
	*/
	public void setMetrosConstruidos(int metrosConstruidos) {
	this.metrosConstruidos = metrosConstruidos;
	}

	/**

	Obtiene el número de la calle del inmueble.
	@return El número de la calle del inmueble.
	*/
	public int getNumero() {
	return numero;
	}
	/**

	Establece el número de la calle del inmueble.
	@param numero El número de la calle del inmueble.
	*/
	public void setNumero(int numero) {
	this.numero = numero;
	}
	/**

	Obtiene el nombre de la calle del inmueble.
	@return El nombre de la calle del inmueble.
	*/
	public String getCalle() {
	return calle;
	}
	/**

	Establece el nombre de la calle del inmueble.
	@param calle El nombre de la calle del inmueble.
	*/
	public void setCalle(String calle) {
	this.calle = calle;
	}
	
	
	

}
