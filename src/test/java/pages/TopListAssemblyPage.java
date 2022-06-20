package pages;

import org.openqa.selenium.WebDriver;

public class TopListAssemblyPage {

    private WebDriver driver;

    public TopListAssemblyPage(WebDriver existingDriver) {

        this.driver = existingDriver;
    }

    protected WebDriver getDriver() {

        return driver;
    }
}
