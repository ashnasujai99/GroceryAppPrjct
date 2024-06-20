package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginClass;
import pages.ManageProduct;
import utilities.ExcelUtilityClass;

public class ManageProductTest extends BaseClass{
  @Test
	public void searchManageProduct() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		ManageProduct manageProductClass = new ManageProduct(driver);
		manageProductClass.navigateToMngePrdct();
		manageProductClass.selectSearch();
		String search_title = ExcelUtilityClass.getStringData(1, 0, "ManageProducts");// admin
		manageProductClass.searchTitle(search_title);
		String search_prodCode = ExcelUtilityClass.getIntegerData(1, 1, "ManageProducts");// admin
		manageProductClass.searchProductCode(search_prodCode);
		manageProductClass.clickSearch();
		boolean isSuccessAlertDisplayed = manageProductClass.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
}
