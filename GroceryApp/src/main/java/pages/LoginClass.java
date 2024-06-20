package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass {
	WebDriver driver;// interface

	public LoginClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement uname;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pswd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashBoard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public void enterUname(String username) {
		uname.sendKeys(username);
	}

	public void enterPswd(String password) {
		pswd.sendKeys(password);
	}

	public void clickBtn() {
		btn.click();
	}

	public boolean dashboard() {
		return dashBoard.isDisplayed();
	}

	public boolean alertBox() {
		return alert.isDisplayed();
	}
}
