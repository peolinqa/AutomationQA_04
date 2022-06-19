package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopRatedRealPage {

    private WebDriver driver;

    private final By TOP_RATED_REAL_MENU = By.xpath("//a[@href='./toplist_real.html']");

    public TopRatedRealPage (WebDriver existingDriver) {

        this.driver = existingDriver;
    }

    protected WebDriver getDriver() {

        return driver;
    }

    public WebElement getTopRatedRealPage() {

        return getDriver().findElement(TOP_RATED_REAL_MENU);
    }

    public void clickTopRatedRealPageClick() {

        getTopRatedRealPage().click();
    }
}
