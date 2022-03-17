package Libro_Teka;

public class Articulo {
	
	String nombre;
	String autor;
	Double precio;
	String urlImg;
	int IDproducto;
	
	//alt+shift+s para crear el constructor y sino Source generat constructor
	public Articulo(int IDproducto, String nombre, String autor, Double precio, String urlImg) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
		this.urlImg = urlImg;
		this.IDproducto=IDproducto;
	}
	
	
	boolean tieneImagen() {		
		//chequear la logica cont+shit+i
		return this.urlImg!=""&&this.urlImg!=null;
				
	}
	

	
	
	
	
	
	
}
