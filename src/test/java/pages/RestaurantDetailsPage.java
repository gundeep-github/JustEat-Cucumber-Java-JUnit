package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestaurantDetailsPage extends BasePage {

	@FindBy(id = "postcode")
	private WebElement postalCode;

	public RestaurantDetailsPage() {
	}

	public String getPostalCode() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(postalCode));
		return postalCode.getText();
	}

}
