package MODEL;
public class Cliente{
	
	//Atributos
	String idCliente;
	String cliente;
	String email;
	String provincia;
	String direccion;
	String cp;
	String telefono;
	String municipio;
	String direccionEnvio;
	String tipoDePago;
	String iban;
	String deudor;
	
	
	//Constructor
	public Cliente(String idCliente ,String cliente, String email,String telefono, String direccion, String municipio, String provincia,String cp,String iban) { 

		this.idCliente = idCliente;
		this.cliente = cliente;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.municipio = municipio;
		this.provincia = provincia;
		this.deudor = deudor;
		this.iban = iban;
		this.cp = cp;
	}
	
	
	//Getters i setters
	
	

	
	




	//Mas funciones
	public String crearUsuario(String idCliente) {
		return this.idCliente = idCliente;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getDireccionEnvio() {
		return direccionEnvio;
	}


	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}


	public String getTipoDePago() {
		return tipoDePago;
	}


	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}


	public String getIban() {
		return iban;
	}


	public void setIban(String iban) {
		this.iban = iban;
	}


	public String getDeudor() {
		return deudor;
	}


	public void setDeudor(String deudor) {
		this.deudor = deudor;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", cliente=" + cliente + ", email=" + email + ", provincia="
				+ provincia + ", direccion=" + direccion + ", cp=" + cp + ", telefono=" + telefono + ", municipio="
				+ municipio + ", iban=" + iban + ", deudor=" + deudor + "]";
	}


	}