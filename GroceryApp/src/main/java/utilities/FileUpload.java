package utilities;

import org.openqa.selenium.WebElement;

public class FileUpload {
	public static void fileUploadSendKey(WebElement element,String path) {
		element.sendKeys(path);
		}
	}

