package CLASSES;
public class LiniaPedido{
	
	//Atributs 
	int idLiniaPedido;
	String idPedido;
	int idOrdenador;
	int unidadesPedidas;
	int unidadesServidas;
	char estado;
	float precioUnidad;
	float precioTotalLinia;
	
	//Constructor
	public LiniaPedido(int idLiniaPedido,int idOrdenador, int unidadesPedidas,int unidadesServidas, float precioUnidad, char estado ) {
		this.idLiniaPedido=idLiniaPedido;
		this.idPedido = "1";
		this.idOrdenador = idOrdenador;
		this.unidadesPedidas = unidadesPedidas;
		this.unidadesServidas = unidadesServidas;
		this.precioUnidad = precioUnidad;
		this.estado='0';
		this.precioTotalLinia = unidadesPedidas*precioUnidad;
	}
	
	
	public int getIdLiniaPedido() {
		return idLiniaPedido;
	}


	public void setIdLiniaPedido(int idLiniaPedido) {
		this.idLiniaPedido = idLiniaPedido;
	}


	public String getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(String idPedido) {
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
	public char getEstado() {
		return estado;
	}
	//Setters
	public void setEstado(char estado) {
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
		return "\nLiniaPedido [idLiniaPedido=" + idLiniaPedido + ", idPedido=" + idPedido + ", idOrdenador=" + idOrdenador
				+ ", unidadesPedidas=" + unidadesPedidas + ", unidadesServidas=" + unidadesServidas + ", estado="
				+ estado + ", precioUnidad=" + precioUnidad + ", precioTotalLinia=" + precioTotalLinia + "]";
	}


	
	


	


	
	
	
}