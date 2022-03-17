package Libro_Teka;

public class Buscador {
	
	//atributos
	String claveBusqueda;
	String[] articulos; //cuando realizo la busqueda encuentra y devuelve varios articulos
	int cantidadResultados;
 	
	//constructor vacio
	public Buscador() {
		this.claveBusqueda="";
		articulos = new String[0]; //creo el vector vacio y luego lo remplazo por otro
		cantidadResultados=0;
	}
	
	public Buscador(String claveBusqueda) {
		
		this.claveBusqueda=claveBusqueda;
	}
	
	
	
	//metodos
	void buscar(){
		//otra clase me devuelve los articulos buscar(claveBusqueda) por ahora hardcode && rock 
		String[] resultados = new String[3]; //simulo que va a devovler 3 resultados
		resultados[0]= "Batman 1970";
		resultados[1]= "Batman 1980";
		resultados[2]= "Batman 1990";
		cantidadResultados = resultados.length;
	}
	

}
