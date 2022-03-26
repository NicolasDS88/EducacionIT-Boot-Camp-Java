package Libro_Teka;

public class Buscador {

	// atributos
	String claveBusqueda;
	Articulo[] articulos; // cuando realizo la busqueda encuentra y devuelve varios articulos
	int cantidadResultados;

	// constructor vacio
	public Buscador() {
		this.claveBusqueda = "";
		articulos = new Articulo[0]; // creo el vector vacio y luego lo remplazo por otro
		cantidadResultados = 0;
	}

	public Buscador(String claveBusqueda) {

		this.claveBusqueda = claveBusqueda;
	}

	// metodos
	void buscar() {
		// otra clase me devuelve los articulos buscar(claveBusqueda) por ahora hardcode
		// && rock
		Articulo[] resultados = new Articulo[3]; // simulo que va a devovler 3 resultados

		// al cambiar de un objeto String de 1 solor valor a un objeto de tipo articulo
		// de muchos campos
		// antes era resultado[0]="nombre comic"; ahora es...
		resultados[0] = new Articulo(100001, "Batman 1970", "DC Comics", 1200.58d, "www.com.ar");
		resultados[1] = new Articulo(100002, "Batman 1980", "DC Comics", 1500.58d, "www.com.ar");
		resultados[2] = new Articulo(100003, "Batman 1990", "DC Comics", 1800.58d, "www.com.ar");
		this.articulos = resultados; // apunto a la direccion de memoria de resultados
		cantidadResultados = resultados.length;
	}

	// mostrar cantidad resultados
	public void mostrarCantidadResultados() {
		System.out.println("Se encontraron = " + this.cantidadResultados + " resultados para '" + this.claveBusqueda + "'");
	}
	
	  void detalle() {
		// mostrar los resultados
		// foreach para cada TIPO de elemento "en este caso Articulo es String" que
		// quiero mostrar
		for (Articulo articuloMostrar : this.articulos) {
			Articulo unArticulo=articuloMostrar;
			
			System.out.println(unArticulo.autor);
			System.out.println(unArticulo.nombre);
			if (unArticulo.tieneImagen()) {
				System.out.println(unArticulo.urlImg);
			}else {
				System.out.println("no tiene imagen, marcade agua");
			}
		}
//			for (int i = 0; i < nuevaBusqueda.cantidadResultados; i++) {
//				System.out.println(nuevaBusqueda.articulos[i]);
//			}
	}

	public boolean hayResultados() {
		
		return this.cantidadResultados > 0;
	}
}
