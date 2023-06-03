package usuario;


import java.util.Date;

import controlador.ControladorUsuario;
import controlador.ControladorGasto;
import controlador.ControladorLiquidacion;
import gasto.Gasto;
import inmueble.Inmueble;
import liquidacion.Liquidacion;
import servicio.ServicioTarifaPlana;
import servicio.Servicios;
import serviciosuscripcion.ServicioSuscripcion;

/**
 * Esta es una clase que representa el objeto Admin.
 * Proporciona varios métodos para interactuar con el objeto. Hereda de User
 * @author Ismael
 * @version 1.0
 */
public class Admin extends User {

	public Admin(int id, String nombre, String apellido1, String apellido2, String dni, String pass, int tel,String email) 
	{
		super(id, nombre, apellido1, apellido2, dni, pass, tel, email);
	}

	
	/**

	Permite dar de alta a un usuario, indicando si es administrador o no.
	@param usuario el usuario a dar de alta
	@param isAdmin true si el usuario es administrador, false si no lo es
	*/
	public void alta(User usuario, boolean isAdmin) {
		ControladorUsuario.alta(usuario, isAdmin);

	}	

	/**

	Permite dar de baja a un usuario del sistema.
	@param usuario el usuario a dar de baja
	*/
	public void baja(User usuario) {
		ControladorUsuario.baja(usuario);
	}

	/**

	Permite modificar los datos de un usuario en el sistema.
	@param usuario el usuario a modificar
	*/
	public void modificar(User usuario) {
		ControladorUsuario.baja(usuario);
	}
	
	/**

	Permite dar de alta un nuevo servicio de tarifa plana en el sistema.
	@param servicio el servicio a dar de alta
	*/
	public void altaServicio(ServicioTarifaPlana servicio) {
		servicio.alta(servicio);
		
	}
	
	/**

	Permite dar de baja un servicio de tarifa plana del sistema.
	@param servicio el servicio a dar de baja
	*/
	public void bajaServicio(ServicioTarifaPlana servicio) {
		
		servicio.baja(servicio);
	}
	
	/**

	Permite modificar los datos de un servicio de tarifa plana en el sistema.
	@param servicio el servicio a modificar
	*/
	public void modificarServicio(ServicioTarifaPlana servicio) {
		
		servicio.modificar(servicio);
	}
	
	/**
	Permite anular la suscripción de un inmueble a un servicio.
	@param inmueble el inmueble a anular la suscripción
	@param servicio el servicio del que se quiere anular la suscripción
	*/
	public void anularSuscripcionUsuario(Inmueble inmueble, Servicios servicio) {
		
		Date fecha = new Date();
		
		ServicioSuscripcion sus = new ServicioSuscripcion(servicio, inmueble, null, fecha.toString(), false);
		
		sus.anularSus(sus);
		
		
	}
	
	/**
	Permite establecer la suscripción de un inmueble a un servicio.
	@param inmueble el inmueble a establecer la suscripción
	@param servicio el servicio del que se quiere establecer la suscripción
	*/
	public void establecerSuscripcionUsuario(Inmueble inmueble, Servicios servicio) {
		
		Date fecha = new Date();
		Date fecha2 = new Date();
		fecha2.setYear(fecha.getYear()+1);
		
		ServicioSuscripcion sus = new ServicioSuscripcion(servicio, inmueble, fecha.toString() ,fecha2.toString(), true);
		
		sus.establecerSus(sus);
		
	}
	
	
	/**

	Permite dar de alta un nuevo gasto en el sistema.
	@param gastos el gasto a dar de alta
	*/
	public void altaGasto(Gasto gastos) {
		gastos.alta(gastos);
		
	}
	
	/**

	Permite dar de baja un gasto del sistema.
	@param gastos el gasto a dar de baja
	*/
	public void bajaGasto(Gasto gastos) {
		
		gastos.baja(gastos);
	}
	
	/**

	Modifica un gasto existente en la base de datos.

	@param gastos el gasto a modificar.
	*/
	public void modificarGasto(Gasto gastos) {
		
		gastos.modificar(gastos);
	}
	
	/**

	Muestra los gastos de un usuario específico.
	@param usuario el usuario del que se quieren mostrar los gastos.
	@return un arreglo de cadenas que representa los gastos del usuario.
	*/
	public String[] mostrarGasto(User usuario) {
		return ControladorGasto.mostrarGastoUser(usuario);
		
	}
	
	/**

	Agrega una nueva liquidación a la base de datos.
	@param liqu la liquidación a agregar.
	*/
	public void altaLiquidacion(Liquidacion liqu) {

		liqu.alta();
		
	}

	/**

	Elimina una liquidación existente de la base de datos.
	@param liqu la liquidación a eliminar.
	*/
	public void bajaLiquidacion(Liquidacion liqu) {
		ControladorLiquidacion.bajaLiquidacion(liqu);
	}
	
	/**

	Modifica una liquidación existente en la base de datos.
	@param liqu la liquidación a modificar.
	*/
	public void modificarLiquidacion(Liquidacion liqu) {
		ControladorLiquidacion.modificarLiquidacion(liqu);
	}
	
}
