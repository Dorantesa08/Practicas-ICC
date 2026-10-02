public class ProgramaNuevo{	
	public static void main(String[] args) {
	
	// Declarar variables
	String producto = "Laptop para la carrera";
	int precio = 15000;
	int descuento = 3000;
	double meses = 18.0;

	//Imprimir variables en consola, %s String, %d decimal integer para int, %f imprime 6 decimales para double 
	System.out.printf("El producto es %s\nEl precio es %d unidades\nEl descuento a hacer es %d unidades\nA meses es %.2f pesos\n" , producto, precio, descuento, meses);
	

	}
}