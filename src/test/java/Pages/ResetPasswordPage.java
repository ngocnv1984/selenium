package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class ResetPasswordPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/ResetPasswordRepo.properties"));
    
	public static String resetPasswordVersion()
	{
		inputValue = map.getValue("RESET_PASSWORD_VERSION");
		return inputValue;
	}
	
	public static String resetPasswordTitle()
	{
		inputValue = map.getValue("RESET_PASSWORD_TITLE");
		return inputValue;
	}
	
	////////////// GET OBJECT /////////////////////	
	public static WebElement btnEdit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_EDIT"));
        return element;
	}
	
	public static WebElement txtId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ID"));
        return element;
	}
	
	public static WebElement txtUserTest(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_USER_RESET"));
        return element;
	}

	public static WebElement txtUserPassword(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_USER_PASSWORD"));
        return element;
	}
	
	public static WebElement rbtUserType(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_USER_TYPE"));
        return element;
	}
	
	public static WebElement btnCommit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_COMMIT"));
        return element;
	}
	
	public static WebElement txtOldPassword(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_OLD_PASSWORD"));
        return element;
	}

	public static WebElement txtPassword(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_PASSWORD"));
        return element;
	}
	
	public static WebElement btnGo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_GO"));
        return element;
	}
}