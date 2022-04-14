package clase16;

public class CSVFServiceParser implements FileService{

	private IParser<CSV> parser;
	
	public CSVFServiceParser(String file) {
		this.parser = new CSVFileParser(file);
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
