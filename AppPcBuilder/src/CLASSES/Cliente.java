package CLASSES;
public class Cliente{
	
	//Atributos
	int idCliente;
	String nombre;
	String apellidos;
	String email;
	String provincia;
	int codigoPostal;
	String Municipio;
	String direccionEnvio;
	String tipoDePago;
	
	//Constructor
	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	//Getters
	public int getIdCliente() {
		return idCliente;
	}
	
	//Setters
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	//Mas funciones
	public int crearUsuario(int idCliente) {
		return this.idCliente = idCliente;
	}
}