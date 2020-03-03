package MODEL;

public class Clientes {
	//ATRIBUTOS
	String dni;
	String nombre;
	String apellido;
	String fechaNacimiento;
	String email;
	String direccion;
	String municipio;
	String codigoPostal;
	String iban;
	
	public Clientes(String dni,	String nombre,	String apellido,String fechaNacimiento,	String email,String direccion,String municipio,	String codigoPostal,String iban) {
		this.dni = dni;
		this.nombre = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.direccion = direccion;
		this.municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.iban = iban;
	}

		//GETTER Y SETTERS
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
	//MAS FUNCIONES
	
	public void cambiarMetodoDePago(String iban) {
		
	}
	public void cambioDireccionVivienda(String direccion) {
		
	}
	
	
}
