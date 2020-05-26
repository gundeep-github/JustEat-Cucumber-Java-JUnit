package pages;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class RestaurantsListingPage extends BasePage {

	@FindBy(xpath = "//div[@class='c-locationHeader-container']/a/preceding-siblin g::h1")
	private WebElement postalCode;

	private RestaurantDetailsPage restaurantDetailsPage;

	public RestaurantsListingPage() {
		restaurantDetailsPage = new RestaurantDetailsPage();
	}


	public String getPostalCode()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(postalCode));
		return postalCode.getText().split(",")[0];
	}

	public static Stream<WebElement> limiting_func(Stream<WebElement> ss, int range) {
		return ss.limit(range);
	}

	public void navigateToRestaurantDetailsPageAndVerifyPostalCode(String expectedPostalCode) {
		List<WebElement> restaurantsList = driver.findElements(By.xpath("//section[@data-test-id = 'restaurant']"));
		for (int i = 0; i < 3; i++) {
			restaurantsList = driver.findElements(By.xpath("//section[@data-test-id = 'restaurant']"));
			restaurantsList.get(i).click();
			Assert.assertEquals(expectedPostalCode.split(" ")[0], restaurantDetailsPage.getPostalCode().split(" ")[0]);
			driver.navigate().back();
		}
	}
}
