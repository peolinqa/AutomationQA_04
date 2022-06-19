package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import runner.BaseTest;

public class TopListTest extends BaseTest {

    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testGoToTheTopRated() {
        String expectedResult = "Top Rated";

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickTopListMenu();

        String actualResult = getDriver().findElement(By.xpath("//div[@id='main']/h2")).getText();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
