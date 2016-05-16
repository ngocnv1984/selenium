package Testcases;

import java.util.Iterator;
import java.util.Set;

import Base.TestBase;
import Base.DataProviderSource;
import Base.Log;
import Pages.SignInPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {
	
	Set<String> windowId;
    Iterator<String> itererator;   
    String mainWinID, newAdwinID;
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void signIn(String user, String pwd) 
	{		
		driver.get(SignInPage.t24Link());
		clearAndType(SignInPage.txt_UserName(driver),user);
		clearAndType(SignInPage.txt_Password(driver),pwd);
		SignInPage.btn_SignIn(driver).click();
	}
	
	public void signIn(WebDriver driver, String user, String pwd) 
	{		
		this.driver = driver;
		driver.get(SignInPage.t24Link());
		clearAndType(SignInPage.txt_UserName(driver),user);
		clearAndType(SignInPage.txt_Password(driver),pwd);
		SignInPage.btn_SignIn(driver).click();
	}
	
	public void navigateToVersion(String version, String title)
	{
		driver.switchTo().frame(0);			
		clearAndType(SignInPage.txt_CommandLine(driver),version);
		Log.info("Input txt_CommandLine");
		SignInPage.btn_CommandImage(driver).click();
		Log.info("Click btn_CommandImage");
		switchChildId(title);
	}
	
	public void switchChildId(String title)
	{
		Log.info("Switch to ChildID");
		windowId = driver.getWindowHandles();
	    itererator = windowId.iterator();
		mainWinID = itererator.next();
		
		while(!driver.getTitle().equals(title))
		{
			newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
		}
		
		driver.manage().window().maximize();
		Log.info("Switch to "+driver.getTitle());
	}
	
	public void switchMainId()
	{
		driver.close();
		driver.switchTo().window(mainWinID);
		Log.info("Switch to mainWinID");
	}
}
