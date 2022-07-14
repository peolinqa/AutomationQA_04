package tests.top_lists;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class ToplistEsotericTest extends BaseTest {

    @Test
    public void testGoToTheTopRatedEsotericLanguages() {
        final String expectedResult = "Top Rated Esoteric Languages";

        String actualResult =
                openBaseURL().
                        clickTopListMenu()
                        .clickTopListEsotericSubmenu()
                        .getTextH2Header();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
