package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersClass;
import pages.LoginClass;
import pages.ManagePages;
import utilities.ExcelUtilityClass;

public class AdminUsersTest extends BaseClass{
  @Test
  public void adminUser() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		AdminUsersClass adminUserClass = new AdminUsersClass(driver);
		adminUserClass.navigateAdminUsersPage();
		adminUserClass.navigateAddNewPage();
		String user_name = ExcelUtilityClass.getStringData(1, 0, "AdminUsers");// admin
		adminUserClass.addUserName(user_name);
		String pswd_name = ExcelUtilityClass.getStringData(1, 1, "AdminUsers");// admin
		adminUserClass.addPassWord(pswd_name);
		String user_type = ExcelUtilityClass.getStringData(1, 2, "AdminUsers");// admin
		adminUserClass.selectAuserType(user_type);
		adminUserClass.saveBtn();
		boolean isSuccessAlertDisplayed = adminUserClass.successAlert();
		assertTrue(isSuccessAlertDisplayed, Constants.ADMINUSER_ERRORMESSAGE);

	}
  
  @Test
	public void searchAdminUsers() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		AdminUsersClass adminUserClass = new AdminUsersClass(driver);
		adminUserClass.navigateAdminUsersPage();
		adminUserClass.selectSearch();
		String search_data1 = ExcelUtilityClass.getStringData(1, 3, "AdminUsers");// admin
		adminUserClass.firstSearchData(search_data1);
		String search_data2 = ExcelUtilityClass.getStringData(1, 4, "AdminUsers");// admin
		adminUserClass.secondSearchData(search_data2);
		adminUserClass.clickSearch();
		boolean isSuccessAlertDisplayed = adminUserClass.successAlert();
		assertTrue(isSuccessAlertDisplayed, Constants.ADMINUSER_ERRORMESSAGE);

	}
}
