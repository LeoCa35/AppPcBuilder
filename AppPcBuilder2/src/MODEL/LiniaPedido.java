package MODEL;
import MODEL.Pedido;

public class LiniaPedido{
	
	//Atributs 
	int idLinia;
	int idPedido;
	int idOrdenador;
	int unidadesPedidas;
	int unidadesServidas;
	String estado;
	
	//Constructor
	public LiniaPedido(int idLinia, int idPedido,int idOrdenador, int unidadesPedidas,int unidadesServidas, String estado ) {
		this.idLinia=idLinia;
		this.idPedido = idPedido;
		this.idOrdenador = idOrdenador;
		this.unidadesPedidas = unidadesPedidas;
		this.unidadesServidas = unidadesServidas;
		this.estado=estado;
		//this.precioTotalLinia = unidadesPedidas*precioUnidad;
	}
	//Constructor
	/*public LiniaPedido(int idOrdenador, int unidadesPedidas,int unidadesServidas, String estado ) {
		
		this.idOrdenador = idOrdenador;
		this.unidadesPedidas = unidadesPedidas;
		this.unidadesServidas = unidadesServidas;
		this.estado=estado;
	}*/
	
	
	public int getIdLinia() {
		return idLinia;
	}


	public void setIdLinia(int idLinia) {
		this.idLinia = idLinia;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getIdOrdenador() {
		return idOrdenador;
	}


	public void setIdOrdenador(int idOrdenador) {
		this.idOrdenador = idOrdenador;
	}


	public int getUnidadesPedidas() {
		return unidadesPedidas;
	}


	public void setUnidadesPedidas(int unidadesPedidas) {
		this.unidadesPedidas = unidadesPedidas;
	}


	public int getUnidadesServidas() {
		return unidadesServidas;
	}


	public void setUnidadesServidas(int unidadesServidas) {
		this.unidadesServidas = unidadesServidas;
	}


	//Getters
	public String getEstado() {
		return estado;
	}
	//Setters
	public void setEstado(String estado) {
		this.estado = estado;
	}
	//Mas Funciones
	public void comprovarStock(int idOrdenador) {
		boolean comprovarStock = true;
		//return comprovarStock;
	}
	public void comprovarStockComponentes(int idOrdenador) {
		boolean comprovatStock = true;
		//return comprovatStock;
	} 
	public void canvioEstadoLiniaPedido(char estado) {
		
	}
	public void lanzarOF(boolean comprovarStock, boolean comprovarStockComponentes) {
		boolean lanzarOF = false;
		if(comprovarStock == true && comprovarStockComponentes == true) {
			//OF of1 = new OF(idLiniaPedido, idLiniaPedido, idLiniaPedido, idLiniaPedido, estado);
		}
	}


	@Override
	public String toString() {
		return "\nLiniaPedido [idLinia=" + idLinia + ", idPedido=" + idPedido + ", idOrdenador=" + idOrdenador
				+ ", unidadesPedidas=" + unidadesPedidas + ", unidadesServidas=" + unidadesServidas + ", estado="
				+ estado + "]";
	}


	
	


	


	
	
	
}