package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopRatedEsotericPage {

    private WebDriver driver;

    private final By TOP_RATED_ESOTERIC_MENU = By.xpath("//a[@href='./toplist_esoteric.html']");

    public TopRatedEsotericPage (WebDriver existingDriver) {

        this.driver = existingDriver;
    }

    protected WebDriver getDriver() {

        return driver;
    }

    public WebElement getTopRatedEsotericPage() {

        return getDriver().findElement(TOP_RATED_ESOTERIC_MENU);
    }

    public void clickTopRatedEsotericPage() {

        getTopRatedEsotericPage().click();
    }
}
