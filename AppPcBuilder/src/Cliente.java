public class Cliente{
	
	//Atributos
	private int idCliente;
	private String nombre;
	private String apellidos;
	private String email;
	private String provincia;
	private int codigoPostal;
	private String municipio; 
	private String direccionEnvio;
	private String tipoDePago;
	
	//Constructor
	public Cliente(){
		
		
	}
	
	//Getters
	public int getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getEmail() {
		return email;
	}
	public String getProvincia() {
		return provincia;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public String getDireccionEnvio() {
		return direccionEnvio;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getTipoDePago() {
		return tipoDePago;
	}
	
	//setters
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}
	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}
	
	//funcions per separades
	public int crearUsuari(int idCliente) {
		return idCliente;
	}
	
}