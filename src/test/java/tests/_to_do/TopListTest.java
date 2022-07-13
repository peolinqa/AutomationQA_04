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
    public void testGoToTheNewLanguagesThisMonth() {
        final String expectedResult = "New Languages this month";

        String actualResult =
                openBaseURL()
                .clickTopListMenu()
                        .clickNewLanguagesThisMonthSubmenu()
                        .getH2TableNewLanguagesName();

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
