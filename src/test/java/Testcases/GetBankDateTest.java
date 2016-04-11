package Testcases;

import Base.Log;
import Base.TestBase;
import Pages.GetBankDatePage;
import Pages.SignInPage;

public class GetBankDateTest extends TestBase {

	public String getBankDate() 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(GetBankDatePage.bankDateVersion(),GetBankDatePage.bankDateTitle());
		
		clearAndType(GetBankDatePage.txtBankId(driver),"VN0010001");
		GetBankDatePage.btnView(driver).click();
		Log.info(GetBankDatePage.lblToday(driver).getAttribute("value"));
		
		return GetBankDatePage.lblToday(driver).getAttribute("value");
	}
}
