
package MODEL;
public class OF{
	
	//Atributs
	int idOF;
	String idPedido;
	String idLiniaPedido;
	int unidades;
	char estado;
	
	//Constructor
	public OF(int idOF, String idPedido, String idLiniaPedido, int unidades, char estado) {
		this.idOF = idOF;
		this.idPedido = idPedido;
		this.idLiniaPedido = idLiniaPedido;
		this.unidades = unidades;
		this.estado = estado;
	}
	//Getter
	public char getEstado() {
		return estado;
	}
	
	//Setter
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	//Mas funciones
	public void canvioEstadoOF(char estado) {
	}
}