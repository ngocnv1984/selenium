package Base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {

	Properties properties;
	
	public ObjectMap(String mapFile)
	{
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(mapFile);
			properties.load(in);
			in.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public By getObject(String logicalElementName)
	{
		//Read value using the logical name as Key
		String locator = properties.getProperty(logicalElementName);
		
		//Split the value which contains locator type and locator value
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		
		By myObject = null;

		switch(locatorType.toLowerCase()) 
		{
		    case "id":
		    	myObject = By.id(locatorValue);
		        break;
		    case "name":
		    	myObject = By.name(locatorValue);
		        break;
		    case "class":
		    	myObject = By.className(locatorValue);
		        break;
		    case "link":
		    	myObject = By.linkText(locatorValue);
		        break;
		    case "partial":
		    	myObject = By.partialLinkText(locatorValue);
		        break;
		    case "css":
		    	myObject = By.cssSelector(locatorValue);
		        break;
		    case "xpath":
		    	myObject = By.xpath(locatorValue);
		        break;
		    default:
				myObject = By.id(locatorValue);
		}

		return myObject;
	}
	
	public String getValue(String objectName) 
	{
		return properties.getProperty(objectName).toString();
	}
}
