import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    By logInLink = By.cssSelector(".header-links ul li:nth-child(2) > a");
    By emailFieldLocator = By.id("Email");
    By passwordFieldLocator = By.id("Password");
    By logInButtonLocator = By.cssSelector(".button-1.login-button");
    By emailLoginLocator = By.cssSelector(".header-links .account");
    By logOutLocator = By.cssSelector(".ico-logout");

    @Test
    public void logInTest1 () throws InterruptedException {
        Thread.sleep(2000);

        getElement(logInLink).click();

        typeIn(emailFieldLocator, "selma.habota@gmail.com");
        typeIn(passwordFieldLocator, "25102023");
        getElement(logInButtonLocator).click();

        String actualEmail = "selma.habota@gmail.com";
        String expectedEmail = getElement(emailLoginLocator).getText();
        Assert.assertEquals(actualEmail, expectedEmail, "Email not matched");

        String actualText = "Log out";
        String expectedText = getElement(logOutLocator).getText();
        Assert.assertEquals(actualText, expectedText, "Text not matched!");
    }

}
