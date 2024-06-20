package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryList;
import pages.LoginClass;
import pages.ManagePages;
import utilities.ExcelUtilityClass;

public class SubCategoryList extends BaseClass {
	@Test
	public void subCategoryPage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		CategoryList subCatgryClass = new CategoryList(driver);
		subCatgryClass.navigateToSub();
		subCatgryClass.createNewProduct();
		
		String select_category = ExcelUtilityClass.getStringData(1, 0, "SubCategory");// admin
		subCatgryClass.selectCategory(select_category);
		String enter_subCatgry = ExcelUtilityClass.getStringData(1, 1, "SubCategory");// admin
		subCatgryClass.enterSubCatgry(enter_subCatgry);
		String image_Upload = ExcelUtilityClass.getStringData(1, 4, "SubCategory");;
		subCatgryClass.image(image_Upload);
		subCatgryClass.saveBtn();
		boolean isSuccessAlertDisplayed = subCatgryClass.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
	
	@Test
	public void searchManagePage() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		CategoryList subCatgryClass = new CategoryList(driver);
		subCatgryClass.navigateToSub();
		subCatgryClass.selectSearch();
		String search_Catdata = ExcelUtilityClass.getStringData(1, 2, "SubCategory");// admin
		subCatgryClass.searchCategry(search_Catdata);
		String search_sub_data = ExcelUtilityClass.getStringData(1, 3, "SubCategory");// admin
		subCatgryClass.searchSubCategry(search_sub_data);
		subCatgryClass.clickSearch();
		boolean isSuccessAlertDisplayed = subCatgryClass.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
}
