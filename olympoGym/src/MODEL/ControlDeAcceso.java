package MODEL;

public class ControlDeAcceso {

	//ATRIBUTOS
	
	int idAcceso;
	int tiempoTotal;
	
	public ControlDeAcceso(int idAcceso, int tiempoTotal) {
		this.idAcceso = idAcceso;
		this.tiempoTotal = tiempoTotal;
	}

	//GETTERS Y SETTERS
	public int getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(int idAcceso) {
		this.idAcceso = idAcceso;
	}

	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
	
	public int checkHours() {
		return tiempoTotal;
	}
	
	
}
