public class Programa{	
	public static void main(String[] args) {
	
	// Declarar variables
	String producto = "Laptop para la carrera";
	int precio = 15000;
	int descuento = 3000;
	double meses = 18.0;

	//Imprimir variables en consola
	System.out.println("=== Ficha de compra ===");
	System.out.println("- Producto : " + producto);	
	System.out.println("- Precio con descuento : " + (precio - descuento));
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
	System.out.println("=== Fin de la ficha ===");

	}
}