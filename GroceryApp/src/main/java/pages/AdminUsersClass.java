package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUsersClass {
	WebDriver driver;// interface

	public AdminUsersClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsersLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newPageButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement enterUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassWord;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement selectUserType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement resetButton;

	// search
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUname;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	
	
	public void navigateAdminUsersPage() {
		adminUsersLink.click();
	}
	
	public void navigateAddNewPage() {
		newPageButton.click();
	}
	
	public void addUserName(String uName) {
		enterUserName.sendKeys(uName);
	}
	
	public void addPassWord(String pwd) {
		enterPassWord.sendKeys(pwd);
	}
	
	public void selectAuserType(String userType) {
		PageUtilities.dropDownByText(selectUserType,userType);
	}
	
	public void saveBtn() {
		saveButton.click();
	}
	
	public boolean successAlert() {
		return alert.isDisplayed();
	}
	
	//search
	
	public void selectSearch() {
		search.click();
	}
	public void firstSearchData(String searchElement1) {
		searchUname.sendKeys(searchElement1);
	}
	public void secondSearchData(String searchElement2) {
		PageUtilities.dropDownByText(searchUserType,searchElement2);
	}
	public void clickSearch() {
		searchButton.click();
	}
	
}


