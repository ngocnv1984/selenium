package Testcases;

import org.testng.annotations.Test;
import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenAccountPage;
import Pages.SignInPage;

public class OpenAccountTest extends TestBase {

	String[] dataset = new String[7];
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	private void openAccount(String no, String customerNo, String depositType, String currency, 
			String bonusType, String custType, String dao) 
	{	
		this.dataset[0] = no;
		this.dataset[1] = customerNo;
		this.dataset[2] = depositType;
		this.dataset[3] = currency;
		this.dataset[4] = bonusType;
		this.dataset[5] = custType;
		this.dataset[6] = dao;
		
//		Log.info(getBankDate());
		createFile();
//		process();
	}
	
	private void process()
	{
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAccountPage.t24Version(),OpenAccountPage.versionTitle());
		
		OpenAccountPage.btnNew(driver).click();
		String account = OpenAccountPage.txtAccount(driver).getAttribute("value");
		clearAndType(OpenAccountPage.txtCustomerNo(driver), dataset[1]);
		clearAndType(OpenAccountPage.txtDepositType(driver), dataset[2]);
		clearAndType(OpenAccountPage.txtCurrency(driver), dataset[3]);
		
		if(!dataset[4].isEmpty())
			selectOption(OpenAccountPage.ddlBonusType(driver), dataset[4]);
		
		if(!dataset[5].isEmpty())
			selectOption(OpenAccountPage.ddlCustType(driver), dataset[5]);
		
		clearAndType(OpenAccountPage.txtDao(driver), dataset[6]);
		OpenAccountPage.btnCommit(driver).click();
		
		if(OpenAccountPage.lblOverride(driver)!=null)
			OpenAccountPage.lblOverride(driver).click();

		Log.info(account);
		updateResult("openaccount",account, Integer.parseInt(dataset[0]), 0);
	}
}
