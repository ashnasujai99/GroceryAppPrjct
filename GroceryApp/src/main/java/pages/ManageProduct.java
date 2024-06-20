package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class ManageProduct {
	WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//search
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	WebElement manageProductNavigate;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	WebElement title;
	@FindBy(xpath = "//input[@name='cd']")
	WebElement productCode;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement searchCatgry;
	@FindBy(xpath = "//select[@id='sb']")
	WebElement searchSubCatgry;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public void navigateToMngePrdct() {
		manageProductNavigate.click();
	}
	public void selectSearch() {
		search.click();
	}
	public void searchTitle(String entrTitle) {
		title.sendKeys(entrTitle);
	}
	public void searchProductCode(String entrProdCode) {
		productCode.sendKeys(entrProdCode);
	}
	public void searchCategry(String searchElement) {
		PageUtilities.dropDownByText(searchCatgry,searchElement);
	}
	public void searchSubCategry(String entrSubCat) {
		PageUtilities.dropDownByText(searchSubCatgry,entrSubCat);
	}
	public void clickSearch() {
		searchButton.click();
	}
	public boolean successAlert() {
		return alert.isDisplayed();
	}
}
