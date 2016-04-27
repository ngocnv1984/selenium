package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class CreateUserPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/CreateUserRepo.properties"));
    
	public static String createUserVersion()
	{
		inputValue = map.getValue("CREATE_USER_VERSION");
		return inputValue;
	}
	
	public static String createUserTitle()
	{
		inputValue = map.getValue("CREATE_USER_TITLE");
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
	
	public static WebElement ddlOption(WebDriver driver)
    {
		element = driver.findElement(map.getObject("DDL_OPTION"));
        return element;
	}
	
	public static WebElement txtUsername(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_USERNAME"));
        return element;
	}
	
	public static WebElement txtSignOnName(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_SIGN_ON_NAME"));
        return element;
	}

	public static WebElement txtStartDateProfile(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_START_DATE_PROFILE"));
        return element;
	}
	
	public static WebElement btnCommit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_COMMIT"));
        return element;
	}
}