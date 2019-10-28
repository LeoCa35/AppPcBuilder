package CLASSES;
import java.util.ArrayList;
import java.util.Date;
public class Pedido{
	
	//Atributos
	String idPedido;
	String idCliente;
	float precio;
	Date fechaAbertura;
	Date fechaFinalizacion;
	char estado;
	boolean pagoAceptado;
	ArrayList <LiniaPedido> liniaspedido = new ArrayList<LiniaPedido>();
	
	
	//Constructor
	public Pedido(String idCliente, ArrayList <LiniaPedido> liniaspedido, char estado) {
		this.idPedido = "1";
		this.idCliente = idCliente;
		this.estado = estado;
		this.liniaspedido = liniaspedido;
		this.precio = precio;
	}
	
	
	//Getters
	public char getEstado() {
		return estado;
	}
	public String getIdPedido() {
		return idPedido;
	}
	public boolean isPagoAceptado() {
		return pagoAceptado;
	}

	public ArrayList<LiniaPedido> getLiniaspedido() {
		return liniaspedido;
	}
	
	public float getPrecio() {
		for (LiniaPedido liniaspedido  : liniaspedido) {
			precio += liniaspedido.precioTotalLinia;
		}
		return precio;
	}
	

	//Setters
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
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
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precio=" + getPrecio() + ", fechaAbertura="
				+ fechaAbertura + ", fechaFinalizacion=" + fechaFinalizacion + ", estado=" + estado + ", pagoAceptado="
				+ pagoAceptado + "]";
	}


	


	



	



	
	
	
}