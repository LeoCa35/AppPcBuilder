package CLASSES;
public class Proveedor{
	
	//Atributos
	int idProveedor;
	int Precio;
	int telefono;
	String direccion;
	String nombreEmpresa;
	char tipo;
	
	//Consrtuctor
	public Proveedor(int idProveedor, int precio, char tipo){
		this.idProveedor = idProveedor;
		this.Precio = precio;
		this.tipo = tipo;
	}
	
	public void reestockComponentes(int idComponente, int unidades) {
		
	}
	public void devolucionComponentes(int idComponente, int unidades) {
		
	}
}