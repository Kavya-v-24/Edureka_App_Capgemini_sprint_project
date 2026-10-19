package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonDataFromPropertyFile {
	
	public String getCommonData(String data) throws IOException
	{
	FileInputStream fis=new FileInputStream("./src/main/resources/Edureka_Data/Common_Data.properties");
	Properties p=new Properties();
	p.load(fis);
	return p.getProperty(data);
	}

}
