package clase16;

public class XLSFServiceParser implements FileService {

	private IParser<XSL> parser; 
	
	public XLSFServiceParser(String file) {
		this.parser = new XSLFileParser(file);
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
