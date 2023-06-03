package controlador;

import liquidacion.Liquidacion;
import bdclass.LiquidacionDAO;
/**

* La clase ControladorLiquidacion es responsable de manejar las operaciones de alta de liquidación.
* @author Ismael
* @version 1.0
*/
public class ControladorLiquidacion {

	/**
	*Este método recibe una Liquidacion y llama a la clase LiquidacionDAO para registrar la liquidación en la base de datos.
	*También registra los gastos asociados a la liquidación.
	*@param li la Liquidacion a registrar.
	*/
	public static void altaLiquidacion(Liquidacion li) {
		LiquidacionDAO bd = new LiquidacionDAO();
		
		for(int i = 0;i<li.gastos.size();i++) {
			bd.registrarLiquidacion(li,li.gastos.get(i));}
		
	}
	
	/**
	*Esta función se encarga de dar de baja una liquidación existente en la base de datos.
	*@param liqu la liquidación que se desea eliminar.
	*/
	public static void bajaLiquidacion(Liquidacion liqu) {
		LiquidacionDAO bd = new LiquidacionDAO();
		
		bd.eliminarLiquidacion(liqu);
	}
	
	/**
	*Esta función se encarga de modificar una liquidación existente en la base de datos.
	*@param liqu la liquidación que se desea modificar.
	*/
	public static void modificarLiquidacion(Liquidacion liqu) {
		LiquidacionDAO bd = new LiquidacionDAO();
		
		bd.modificaLiquidacion(liqu);;
	}
}