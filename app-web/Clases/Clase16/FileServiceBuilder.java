package clase16;

public class FileServiceBuilder {

	private String archivo;
	
	public FileServiceBuilder(String fileName) {
		//validaciones
		if(fileName != null) {
			this.archivo = fileName;
		}else {
			fileName = "";
		}
	}
	
	public FileService buildService(String fileContent) {
		
		String[] nombreArr = archivo.split("\\.");
		
		FileService fs;
		switch (nombreArr[1]) {
			case "csv":
				fs = new CSVFServiceParser(fileContent);
				break;
			case "xls":
				fs = new XLSFServiceParser(fileContent);
				break;
		default:
			fs = null;
			break;
		}
		
		return fs;
	}

}
