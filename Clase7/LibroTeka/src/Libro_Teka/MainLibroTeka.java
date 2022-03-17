package Libro_Teka;

public class MainLibroTeka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String claveBusquedaUsuario = "batman"; // meterianos una clase escaner hard code baby

		// comienza la busqueda / instanciar el objeto buscador y ejecutar el metodo
		Buscador nuevaBusqueda = new Buscador(claveBusquedaUsuario); // correctamente
		// nuevaBusqueda.claveBusqueda=claveBusquedaUsuario;//hardcode

		nuevaBusqueda.buscar(); // F3 para ir al metodo

		// mostrar cantida
		nuevaBusqueda.mostrarCantidadResultados();

		// verificar que tenga resultados
		if (nuevaBusqueda.hayResultados()) {
			// alt+shift+m extraer un metodo
			nuevaBusqueda.detalle();
		}

		// agregamos los articulos impares al carrito
		// para eros creo 1 carrito primero

		Carrito carrito = new Carrito();

		if (nuevaBusqueda.hayResultados()) {
			for (int i = 0; i < nuevaBusqueda.articulos.length; i++) {
				//if (i % 2 != 0) {
					System.out.println("Se agrego '"+ nuevaBusqueda.articulos[i].nombre+ "' al carrito");
					carrito.agregarAlCarrito(nuevaBusqueda.articulos[i]);    
				//}
			}
		}
				
		
		carrito.detalle();
		//carrito.eliminarItem(Articulo.);
		

	}

}
