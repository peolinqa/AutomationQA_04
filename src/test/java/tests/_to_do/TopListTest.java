package tests._to_do;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.top_lists.*;
import runner.BaseTest;

public class TopListTest extends BaseTest {

    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testGoToTheTopHits() {
        final String expectedResult = "Top Hits";

        String actualResult =
                openBaseURL()
                        .clickTopListMenu()
                        .clickTopHitsSubmenu()
                        .getH2TableTopHitsName();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testGoToTheNewLanguagesThisMonth() {
        String expectedResult = "New Languages this month";

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickTopListMenu();

        TopListPage topListPage = new TopListPage(getDriver());
        topListPage.clickNewLanguagesThisMonthSubmenu();

        TopListNewLanguagesThisMonthPage topListNewLanguagesThisMonthPage =
                new TopListNewLanguagesThisMonthPage(getDriver());
        String actualResult = topListNewLanguagesThisMonthPage.getH2TableNewLanguagesName();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testGoToTheNewcomments() {
        String expectedResult = "New Comments";

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickTopListMenu();

        TopListPage topListPage = new TopListPage(getDriver());
        topListPage.clickNewCommentsSubmenu();

        NewCommentsPage newCommentsPage = new NewCommentsPage(getDriver());
        String actualResult = newCommentsPage.getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
