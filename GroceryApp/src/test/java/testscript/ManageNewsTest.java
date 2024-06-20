package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryList;
import pages.LoginClass;
import pages.ManageNews;
import utilities.ExcelUtilityClass;

public class ManageNewsTest extends BaseClass{
  @Test
  public void createNewNews() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		ManageNews manageNews = new ManageNews(driver);
		manageNews.navigateToNewsPage();
		manageNews.createNewNews();
		
		String enterNews = ExcelUtilityClass.getStringData(1, 0, "ManageNews");
		manageNews.enterNews(enterNews);
		manageNews.saveBtn();
		boolean isSuccessAlertDisplayed = manageNews.successAlert();
		assertTrue(isSuccessAlertDisplayed,Constants.ERRORMESSAGE);

	}
  
  @Test
	public void searchManageNews() throws IOException {
		String username_value = ExcelUtilityClass.getStringData(1, 0, "LoginPage");// admin
		String password_value = ExcelUtilityClass.getStringData(1, 1, "LoginPage");// admin
		LoginClass loginclass = new LoginClass(driver);
		loginclass.enterUname(username_value);
		loginclass.enterPswd(password_value);
		loginclass.clickBtn();
		ManageNews manageNews = new ManageNews(driver);
		manageNews.navigateToNewsPage();
		manageNews.selectSearch();
		String search_News = ExcelUtilityClass.getStringData(1, 0, "ManageNews");// admin
		manageNews.searchNews(search_News);
		manageNews.clickSearch();
		boolean isSuccessAlertDisplayed = manageNews.successAlert();
		assertTrue(isSuccessAlertDisplayed, Constants.ERRORMESSAGE);

	}

}
