package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload;

public class ManagePages {
	WebDriver driver;// interface

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement managePageLink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")
	WebElement newPageButton;
	@FindBy(xpath = "//input[@name='title']")
	WebElement enterTitle;
	@FindBy(xpath = "//div[@role='textbox']")
	WebElement enterDescription;
	@FindBy(xpath = "//input[@id='page']")
	WebElement enterPageName;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancelButton;

	// search

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchBox;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	
	
	public void navigateManagePage() {
		managePageLink.click();
	}
	
	public void navigateAddNewPage() {
		newPageButton.click();
	}
	
	public void addTitle(String title) {
		enterTitle.sendKeys(title);
	}
	
	public void addDescription(String description) {
		enterDescription.sendKeys(description);
	}
	
	public void addPageName(String pageName) {
		enterPageName.sendKeys(pageName);
	}
	
	public void image(String location) {
		FileUpload.fileUploadSendKey(imageUpload,location);
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
	public void searchData(String searchElement) {
		searchBox.sendKeys(searchElement);
	}
	public void clickSearch() {
		searchButton.click();
	}
	
}
