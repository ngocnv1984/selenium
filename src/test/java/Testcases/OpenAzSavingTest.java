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
import Pages.OpenAzSavingPage;
import Pages.SignInPage;

public class OpenAzSavingTest extends TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		Log.info("\n");
		Log.info("-------------------- -------------------- --------------------");
		Log.info("---------------- T24 SYSTEM AUTOMATION TESTING ---------------");
		Log.info("-------------------- -------------------- --------------------\n");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void openSavingAccount(String customerNo, String depositType, String currency, String depositProduct, String amount, String valueDate, 
			String maturityDate, String term, String debitAccount, String nominatedAccount, String interestRate, String dao, String mobilePhone, 
			String nrProgram, String nrDate, String nrRate, String nrAmount, String nrAccount) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAzSavingPage.baseVersion(),OpenAzSavingPage.baseTitle());
		
		Log.info(driver.getTitle());
		
		OpenAzSavingPage.btnNew(driver).click();
		Log.info("Click btnNew");
		
		String account = OpenAzSavingPage.txtAccount(driver).getAttribute("value");
		
		///////// OPEN BASE ACCOUNT
		clearAndType(OpenAzSavingPage.txtCustomerNo(driver), customerNo);
		Log.info("Input txtCustomerNo");
		
		clearAndType(OpenAzSavingPage.txtDepositType(driver), depositType);
		Log.info("Input txtDepositType");
		
		clearAndType(OpenAzSavingPage.txtCurrency(driver), currency);
		Log.info("Input txtCurrency");
		
		OpenAzSavingPage.btnCommit(driver).click();
		Log.info("Click btnCommit");
		
		Log.info(OpenAzSavingPage.lblResult(driver).getText());
		Log.info("Print lblResult");
		
		// OPEN FIXED AZ
		signin.switchMainId();
		signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
		
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), depositProduct);
		Log.info("Input txtDepositProduct");
		
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), amount);
		Log.info("Input txtPrincipalAmount");
		
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),valueDate);
		Log.info("Input txtOpenDate");
		
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), maturityDate);
		Log.info("Input txtMaturityDate");
		
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), debitAccount);
		Log.info("Input txtDebitAccount");
		
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), nominatedAccount);
		Log.info("Input txtNominatedAccount");
		
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), interestRate);
		
		//////// Input NR
		if(nrProgram==null||nrProgram.equals(""))
		{
			OpenAzSavingPage.rbtNrProgramN(driver).click();
			Log.info("Click rbtNrProgramN");
		}
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			Log.info("Click rbtNrProgramY");
		}
		
		clearAndType(OpenAzSavingPage.txtDao(driver), dao);
		Log.info("Input txtDao");
		OpenAzSavingPage.btnCommit(driver).click();
		Log.info("Click btnCommit");
		
		if(OpenAzSavingPage.lblOverride(driver)!=null)
		{
			OpenAzSavingPage.lblOverride(driver).click();
			Log.info("Click lblOverride");
		}
		else
			Log.info("lblOverride not found");

		Log.info("Print lblResult: " + OpenAzSavingPage.lblResult(driver).getText());
		
		// AUTHORIZE FIXED AZ
		signin.switchMainId();
        signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
		
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		Log.info("Input txtTransactionId");
		OpenAzSavingPage.btnPerform(driver).click();
		Log.info("Click btnPerform");
		OpenAzSavingPage.btnAuthorise(driver).click();
		Log.info("Click btnAuthorise");
		Log.info("Print lblResult: " + OpenAzSavingPage.lblResult(driver).getText());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}