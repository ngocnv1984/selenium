package Testcases;

import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenIndividualCustomerPage;
import Pages.OpenIndividualFatcaPage;
import Pages.SignInPage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenIndividualFatcaTest extends TestBase {

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
	public void openIndividualFatca(String cif) 
	{
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenIndividualFatcaPage.t24Version(),OpenIndividualFatcaPage.versionTitle());
		
		clearAndType(OpenIndividualCustomerPage.txtTransactionId(driver), cif);
		OpenIndividualFatcaPage.btnEdit(driver).click();
		
		new Select(OpenIndividualFatcaPage.ddlFatcaStatus(driver)).selectByVisibleText("Us");
		OpenIndividualFatcaPage.txtCitizenship(driver).sendKeys("US");
		OpenIndividualFatcaPage.txtBirthPlace(driver).sendKeys("US");
		OpenIndividualFatcaPage.rbtGreenCardNo(driver).click();
		OpenIndividualFatcaPage.rbtResidentNo(driver).click();
		OpenIndividualFatcaPage.rbtTransferReceiveNo(driver).click();
		OpenIndividualFatcaPage.rbtUsAddressNo(driver).click();
		OpenIndividualFatcaPage.rbtAttorneyNo(driver).click();
		OpenIndividualFatcaPage.rbtAttorneyUsNo(driver).click();
		OpenIndividualFatcaPage.rbtSentViaNo(driver).click();
		OpenIndividualFatcaPage.txtTin(driver).sendKeys("123456789");
		OpenIndividualFatcaPage.btnCommit(driver).click();
		
		//////// Authorize FATCA
		signin.switchMainId();
		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenIndividualCustomerPage.t24Version(),OpenIndividualCustomerPage.versionTitle());
		
		OpenIndividualFatcaPage.txtTransactionId(driver).sendKeys(cif);
		OpenIndividualFatcaPage.btnPerform(driver).click();
		OpenIndividualFatcaPage.btnAuthorise(driver).click();
		driver.quit();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
