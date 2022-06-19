package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignGuestbookPage;
import runner.BaseTest;


public class KsSignGuestbookPageTest extends BaseTest {

    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testSecurityCodeField() {
        String expectedResult = "Error: Error: Invalid security code.";

        SignGuestbookPage signGuestbookPage = new SignGuestbookPage(getDriver());

        getDriver().get(BASE_URL);
        signGuestbookPage.getGuestbookMenu().click();
        signGuestbookPage.getSignGuestbookMenuClick();

        getDriver().findElement(By.xpath
                ("//form/p/input[@name='name']")).sendKeys("Ksenia");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='location']")).sendKeys("Sankt-Peterburg");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='email']")).sendKeys("ksunchik123@yandex.ru");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='homepage']")).sendKeys("https://www.google.com/");
        getDriver().findElement(By.xpath("//form/p/input[@name='captcha']")).sendKeys
                (Integer.toString((int) (Math.random() * 1000 + 100)));
        getDriver().findElement(By.xpath("//textarea[@name='comment']")).sendKeys
                ("Test");

        signGuestbookPage.getSubmitButtonClick();

        String actualResult = signGuestbookPage.getErrorMessageText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
