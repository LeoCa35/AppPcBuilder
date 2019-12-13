package MODEL;
public class MovimientosAlmacen{
	
	//Atributos
	int idMovimientoAlmacen;
	int idComponente;
	int idOrdenador;
	int idAlmacen;
	char tipoMovimiento;
	int unidades;
	int posX;
	int posY;
	int posZ;
	
	//Constructor
	public MovimientosAlmacen(int idComponente, int idOrdenador){
		this.idComponente = idComponente;
		this.idOrdenador = idOrdenador;
	}
	public void getUbicacio() {
		
	}
	public void setUbicacio(int posX, int posY, int posZ) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
	}
	public int calculoUnidadesComponetes(int idComponente) {
		return unidades;
	}
	public int calculoUnidadesOrdenador(int idOrdenador) {
		return unidades;
	} 
	
}