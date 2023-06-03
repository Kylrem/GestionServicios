package inmueble;

import usuario.User;

/**
 * Esta es una clase que representa el objeto Casa.
 * Proporciona varios métodos para interactuar con el objeto. Hereda de Inmueble.
 * @author Ismael
 * @version 1.0
 */
public class Casa extends Inmueble {
	
	private int metrosDePatio;

	public Casa(int idInmueble, User propietario, String nombre, int metrosConstruidos, int numero, String calle,int metrosDePatio) 
	{
		super(idInmueble, propietario, nombre, metrosConstruidos, numero, calle);
		this.metrosDePatio = metrosDePatio;
	}
	/**

	Devuelve los metros cuadrados de patio que tiene la casa.
	@return int metros cuadrados de patio.
	*/
	public int getMetrosDePatio() {
	return metrosDePatio;
	}
	/**

	Establece los metros cuadrados de patio que tiene la casa.

	@param metrosDePatio int metros cuadrados de patio.
	*/
	public void setMetrosDePatio(int metrosDePatio) {
	this.metrosDePatio = metrosDePatio;
	}

	}