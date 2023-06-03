package controlador;

import gasto.Gasto;
import usuario.User;
import bdclass.GastosDAO;

/**
*Clase ControladorGasto encargada de gestionar la interacción entre la capa de presentación y la capa de acceso a datos
*@author Ismael
*@version 1.0
*/
public class ControladorGasto {
	
	/**
	Método estático que se encarga de registrar un nuevo gasto en la base de datos
	@param gasto Objeto de tipo Gasto que se desea registrar en la base de datos
	*/

	public static void alta(Gasto gasto) {
		GastosDAO bd = new GastosDAO();
		
		
		for(int i = 0;i<gasto.factura.size();i++) {
			bd.registrarGastos(gasto,gasto.factura.get(i).getProveedor(),gasto.factura.get(i).getServicio());
			
		}

	}

	
	/**
	Método estático que se encarga de eliminar un gasto de la base de datos
	@param gasto Objeto de tipo Gasto que se desea eliminar de la base de datos
	*/
	public static void baja(Gasto gasto) {
		GastosDAO bd = new GastosDAO();
		
		bd.eliminarGastos(gasto);
		
	}
	
	
	/**
	Método estático que se encarga de modificar un gasto existente en la base de datos
	@param gasto Objeto de tipo Gasto que se desea modificar en la base de datos
	*/
	public static void modificar(Gasto gasto) {
		GastosDAO bd = new GastosDAO();
		
		bd.modificaGastos(gasto);
		
	}
	
	/**

	Devuelve un array de String con la información de los gastos registrados por un usuario en la base de datos.
	@param us objeto User que contiene la información del usuario del cual se quieren mostrar los gastos.
	@return un array de String con la información de los gastos registrados por el usuario.
	*/
	public static String[] mostrarGastoUser(User us) {
		
		GastosDAO bd = new GastosDAO();
		
		return bd.muestraGastos(us);
		
	}
}
