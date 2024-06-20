package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManagePages;
import utilities.ExcelUtilityClass;

public class ManagePageTest extends BaseClass {
	@Test
	public void managePage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		ManagePages managePageClass = new ManagePages(driver);
		managePageClass.navigateManagePage();
		managePageClass.navigateAddNewPage();
		String title_name = ExcelUtilityClass.getStringData(1, 0, "ManagePage");// admin
		managePageClass.addTitle(title_name);
		String desc_name = ExcelUtilityClass.getStringData(1, 1, "ManagePage");// admin
		managePageClass.addDescription(desc_name);
		String newPage_Name = ExcelUtilityClass.getStringData(1, 2, "ManagePage");// admin
		managePageClass.addPageName(newPage_Name);
		String image_Upload = ExcelUtilityClass.getStringData(1, 4, "ManagePage");;
		managePageClass.image(image_Upload);
		managePageClass.saveBtn();
		boolean isSuccessAlertDisplayed = managePageClass.successAlert();
		assertTrue(isSuccessAlertDisplayed, Constants.ERRORMESSAGE);

	}
	@Test
	public void searchManagePage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		ManagePages managePageClass = new ManagePages(driver);
		managePageClass.navigateManagePage();
		managePageClass.selectSearch();
		String search_data = ExcelUtilityClass.getStringData(1, 3, "ManagePage");// admin
		managePageClass.searchData(search_data);
		managePageClass.clickSearch();
		boolean isSuccessAlertDisplayed = managePageClass.successAlert();
		assertTrue(isSuccessAlertDisplayed, Constants.ERRORMESSAGE);

	}
}
