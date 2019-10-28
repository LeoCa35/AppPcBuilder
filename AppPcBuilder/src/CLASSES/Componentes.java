package CLASSES;
public class Componentes{
	
	//Atributos
	int idComponente;
	String tipo;
	String descripcion;
	double precio;
	
	//Constructor
	public Componentes(int idComponente) {
		this.idComponente = idComponente;
	}
	
	public double actualizacionPrecio(int precio) {
		return this.precio = precio*0.05;
	}
	public void addComponente(int idComponente,String tipo,String descripcion,double precio) {
		
	}
	public void delComponente(int idComponente) {
		
	}
	
}