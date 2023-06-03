package usuario;

/**
 * Esta es una clase que representa el objeto Vecino.
 * Proporciona varios métodos para interactuar con el objeto. Hereda de User
 * @author Ismael
 * @version 1.0
 */

public class Vecino extends User {

	public Vecino() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vecino(int id, String nombre, String apellido1, String apellido2, String dni, String pass, int tel,String email) 
	{
		super(id, nombre, apellido1, apellido2, dni, pass, tel, email);
	}

	
}
