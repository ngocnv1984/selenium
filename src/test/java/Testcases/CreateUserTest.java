package Testcases;

import org.testng.annotations.Test;
import Base.DataProviderSource;
import Base.TestBase;
import Pages.CreateUserPage;
import Pages.SignInPage;

public class CreateUserTest extends TestBase{
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void createUser(String no, String username, String signOnName) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(CreateUserPage.createUserVersion(),CreateUserPage.createUserTitle());
		
		clearAndType(CreateUserPage.txtId(driver),username);
		CreateUserPage.btnEdit(driver).click();
		selectOption(CreateUserPage.ddlOption(driver),"Paste");
		clearAndType(CreateUserPage.txtUsername(driver), signOnName);
		clearAndType(CreateUserPage.txtSignOnName(driver), signOnName);
		clearAndType(CreateUserPage.txtStartDateProfile(driver), "20160427");
		CreateUserPage.btnCommit(driver).click();
		updateResult("createuser", "done", Integer.parseInt(no), 0);
	}
}