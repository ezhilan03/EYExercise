package components;

public interface XMLToExcelConvertable{
	public void createFile(String sheetName)throws Exception;
	public void writeData(String fileName)throws Exception;
}

