package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilties.DriverSetup;

public class BasePage {

	protected WebDriver driver;
	
	public BasePage() {
		this.driver = DriverSetup.driver;
		PageFactory.initElements(driver, this);
	}
}
