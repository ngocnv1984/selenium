package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class GetBankDatePage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/GetBankDateRepo.properties"));
    
	public static String bankDateVersion()
	{
		inputValue = map.getValue("BANK_DATE_VERSION");
		return inputValue;
	}
	
	public static String bankDateTitle()
	{
		inputValue = map.getValue("BANK_DATE_TITLE");
		return inputValue;
	}
	
	////////////// GET OBJECT /////////////////////	
	public static WebElement btnView(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_VIEW"));
        return element;
	}
	
	public static WebElement txtBankId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_BANK_ID"));
        return element;
	}
	
	public static WebElement lblToday(WebDriver driver)
    {
		element = driver.findElement(map.getObject("LBL_TODAY"));
        return element;
	}
}