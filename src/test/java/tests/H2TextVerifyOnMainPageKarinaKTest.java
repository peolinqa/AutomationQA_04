package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class H2TextVerifyOnMainPageKarinaKTest extends BaseTest {
    public final String START_URL = ("http://www.99-bottles-of-beer.net/");

    @Test
    public void h2TextVerifyOnMainPageTest() {

        getDriver().get(START_URL);
        MainPage main = new MainPage(getDriver());

        String expectedResult = "one program in 1500 variations";

        getDriver().findElement(By.xpath("//ul[@id='menu']/li/a[@href='/']")).click();

        Assert.assertEquals(main.getH2HeaderText(), expectedResult);
    }

    @Test
    public void signGuestBook(){

        String name = "Name:";
        String location = "Location: (optional)";
        String email = "E-Mail:";
        String homePage = "Homepage (optional):";
        String securityCode = "Security Code:";
        String message = "Message::";

        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append(name)
                .append("\n\n")
                .append(location)
                .append("\n\n")
                .append(email)
                .append("\n\n")
                .append(homePage)
                .append("\n\n")
                .append(securityCode)
                .append("\n  \n")
                .append(message);

        getDriver().get(START_URL);
        getDriver().findElement(By.linkText("GUESTBOOK")).click();
        getDriver().findElement(By.linkText("Sign Guestbook")).click();

        List<WebElement> ps = getDriver().findElements(By.xpath("//form[@id='addentry']/p"));
        List<String> actualResult = new ArrayList<>();

        for (WebElement p : ps) {
            if (p.getText().contains(name)) {
                actualResult.add(p.getText());
            }
        }
        Assert.assertEquals(actualResult.size(), 1);
        Assert.assertEquals(actualResult.get(0),expectedResult.toString());
    }
    @Test
    public void textInputForFieldLocation(){
        getDriver().get(START_URL);
        getDriver().findElement(By.linkText("GUESTBOOK")).click();
        getDriver().findElement(By.linkText("Sign Guestbook")).click();

        String expectedResult = "Error: Please enter at least a message, your email address and the security code.";

        getDriver().findElement(By.xpath("//form[@id='addentry']/p/input[2]")).sendKeys("ddd");
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        WebElement actualResult = getDriver().findElement(By.xpath("//p[contains(text(), Error)]"));

        Assert.assertEquals(actualResult.getText(), expectedResult);
    }
}