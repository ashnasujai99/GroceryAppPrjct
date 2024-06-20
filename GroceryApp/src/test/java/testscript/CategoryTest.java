package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryPage;
import pages.LoginClass;
import pages.ManagePages;
import utilities.ExcelUtilityClass;

public class CategoryTest extends BaseClass{
	
	@Test
	public void createNewCatgry() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		CategoryPage categoryClass = new CategoryPage(driver);
		categoryClass.navigateToCatPage();
		categoryClass.clickNew();
		String cat_name = ExcelUtilityClass.getStringData(1, 0, "CategoryPage");// admin
		categoryClass.catName(cat_name);
		categoryClass.discountProd();
		categoryClass.radioOne();
		categoryClass.radioTwo();
		categoryClass.saveBtn();
		boolean isSuccessAlertDisplayed = categoryClass.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
	
  @Test
  public void searchCategoryPage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		CategoryPage categoryClass = new CategoryPage(driver);
		categoryClass.navigateToCatPage();
		categoryClass.selectSearch();
		String search_cat = ExcelUtilityClass.getStringData(1, 0, "CategoryPage");// admin
		categoryClass.searchCat(search_cat);
		categoryClass.clickSearch();
		boolean isSuccessAlertDisplayed = categoryClass.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
}
