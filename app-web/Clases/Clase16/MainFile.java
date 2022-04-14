package clase16;

public class MainFile {

	public static void main(String[] args) {
		String archivo = "notas.csv";
		
		String contenidoDeArchivo = "nombre;apellido;nota";

		FileServiceBuilder fsb = new FileServiceBuilder(archivo);
		
		FileService service = fsb.buildService(contenidoDeArchivo);
		
		service.save();
		
		service.validate();
	}

}
