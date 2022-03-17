package Libro_Teka;

public class MainLibroTeka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String claveBusquedaUsuario="batman"; //meterianos una clase escaner hard code baby
		
		
		//comienza la busqueda / instanciar el objeto buscador y ejecutar el metodo
		Buscador nuevaBusqueda = new Buscador(claveBusquedaUsuario); //correctamente
		//nuevaBusqueda.claveBusqueda=claveBusquedaUsuario;//hardcode
		
		
		nuevaBusqueda.buscar();
		
		
		//verificar que tenga resultados
		if(nuevaBusqueda.cantidadResultados >0) {
			//mostrar los resultados
			// foreach para cada TIPO de elemento que quiero mostrar
			for (String articuloMostrar : nuevaBusqueda.articulos) {
				System.out.println(articuloMostrar);
			}
			for (int i = 0; i < nuevaBusqueda.cantidadResultados; i++) {
				System.out.println(nuevaBusqueda.articulos[i]);
			}
			
		}
		
	}

}
