package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JustEatHomePage extends BasePage{

	private static final String HOME_PAGE_URL = "http://www.just-eat.co.uk/";
	
	@FindBy(xpath = "//input[@name='postcode']")
    private WebElement searchInput;
	
	@FindBy(xpath = "//button[@data-test-id = 'find-restaurants-button']")
    private WebElement searchButton;
	
	public JustEatHomePage() {}

	public void goToHomePage(){
        driver.get(HOME_PAGE_URL);
    }
	
	public void searchFor(String searchValue) {
        searchInput.sendKeys(searchValue);
    }
	
	public RestaurantsListingPage search() {
        searchButton.submit();
        return new RestaurantsListingPage();
    }
}
