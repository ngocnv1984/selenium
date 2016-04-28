package Testcases;

import org.testng.annotations.Test;

import Base.DataProviderSource;
import Base.TestBase;
import Pages.OpenIndividualCustomerPage;
import Pages.ResetPasswordPage;
import Pages.SignInPage;

public class ResetPasswordTest extends TestBase{
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void resetPassword(String no, String username, String signOnName) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(ResetPasswordPage.resetPasswordVersion(),ResetPasswordPage.resetPasswordTitle());
		
		clearAndType(ResetPasswordPage.txtId(driver), username);
		ResetPasswordPage.btnEdit(driver).click();
		clearAndType(ResetPasswordPage.txtUserTest(driver), username);
		clearAndType(ResetPasswordPage.txtUserPassword(driver), "12341234");
		ResetPasswordPage.rbtUserType(driver).click();
		ResetPasswordPage.btnCommit(driver).click();
		
//		if(ResetPasswordPage.rbtUserType(driver).getAttribute("type").equals("hidden"))
//			ResetPasswordPage.btnCommit(driver).click();
//		else
//			ResetPasswordPage.rbtUserType(driver).click();

		signin.switchMainId();
		signin.signIn(driver,signOnName,"12341234");
		clearAndType(ResetPasswordPage.txtOldPassword(driver),"123456");
		clearAndType(ResetPasswordPage.txtPassword(driver),"123456");
		ResetPasswordPage.btnGo(driver).click();
		updateResult("createuser", "done", Integer.parseInt(no), 0);
	}
}

//JED F.USER <USER_NAME>
//field 33
//ctrl + K
//save