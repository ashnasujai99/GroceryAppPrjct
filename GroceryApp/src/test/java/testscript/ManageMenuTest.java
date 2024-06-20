package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginClass;
import pages.Settings;
import utilities.ExcelUtilityClass;

public class ManageMenuTest extends BaseClass{
  @Test(retryAnalyzer = retry.Retry.class)
  public void searchManageMenuPage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		Settings setting = new Settings(driver);
		String select_DropdownValue = ExcelUtilityClass.getStringData(1, 2, "ManageMenu");// admin
		setting.navigateSettingsPage(select_DropdownValue);
		setting.navigateManageMenuPage();
		String search_menuName = ExcelUtilityClass.getStringData(1, 0, "ManageMenu");// admin
		setting.searchData1(search_menuName);
		String search_menuTable = ExcelUtilityClass.getStringData(1, 1, "ManageMenu");// admin
		setting.searchData2(search_menuTable);
		setting.clickSearch();
//		boolean isSuccessAlertDisplayed = managePageClass.successAlert();
//		assertTrue(isSuccessAlertDisplayed, "Success alert not Displayed");

	}
}
