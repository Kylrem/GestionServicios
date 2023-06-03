/**
 * Esta es una clase que representa el objeto LocalComercial.
 * Proporciona varios métodos para interactuar con el objeto. Hereda de Inmueble.
 * @author Ismael
 * @version 1.0
 */
public class LocalComercial extends Inmueble {
	
	private String tipoNegocio;

	public LocalComercial(int idInmueble, User propietario, String nombre, int metrosConstruidos, int numero, String calle,String tipoNegocio) 
	{
		super(idInmueble, propietario, nombre, metrosConstruidos, numero, calle);
		this.tipoNegocio = tipoNegocio;
	}
	/**

	Devuelve el tipo de negocio que hay en el local.
	@return String tipo de negocio.
	*/
	public int getTipoNegocio() {
	return tipoNegocio;
	}
	/**

	Establece el tipo de negocio que hay en el local.

	@param tipoNegocio String tipo de negocio.
	*/
	public void setTipoNegocio(int tipoNegocio) {
	this.tipoNegocio = tipoNegocio;
	}

	}