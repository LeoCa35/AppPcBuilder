package MODEL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Pedido{
	
	//Atributos
	int idPedido;
	String idCliente;
	float precio;
	String fechaApertura;
	String fechaFinalizacion;
	String  estado;
	SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
	boolean pagoAceptado;
	ArrayList <LiniaPedido> liniaspedido = new ArrayList<LiniaPedido>();
	public ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
	
	//Constructor
	
	public Pedido(int idPedido,String idCliente, String fechaApertura, String fechaFinalizacion,String estado ,int precio) {	
		
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaApertura = fechaApertura;
		this.fechaFinalizacion = fechaFinalizacion;
		this.estado = estado;
		this.precio = precio;
		
		
	}
	
	//Constructor
	public Pedido(int idPedido,String idCliente, String estado ) {	
		
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaApertura = fecha.format(new Date());
		this.fechaFinalizacion = null;
		this.estado = estado;

		
		
		
	}
	
	//Constructor
	/*public Pedido(String idCliente, char estado, ArrayList<LiniaPedido> liniaspedido) {

		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaAbertura = new Date();
		this.estado = estado;
		this.liniaspedido = liniaspedido;

	}*/
	
	
	
	//Mas funciones
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(String fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isPagoAceptado() {
		return pagoAceptado;
	}

	public void setPagoAceptado(boolean pagoAceptado) {
		this.pagoAceptado = pagoAceptado;
	}

	public ArrayList<LiniaPedido> getLiniaspedido() {
		return liniaspedido;
	}

	public void setLiniaspedido(ArrayList<LiniaPedido> liniaspedido) {
		this.liniaspedido = liniaspedido;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void consultaEstadoPedido(int idPedido) {
		//return this.estado;
	}
	public void cambiarEstadoPedido(int idPedido) {
		//return this.estado = estado;
	}
	public void calcularPreu() {
		
	}
	
	public Boolean pagoAceptado() {
		boolean pagoAceptado = true;
		if(pagoAceptado) {
			System.out.println("Todo correcto");
			return true;
		}else {
			System.out.println("Se cancela el proceso");
			return false;
		}
	}

	@Override
	public String toString() {
		return "\nPedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precio=" + getPrecio() + ", fechaApertura="
				+ fechaApertura + ", fechaFinalizacion=" + fechaFinalizacion + ", estado=" + estado +  "]";
	}
	/*
	 * @Override
	public String toString() {
		return "\nComanda [idComanda=" + idComanda + ", idClient=" + idClient + ", preu=" + getPreu() + ", dataObertura="
				+ dataObertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status  + ", liniaComanda=" + liniaComanda + "]\n";
	}*/

	
	


	


	


	



	



	
	
	
}