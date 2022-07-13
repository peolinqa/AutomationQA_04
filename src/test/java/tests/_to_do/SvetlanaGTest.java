package tests._to_do;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.browse_languages.AbcPage;
import pages.browse_languages.letters.RPage;
import pages.start.InfoPage;
import pages.start.StartPage;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class SvetlanaGTest extends BaseTest {
    private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void testVerifyHistoricInformationLink() {

        final String expectedResult = "History";
        final String expectedUrl = "https://www.99-bottles-of-beer.net/info.html";

        getDriver().get(BASE_URL);

        StartPage start = new StartPage(getDriver());
        start.clickInfoMain();

        InfoPage history = new InfoPage(getDriver());
        String actualResult = history.getH2HeaderText();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

    @Test
    public void testVerifyHereLink() {

        final String expectedUrl = "https://www.99-bottles-of-beer.net/lyrics.html";

        getDriver().get(BASE_URL);

        StartPage start = new StartPage(getDriver());
        start.clickLyricsMain();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

    @Test
    public void testPageRCountLanguages() {

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickBrowseLanguagesMenu();

        AbcPage abc = new AbcPage(getDriver());
        abc.clickRSubmenu();

        RPage r = new RPage(getDriver());

        Assert.assertEquals(r.getCountTrTags(), 44);
    }

    @Test
    public void testPageRVerifyHeaderAndText() {
        final String expectedHeader = "Category R";
        final String expectedText = "All languages starting with the letter R are shown, sorted by Language.";

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickBrowseLanguagesMenu();

        AbcPage abc = new AbcPage(getDriver());
        abc.clickRSubmenu();

        RPage r = new RPage(getDriver());
        String actualHeader = r.getH2HeaderText();
        String actualText = r.getPTagText();

        Assert.assertEquals(actualHeader, expectedHeader);
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void testPageRVerifyTableHeaders() {

       final List<String> expectedResult = new ArrayList<>();

        expectedResult.add("Language");
        expectedResult.add("Author");
        expectedResult.add("Date");
        expectedResult.add("Comments");
        expectedResult.add("Rate");

        getDriver().get(BASE_URL);

        MainPage main = new MainPage(getDriver());
        main.clickBrowseLanguagesMenu();

        AbcPage abc = new AbcPage(getDriver());
        abc.clickRSubmenu();

        RPage r = new RPage(getDriver());

        Assert.assertEquals(r.getTextListThTags(), expectedResult);
    }
}