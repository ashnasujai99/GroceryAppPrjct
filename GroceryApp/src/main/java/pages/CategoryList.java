package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FileUpload;
import utilities.PageUtilities;

public class CategoryList {
	WebDriver driver;

	public CategoryList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category' and @class='small-box-footer']")
	WebElement SubCtgryPageNavigate;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement create_new_sub_prod;
	@FindBy(xpath = "//select[@name='cat_id']")
	WebElement category_dropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement enter_subCatgry;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement insert_image;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	WebElement cancel_button;
	
	//search
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//select[@id='un']")
	WebElement selectCatgry;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement searchSubCatgry;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	public void navigateToSub() {
		SubCtgryPageNavigate.click();
	}

	public void createNewProduct() {
		create_new_sub_prod.click();
	}

	public void selectCategory(String catgry) {
		PageUtilities.dropDownByText(category_dropdown,catgry);
	}

	public void enterSubCatgry(String subCtgry) {
		enter_subCatgry.sendKeys(subCtgry);
	}

	public void image(String location) {
		FileUpload.fileUploadSendKey(insert_image,location);
	}

	public void saveBtn() {
		save_button.click();
	}

	public void cancelBtn() {
		cancel_button.click();
	}
	
	//search
	
	public void selectSearch() {
		search.click();
	}
	public void searchCategry(String searchElement) {
		PageUtilities.dropDownByText(selectCatgry,searchElement);
	}
	public void searchSubCategry(String entrSub) {
		searchSubCatgry.sendKeys(entrSub);
	}
	public void clickSearch() {
		searchButton.click();
	}
	public boolean successAlert() {
		return alert.isDisplayed();
	}
}
