package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement NavigateManageNewsPage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement create_newNews;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enter_news;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	// search
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	WebElement searchNews;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton;

	public void navigateToNewsPage() {
		NavigateManageNewsPage.click();
	}

	public void createNewNews() {
		create_newNews.click();
	}

	public void enterNews(String news) {
		enter_news.sendKeys(news);
	}

	public void saveBtn() {
		save_button.click();
	}

	// search
	public void selectSearch() {
		search.click();
	}

	public void searchNews(String news) {
		searchNews.sendKeys(news);
	}

	public void clickSearch() {
		searchButton.click();
	}

	public boolean successAlert() {
		return alert.isDisplayed();
	}
}
