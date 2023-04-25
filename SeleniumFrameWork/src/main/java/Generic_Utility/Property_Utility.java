package Generic_Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility
{
	/**
	 *  //thisn file is used to launch the browser
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Vinay
	 */
	public String getKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
