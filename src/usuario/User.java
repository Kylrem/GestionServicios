package usuario;

import java.util.*;

import gasto.Gasto;
import inmueble.Inmueble;
import servicio.ServicioTarifaPlana;
import servicio.Servicios;
import controlador.ControladorServicioSuscripcion;
import controlador.ControladorGasto;


import java.lang.*;


/**
 * Esta es una clase que representa el objeto Usuarop.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */

public abstract class User {
	protected int id;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String dni;
	protected String pass;
	protected int tel;
	protected String email;
	

	/**
	 * Constructor sin parámetros de la clase User.
	 */
	public User() {}

	/**
	 * Constructor con parámetros de la clase User.
	 *
	 * @param id el id del usuario.
	 * @param nombre el nombre del usuario.
	 * @param apellido1 el primer apellido del usuario.
	 * @param apellido2 el segundo apellido del usuario.
	 * @param dni el DNI del usuario.
	 * @param pass la contraseña del usuario.
	 * @param tel el teléfono del usuario.
	 * @param email el correo electrónico del usuario.
	 */
	public User(int id, String nombre, String apellido1, String apellido2, String dni, String pass, int tel, String email) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.pass = pass;
		this.tel = tel;
		this.email = email;
	}
	
	/**
	 * Método getter para el id del usuario.
	 * @return el id del usuario.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método setter para el id del usuario.
	 * @param id el id del usuario.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método getter para el nombre del usuario.
	 * @return el nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método setter para el nombre del usuario.
	 * @param nombre el nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método getter para el primer apellido del usuario.
	 * @return el primer apellido del usuario.
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Método setter para el primer apellido del usuario.
	 * @param apellido1 el primer apellido del usuario.
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Método getter para el segundo apellido del usuario.
	 * @return el segundo apellido del usuario.
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Método setter para el segundo apellido del usuario.
	 * @param apellido2 el segundo apellido del usuario.
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Método getter para el DNI del usuario.
	 * @return el DNI del usuario.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Método setter para el DNI del usuario.
	 * @param dni el DNI del usuario.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Método getter para la contraseña del usuario.
	 * @return la contraseña del usuario.
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Método setter para la contraseña del usuario.
	 * @param pass la contraseña del usuario.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}



	/**
	 * Método getter para el telefono del usuario.
	 * @return el telefono del usuario.
	 */
	public int getTel() {
		return tel;
	}



	/**
	 * Método setter para el telefono del usuario.
	 * @param tel el telefono del usuario.
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}



	/**
	 * Método getter para el email del usuario.
	 * @return el email del usuario.
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * Método setter para el email del usuario.
	 * @param email el email del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	
	/**

	Función para mostrar las suscripciones de un inmueble.
	@param in El inmueble del que se quieren mostrar las suscripciones.
	*/
	public void mostrarSuscripciones(Inmueble in) {
		ControladorServicioSuscripcion.mostrarSuscripcionesUser(in);
	}
	
	/**

	Función para dar de alta un usuario en el sistema.
	@param usuario El usuario que se quiere dar de alta.
	@param isAdmin Un booleano que indica si el usuario es un administrador o no.
	*/
	public void alta(User usuario, boolean isAdmin) {}
	
	/**

	Función para dar de baja un usuario del sistema.
	@param usuario El usuario que se quiere dar de baja.
	*/
	public void baja(User usuario) {}
	
	/**

	Función para modificar un usuario del sistema.
	@param usuario El usuario que se quiere modificar.
	*/
	public void modificar(User usuario) {}
	
	/**

	Función para dar de alta un servicio de tarifa plana.
	@param servicio El servicio de tarifa plana que se quiere dar de alta.
	*/
	public void altaServicio(ServicioTarifaPlana servicio) {}
	
	/**

	Función para dar de baja un servicio de tarifa plana.
	@param servicio El servicio de tarifa plana que se quiere dar de baja.
	*/
	public void bajaServicio(ServicioTarifaPlana servicio) {}
	
	/**

	Función para modificar un servicio de tarifa plana.
	@param servicio El servicio de tarifa plana que se quiere modificar.
	*/
	public void modificarServicio(ServicioTarifaPlana servicio) {}
		
	/**

	Función para anular una suscripción de un usuario a un servicio.
	@param inmueble El inmueble del usuario.
	@param servicio El servicio que se quiere anular.
	*/
	public void anularSuscripcionUsuario(Inmueble inmueble, Servicios servicio) {}
	
	/**

	Función para establecer una suscripción de un usuario a un servicio.
	@param inmueble El inmueble del usuario.
	@param servicio El servicio que se quiere establecer.
	*/
	public void establecerSuscripcionUsuario(Inmueble inmueble, Servicios servicio) {}
	
	/**

	Función para dar de alta un gasto.
	@param gastos El gasto que se quiere dar de alta.
	*/
	public void altaGasto(Gasto gastos) {}

	/**

	Función para dar de baja un gasto.
	@param gastos El gasto que se quiere dar de baja.
	*/
	public void bajaGasto(Gasto gastos) {}
	
	/**

	Función para modificar un gasto.
	@param gastos El gasto que se quiere modificar.
	*/
	public void modificarGasto(Gasto gastos) {}
	
	/**

	Función para mostrar los gastos de un usuario.
	@return Un array de strings con la información de los gastos del usuario.
	*/
	public String[] mostrarGasto() {
		
		return ControladorGasto.mostrarGastoUser(this);
		
	}
	
	/**

	Función para mostrar los gastos de un usuario específico.
	@param usuario El usuario del que se quieren mostrar los gastos.
	@return Un array de strings con la información de los gastos del usuario.
	*/
	public String[] mostrarGasto(User usuario) {String[] a = null; return a;}
	
	

	/**
	 * Método representar en un string el objeto User.
	 * @return representacion de User.
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", primer apellido=" + apellido1 + ", segundo apellido=" + apellido2
				+ ", DNI=" + dni + ", password=" + pass + ", telefono=" + tel + ", email=" + email + "]";
	}
	

	
}
