package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenCardPage;
import Pages.SignInPage;

public class OpenCardTest extends TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void fundTransfer(String No, String transferType, String debitAccount, String debitCurrency, 
			String debitAmount, String creditAccount, String creditCurrency, String orderBank) 
	{	
		
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenCardPage.cardPrincipalVersion(),OpenCardPage.cardPrincipalTitle());
		
		Log.info(driver.getTitle());
		
		OpenCardPage.btnNew(driver).click();
		String al = OpenCardPage.txtAl(driver).getAttribute("value");
		clearAndType(OpenCardPage.txtAtmAccountDefault(driver), transferType);
		clearAndType(OpenCardPage.txtCustomerDefault(driver), debitCurrency+"14033");
		clearAndType(OpenCardPage.txtCustomer(driver), debitCurrency);
		clearAndType(OpenCardPage.txtEmail(driver), debitAmount);
		clearAndType(OpenCardPage.txtEmbrossingName(driver), creditAccount);
		clearAndType(OpenCardPage.txtCompanyName(driver), creditCurrency);
		clearAndType(OpenCardPage.txtSecurityQuestion(driver), orderBank);
		OpenCardPage.btnCommit(driver).click();
		
		if(OpenCardPage.lblOverride(driver)!=null)
			OpenCardPage.lblOverride(driver).click();

		Log.info(al);
		updateResult("fundtransfer", al, Integer.parseInt(No), 0);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
