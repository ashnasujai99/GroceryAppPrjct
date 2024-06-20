package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import utilities.ExcelUtilityClass;

public class LoginTest extends BaseClass {
	@DataProvider(name="Credentials")//Dataprovider is a class
	public Object[][] testData() {// data provider
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
	}
	@Test(groups= {"regression"}/*,dataProvider="Credentials",description="Verify user can able to login with valid credentials"*/)
	@Parameters("browser")
	public void verifyLoginWithValidCredentials(/*String name,String password*/) throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		boolean homePageIsLoaded = loginclass.dashboard();
		assertTrue(homePageIsLoaded, Constants.ERRORMESSAGE);
	}

	@Test
	public void verifyLoginWithValidUnameOnly() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(2, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(2, 1, "LoginPage");// admin1
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		boolean IsAlertExist = loginclass.alertBox();
		assertTrue(IsAlertExist,Constants.ERRORMESSAGE);

	}

	@Test
	@Parameters({"username","password"})
	public void verifyLoginWithValidPswdOnly(String uname,String pword) throws IOException {
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(uname);
		loginclass.enterPswd(pword);
		loginclass.clickBtn();
		boolean IsAlertExist = loginclass.alertBox();
		assertTrue(IsAlertExist, Constants.ERRORMESSAGE);
	}

	@Test
	public void verifyLoginWithInValidCredentials() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(4, 0, "LoginPage");// hhdshvc
		String password_value = ExcelUtilityClass.getStringData(4, 1, "LoginPage");// admin1
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		boolean IsAlertExist = loginclass.alertBox();
		assertTrue(IsAlertExist,Constants.ERRORMESSAGE);
	}
}
