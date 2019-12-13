package MODEL;
import java.util.ArrayList;
import java.util.Date;
public class Pedido{
	
	//Atributos
	int idPedido;
	String idCliente;
	float precio;
	Date fechaAbertura;
	Date fechaFinalizacion;
	char estado;
	boolean pagoAceptado;
	ArrayList <LiniaPedido> liniaspedido = new ArrayList<LiniaPedido>();
	public ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
	
	//Constructor
	public Pedido(int idPedido,String idCliente, char estado ,ArrayList <LiniaPedido> liniaspedido) {	
		
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaAbertura = new Date();
		this.estado = estado;
		this.liniaspedido = liniaspedido;
		
		
	}
	
	//Constructor
	public Pedido(String idCliente, char estado, ArrayList<LiniaPedido> liniaspedido) {

		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaAbertura = new Date();
		this.estado = estado;
		this.liniaspedido = liniaspedido;

	}
	
	public Pedido(ArrayList<Pedido> pedidos) {
		// TODO Auto-generated constructor stub
	}

	//Getters
	
	/*
	public ArrayList<LiniaPedido> getLiniaspedido() {
		return liniaspedido;
	}*/
	
	public float getPrecio() {
		for (LiniaPedido liniaspedido  : liniaspedido) {
			precio += liniaspedido.precioTotalLinia;
		}
		return precio;
	}
	

	


	public Date getFechaAbertura() {
		return fechaAbertura;
	}

	public void setFechaAbertura(Date fechaAbertura) {
		this.fechaAbertura = fechaAbertura;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
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

	public int getIdPedido() {
		return idPedido;
	}

	public char getEstado() {
		return estado;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	//Setters

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	//Mas funciones
	
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
		return "\nPedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precio=" + getPrecio() + ", fechaAbertura="
				+ fechaAbertura + ", fechaFinalizacion=" + fechaFinalizacion + ", estado=" + estado + ", liniaspedido=" + liniaspedido + "]";
	}
	/*
	 * @Override
	public String toString() {
		return "\nComanda [idComanda=" + idComanda + ", idClient=" + idClient + ", preu=" + getPreu() + ", dataObertura="
				+ dataObertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status  + ", liniaComanda=" + liniaComanda + "]\n";
	}*/

	
	


	


	


	



	



	
	
	
}