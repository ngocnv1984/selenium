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
	String[] dataset = new String[19];
	
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
	public void openSavingAccount(String no, String customerNo, String depositType, 
			String currency, String depositProduct, String amount, String valueDate, 
			String maturityDate, String term, String debitAccount, String nominatedAccount, 
			String interestRate, String dao, String mobilePhone, String nrProgram, 
			String nrDate, String nrRate, String nrAmount, String nrAccount) 
	{	
		this.dataset[0] = no;			
		this.dataset[1] = customerNo;	
		this.dataset[2] = depositType;
		this.dataset[3] = currency;		
		this.dataset[4] = depositProduct;	
		this.dataset[5] = amount;
		this.dataset[6] = valueDate;	
		this.dataset[7] = maturityDate;	
		this.dataset[8] = term;
		this.dataset[9] = debitAccount;	
		this.dataset[10] = nominatedAccount;	
		this.dataset[11] = interestRate;
		this.dataset[12] = dao;	
		this.dataset[13] = mobilePhone;	
		this.dataset[14] = nrProgram;
		this.dataset[15] = nrDate;	
		this.dataset[16] = nrRate;	
		this.dataset[17] = nrAmount;
		this.dataset[18] = nrAccount;
		
		if(depositType.equals("6601")||depositType.equals("6602")||
				depositType.equals("6603")||depositType.equals("6604"))
			timeDepositWithNr();
		else
			timeDepositWithoutNr();
	}
	
	private void timeDepositWithNr()
	{
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAzSavingPage.baseVersion(),OpenAzSavingPage.baseTitle());
		
		Log.info(driver.getTitle());
		
		OpenAzSavingPage.btnNew(driver).click();
		Log.info("Click btnNew");
		
		String account = OpenAzSavingPage.txtAccount(driver).getAttribute("value");
		
		///////// OPEN BASE ACCOUNT
		clearAndType(OpenAzSavingPage.txtCustomerNo(driver), dataset[1]);
		Log.info("Input txtCustomerNo");
		
		clearAndType(OpenAzSavingPage.txtDepositType(driver), dataset[2]);
		Log.info("Input txtDepositType");
		
		clearAndType(OpenAzSavingPage.txtCurrency(driver), dataset[3]);
		Log.info("Input txtCurrency");
		
		OpenAzSavingPage.btnCommit(driver).click();
		Log.info("Click btnCommit");
		
		Log.info(OpenAzSavingPage.lblResult(driver).getText());
		Log.info("Print lblResult");
		
		// OPEN FIXED AZ
		signin.switchMainId();
		
		if(dataset[2].equals("6601")||dataset[2].equals("6603"))
		{
			signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
			openFixed(account);
		}
		else
		{
			signin.navigateToVersion(OpenAzSavingPage.mipVersion(),OpenAzSavingPage.mipTitle());
			openMip(account);
		}
		
		// AUTHORIZE FIXED AZ
		signin.switchMainId();
        signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
        
		if(dataset[2].equals("6601")||dataset[2].equals("6603"))
			signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
		else
			signin.navigateToVersion(OpenAzSavingPage.mipVersion(),OpenAzSavingPage.mipTitle());
		
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		Log.info("Input txtTransactionId");
		OpenAzSavingPage.btnPerform(driver).click();
		Log.info("Click btnPerform");
		OpenAzSavingPage.btnAuthorise(driver).click();
		Log.info("Click btnAuthorise");
		Log.info("Print lblResult: " + OpenAzSavingPage.lblResult(driver).getText());
		
		updateResult("savingaccount", account, Integer.parseInt(dataset[0]), 0);
	}
	
	private void openFixed(String account)
	{
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), dataset[4]);
		Log.info("Input txtDepositProduct");
		
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), dataset[5]);
		Log.info("Input txtPrincipalAmount");
		
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),dataset[6]);
		Log.info("Input txtOpenDate");
		
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), dataset[7]);
		Log.info("Input txtMaturityDate");
		
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), dataset[9]);
		Log.info("Input txtDebitAccount");
		
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), dataset[10]);
		Log.info("Input txtNominatedAccount");
		
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), dataset[11]);
		
		//////// Input NR
		if(dataset[14]==null||dataset[14].equals(""))
		{
			OpenAzSavingPage.rbtNrProgramN(driver).click();
			Log.info("Click rbtNrProgramN");
		}
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			Log.info("Click rbtNrProgramY");
			inputNr();
		}
		
		clearAndType(OpenAzSavingPage.txtDao(driver), dataset[12]);
		Log.info("Input txtDao");
		clearAndType(OpenAzSavingPage.txtMobilePhone(driver), dataset[13]);
		Log.info("Input txtMobilePhone");
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
	}
	
	private void openMip(String account)
	{
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), dataset[4]);
		Log.info("Input txtDepositProduct");
		
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), dataset[5]);
		Log.info("Input txtPrincipalAmount");
		
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),dataset[6]);
		Log.info("Input txtOpenDate");
		
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), dataset[7]);
		Log.info("Input txtMaturityDate");
		
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), dataset[9]);
		Log.info("Input txtDebitAccount");
		
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), dataset[10]);
		Log.info("Input txtNominatedAccount");
		
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), dataset[11]);
		
		//////// Input NR
		if(dataset[14]==null||dataset[14].equals(""))
		{
			OpenAzSavingPage.rbtNrProgramN(driver).click();
			Log.info("Click rbtNrProgramN");
		}
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			Log.info("Click rbtNrProgramY");
			inputNr();
		}
		
		clearAndType(OpenAzSavingPage.txtMobilePhone(driver), dataset[13]);
		Log.info("Input txtMobilePhone");
		OpenAzSavingPage.tabChgsSchedules(driver).click();
		OpenAzSavingPage.rbtCalculationBasePrincipal(driver).click();
		OpenAzSavingPage.rbtSchedulesN(driver).click();
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
	}
	
	private void inputNr()
	{
		
	}
	
	private void timeDepositWithoutNr()
	{
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}