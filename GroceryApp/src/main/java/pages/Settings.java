package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Settings {
	WebDriver driver;

	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// search

//	@FindBy(xpath = "//a[@class='active highlight nav-link']")
//	WebElement settingsPage;
	@FindBy(xpath = "//p[text()='Settings']")
	WebElement settingsPage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/menu-management']")
	WebElement manageMenu;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@name='sr_name']")
	WebElement menuName;
	@FindBy(xpath = "//input[@name='sr_tbl']")
	WebElement menuTable;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	public void navigateSettingsPage(String selectPage) {
		Select select=new Select(settingsPage);
		select.selectByVisibleText("selectPage");
//		settingsPage.click();
	}

	public void navigateManageMenuPage() {
		manageMenu.click();
	}

	public void selectSearch() {
		search.click();
	}

	public void searchData1(String name) {
		menuName.sendKeys(name);
	}

	public void searchData2(String table) {
		menuTable.sendKeys(table);
	}

	public void clickSearch() {
		searchButton.click();
	}
}
