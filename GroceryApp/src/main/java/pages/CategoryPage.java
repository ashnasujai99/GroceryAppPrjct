package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// add new

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement create_newCat_prod;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryName;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	@FindBy(xpath = "//input[@name='top_menu']")
	WebElement radioBtn1;
	@FindBy(xpath = "//input[@name='show_home']")
	WebElement radioBtn2;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	// search

	@FindBy(xpath = "//a[@class ='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement manageCategoryPageNavigate;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	WebElement category;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	public void clickNew() {
		create_newCat_prod.click();
	}

	public void catName(String cat) {
		categoryName.sendKeys(cat);
	}

	public void discountProd() {
		discount.click();
	}

	public void radioOne() {
		radioBtn1.click();
	}

	public void radioTwo() {
		radioBtn2.click();
	}

	public void saveBtn() {
		saveButton.click();
	}

	public void navigateToCatPage() {
		manageCategoryPageNavigate.click();
	}

	public void selectSearch() {
		search.click();
	}

	public void searchCat(String cat) {
		category.sendKeys(cat);
	}

	public void clickSearch() {
		searchButton.click();
	}
	
	public boolean successAlert() {
		return alert.isDisplayed();
	}
}
