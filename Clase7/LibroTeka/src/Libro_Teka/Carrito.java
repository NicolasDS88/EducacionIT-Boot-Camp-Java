package Libro_Teka;

public class Carrito {

	Item[] items = new Item[0];

	Carrito() {
		this.items = new Item[0];
	}

	void agregarAlCarrito(Articulo art) {
		// nuevo consturctor de item
		Item cantArticulo = new Item(art, 1);

		Item[] nuevoItems = new Item[this.items.length + 1];
		// copiar los items del viejo al nuevo
		// nuevoItems=this.items; //copio los articulos pre existentes PERO NO ASI
		// tira error por q no lo puedo poner en la ultima pos cuando esta vacio [0] [1]
		for (int i = 0; i < items.length; i++) {
			nuevoItems[i] = items[i];
		}

		nuevoItems[nuevoItems.length - 1] = cantArticulo; // agrego otro articulo a la ultima pos

		this.items = nuevoItems;
	}

	void seguirComprando() {

		System.out.println("Seguimos comprando");
	}

	void limpiar() {
		// creo un nuevo espacio de memoria a donde apunta la nueva lista
		this.items = new Item[0];
	}

	void actualizar(Item[] itemsActualziados) {
		// modifica la cantidad de items que recibe
		this.items = itemsActualziados;
	}

	// item tiene dentro de si un articulo en su clase
	Double obtenerPrecio() {
		Double precioFinal = 0d;
		for (Item item : items) {
			precioFinal += item.articulo.precio;
		}
		return precioFinal;

	}

	void eliminarItem(Item itemEliminar) {
		for (Item item : this.items) {
			if (existeItem(itemEliminar.articulo.IDproducto)) {
				copiarItems(itemEliminar);
			}
		}
	}

	// a completar: crear una lista nueva sin el elemento pasado por parametro

	void copiarItems(Item noCopiar) {
		Item[] nuevaLista = new Item[this.items.length - 1];

		for (Item item : this.items) {
			int i = 0;
			if (!item.equals(noCopiar)) {
				nuevaLista[i] = item;
				i++;
			}
		}
		this.items = nuevaLista;
	}

	boolean existeItem(int idItem) {
		boolean valor = false;
		for (Item item : this.items) {
			if (item.articulo.IDproducto == idItem) {
				valor = true;
				break;
			}

		}
		return valor;
	}

	int obtenerCantItems() {
		return this.items.length;

	}

	
	  void detalle() {
		  System.out.println("----------------------------Contenido Carrito--------------------------");
		// mostrar los resultados
		// foreach para cada TIPO de elemento "en este caso Articulo es String" que
		// quiero mostrar
		for (Item articuloMostrar : this.items) {
			Item unArticulo=articuloMostrar;
			
			System.out.println(unArticulo.articulo.IDproducto);
			System.out.println(unArticulo.articulo.autor);
			System.out.println(unArticulo.articulo.precio);
			
		}
//			for (int i = 0; i < nuevaBusqueda.cantidadResultados; i++) {
//				System.out.println(nuevaBusqueda.articulos[i]);
//			}
		System.out.println("Hay "+obtenerCantItems()+" items en el carrito");
		System.out.println("Precio final es: "+obtenerPrecio());
	}
	
}
