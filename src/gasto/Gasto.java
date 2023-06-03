package gasto;
import controlador.ControladorGasto;
import java.util.Date;
import java.util.List;

import usuario.User;

/**
 * Esta es una clase que representa el objeto Gasto.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public class Gasto {
	
	private int idGasto;
	private String fechaPago;
	public List<Factura> factura;
	
	/**

	Constructor de la clase Gasto que inicializa los atributos del objeto.
	@param idGasto Identificador del gasto.
	@param fechaPago Fecha en la que se realizó el pago del gasto.
	@param factura Lista de facturas asociadas al gasto.
	*/
	public Gasto(int idGasto, String fechaPago, List<Factura> factura) {
		super();
		this.idGasto = idGasto;
		this.fechaPago = fechaPago;
		this.factura = factura;
	}
	
	/**

	Retorna el id del gasto.
	@return el id del gasto.
	*/
	public int getIdGasto() {
	return idGasto;
	}
	/**

	Establece el id del gasto.
	@param idGasto el id del gasto.
	*/
	public void setIdGasto(int idGasto) {
	this.idGasto = idGasto;
	}
	/**

	Retorna la fecha de pago del gasto.
	@return la fecha de pago del gasto.
	*/
	public String getFechaPago() {
	return fechaPago;
	}
	/**

	Establece la fecha de pago del gasto.
	@param fechaPago la fecha de pago del gasto.
	*/
	public void setFechaPago(String fechaPago) {
	this.fechaPago = fechaPago;
	}
	/**

	Retorna la lista de facturas asociadas al gasto.
	@return la lista de facturas asociadas al gasto.
	*/
	public List<Factura> getFactura() {
	return factura;
	}
	/**

	Establece la lista de facturas asociadas al gasto.
	@param factura la lista de facturas asociadas al gasto.
	*/
	public void setFactura(List<Factura> factura) {
	this.factura = factura;
	}
	/**

	Retorna el monto total del gasto.
	@return el monto total del gasto.
	*/
	public float pago() {
	return 0;
	}
	/**

	Da de alta un nuevo gasto en el sistema.
	@return el gasto dado de alta.
	*/
	public void alta(Gasto gasto) {
		ControladorGasto.alta(gasto);
	}
	/**

	Da de baja un gasto existente del sistema.
	*/
	public void baja(Gasto gasto) {
		ControladorGasto.baja(gasto);
	}
	/**

	Modifica un gasto existente en el sistema.
	@param gastos el gasto a modificar.
	*/
	public void modificar(Gasto gasto) {
		ControladorGasto.modificar(gasto);
	}
	}
