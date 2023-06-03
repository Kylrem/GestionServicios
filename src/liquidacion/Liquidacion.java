package liquidacion;
import controlador.ControladorLiquidacion;
import java.util.*;

import gasto.Gasto;

/**
 * Esta es una clase que representa el objeto Liquidacion.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public class Liquidacion {
	
	private int idLiquidacion;
	private String fechaInicial;
	private String fechaFinal;
	private String nombrepago;
	public List<Gasto> gastos;
	private List<DetalleDeLiquidacion> detalles;
	

	/**
	 * Constructor para crear un objeto Liquidacion.
	 * 
	 * @param idLiquidacion El identificador de la liquidación.
	 * @param fechaInicial La fecha inicial de la liquidación.
	 * @param fechaFinal La fecha final de la liquidación.
	 * @param nombrepago El nombre del pago asociado a la liquidación.
	 * @param gastos La lista de gastos asociados a la liquidación.
	 * @param detalles La lista de detalles de liquidación asociados a la liquidación.
	 */
	public Liquidacion(int idLiquidacion, String fechaInicial, String fechaFinal, String nombrepago, List<Gasto> gastos,
			List<DetalleDeLiquidacion> detalles) {
		super();
		this.idLiquidacion = idLiquidacion;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.nombrepago = nombrepago;
		this.gastos = gastos;
		this.detalles = detalles;
	}



	/**
	 * Método para obtener el id de la liquidación
	 * @return el id de la liquidacion
	 */
	public int getIdLiquidacion() {
		return idLiquidacion;
	}

	/**
	 * Método para establecer el id de la liquidación
	 * @param idLiquidacion el id de la liquidacion
	 */
	public void setIdLiquidacion(int idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

	/**
	 * Método para obtener la fecha inicial de la liquidación
	 * @return la fecha inicial de la liquidacion
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * Método para establecer la fecha inicial de la liquidación
	 * @param fechaInicial la fecha inicial de la liquidacion
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * Método para obtener la fecha final de la liquidación
	 * @return la fecha final de la liquidacion
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Método para establecer la fecha final de la liquidación
	 * @param fechaFinal la fecha final de la liquidacion
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * Método para obtener el nombre del pago de la liquidación
	 * @return el nombre del pago de la liquidacion
	 */
	public String getNombrepago() {
		return nombrepago;
	}

	/**
	 * Método para establecer el nombre del pago de la liquidación
	 * @param nombrepago el nombre del pago de la liquidacion
	 */
	public void setNombrepago(String nombrepago) {
		this.nombrepago = nombrepago;
	}

	/**
	 * Método para obtener la lista de gastos asociados a la liquidación
	 * @return la lista de gastos asociados a la liquidacion
	 */
	public List<Gasto> getGastos() {
		return gastos;
	}


	/**
	 * Método para establecer la lista de gastos asociados a la liquidación
	 * @param gastos la lista de gastos asociados a la liquidacion
	 */
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}


	/**
	 * Método para obtener la lista de detalles de liquidación
	 * @return la lista de detalles de liquidación
	 */
	public List<DetalleDeLiquidacion> getDetalles() {
		return detalles;
	}


	/**
	 * Método para establecer la lista de detalles de liquidación
	 * @param gastos la lista de detalles de liquidación
	 */
	public void setDetalles(List<DetalleDeLiquidacion> detalles) {
		this.detalles = detalles;
	}
	
	/**

	*Registra una nueva liquidación en la base de datos a través del método estático "altaLiquidacion" de la clase ControladorLiquidacion. 
	*La liquidación a registrar es el objeto actual (this).
	*/
	public void alta() {
		ControladorLiquidacion.altaLiquidacion(this);
	}


	public void generarDetalleLiquidacion() {
		
	}

}
