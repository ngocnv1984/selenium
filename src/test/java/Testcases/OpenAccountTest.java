package Testcases;

import org.testng.annotations.Test;

import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenAccountPage;
import Pages.SignInPage;

public class OpenAccountTest extends TestBase {

	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void openAccount(String No, String customerNo, String depositType, String currency, 
			String bonusType, String custType, String dao) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAccountPage.t24Version(),OpenAccountPage.versionTitle());
		
		OpenAccountPage.btnNew(driver).click();
		String account = OpenAccountPage.txtAccount(driver).getAttribute("value");
		clearAndType(OpenAccountPage.txtCustomerNo(driver), customerNo);
		clearAndType(OpenAccountPage.txtDepositType(driver), depositType);
		clearAndType(OpenAccountPage.txtCurrency(driver), currency);
		
		if(!bonusType.isEmpty())
			selectOption(OpenAccountPage.ddlBonusType(driver), bonusType);
		
		if(!custType.isEmpty())
			selectOption(OpenAccountPage.ddlCustType(driver), custType);
		
		clearAndType(OpenAccountPage.txtDao(driver), dao);
		OpenAccountPage.btnCommit(driver).click();
		
		if(OpenAccountPage.lblOverride(driver)!=null)
			OpenAccountPage.lblOverride(driver).click();

		Log.info(account);
		updateResult("openaccount",account, Integer.parseInt(No), 0);
	}
}
