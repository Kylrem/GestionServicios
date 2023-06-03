package servicio;

/**
 * Esta es una clase que representa el objeto ServicioTarifaPlana.
 * Proporciona varios métodos para interactuar con el objeto. herada de Servicios 
 * @author Ismael
 * @version 1.0
 */
public class ServicioTarifaPlana extends Servicios{
	

	private float precio;

	public ServicioTarifaPlana() {
		super();
	}
	public ServicioTarifaPlana(int idServicio, String nombreServicio, String concepto, boolean esComunitario,float precio) 
	{
		super(idServicio, nombreServicio, concepto, esComunitario);
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}


	
}
