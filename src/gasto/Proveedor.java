package gasto;

import java.util.List;


/**
 * Esta es una clase que representa el objeto Proveedor.
 * Proporciona varios métodos para interactuar con el objeto.
 * @author Ismael
 * @version 1.0
 */
public class Proveedor {
	
	private String nombre;
	private int tel;
	private String email;
	private String direccion;
	
	/**

	Constructor que recibe como parámetros el nombre, teléfono, correo electrónico y dirección del proveedor.
	@param nombre el nombre del proveedor.
	@param tel el número de teléfono del proveedor.
	@param email la dirección de correo electrónico del proveedor.
	@param direccion la dirección física del proveedor.
	*/
	public Proveedor(String nombre, int tel, String email, String direccion) {
	super();
	this.nombre = nombre;
	this.tel = tel;
	this.email = email;
	this.direccion = direccion;
	}
	/**

	Devuelve el nombre del proveedor.
	@return el nombre del proveedor.
	*/
	public String getNombre() {
	return nombre;
	}
	/**

	Modifica el nombre del proveedor.
	@param nombre el nuevo nombre del proveedor.
	*/
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	/**

	Devuelve el número de teléfono del proveedor.
	@return el número de teléfono del proveedor.
	*/
	public int getTel() {
	return tel;
	}
	/**

	Modifica el número de teléfono del proveedor.
	@param tel el nuevo número de teléfono del proveedor.
	*/
	public void setTel(int tel) {
	this.tel = tel;
	}
	/**

	Devuelve la dirección de correo electrónico del proveedor.
	@return la dirección de correo electrónico del proveedor.
	*/
	public String getEmail() {
	return email;
	}
	/**

	Modifica la dirección de correo electrónico del proveedor.
	@param email la nueva dirección de correo electrónico del proveedor.
	*/
	public void setEmail(String email) {
	this.email = email;
	}
	/**

	Devuelve la dirección física del proveedor.
	@return la dirección física del proveedor.
	*/
	public String getDireccion() {
	return direccion;
	}
	/**

	Modifica la dirección física del proveedor.
	@param direccion la nueva dirección física del proveedor.
	*/
	public void setDireccion(String direccion) {
	this.direccion = direccion;
	}
	}