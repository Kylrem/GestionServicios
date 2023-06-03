package gasto;


import servicio.Servicios;
/**
 * Esta es una clase que representa el objeto Factura.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public class Factura {

	private Proveedor proveedor;
	private Servicios servicio;
	private String documento;
	protected float importe;
	
	
	/**

	Crea una nueva instancia de la clase Factura.
	@param proveedor el proveedor de la factura
	@param servicio el servicio facturado
	@param documento el documento de la factura
	@param importe el importe de la factura
	*/
	public Factura(Proveedor proveedor, Servicios servicio, String documento, float importe) {
	super();
	this.proveedor = proveedor;
	this.servicio = servicio;
	this.documento = documento;
	this.importe = importe;
	}
	/**

	Devuelve el proveedor de la factura.
	@return el proveedor de la factura
	*/
	public Proveedor getProveedor() {
	return proveedor;
	}
	/**

	Establece el proveedor de la factura.
	@param proveedor el proveedor de la factura
	*/
	public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
	}
	/**

	Devuelve el servicio facturado.
	@return el servicio facturado
	*/
	public Servicios getServicio() {
	return servicio;
	}
	/**

	Establece el servicio facturado.
	@param servicio el servicio facturado
	*/
	public void setServicio(Servicios servicio) {
	this.servicio = servicio;
	}
	/**

	Devuelve el documento de la factura.
	@return el documento de la factura
	*/
	public String getDocumento() {
	return documento;
	}
	/**

	Establece el documento de la factura.
	@param documento el documento de la factura
	*/
	public void setDocumento(String documento) {
	this.documento = documento;
	}
	/**

	Devuelve el importe de la factura.
	@return el importe de la factura
	*/
	public float getImporte() {
	return importe;
	}
	/**

	Establece el importe de la factura.
	@param importe el importe de la factura
	*/
	public void setImporte(float importe) {
	this.importe = importe;
	}
	}
