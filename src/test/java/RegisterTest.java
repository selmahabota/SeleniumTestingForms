import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    By registerLink = By.cssSelector(".header-links ul li:nth-child(1) > a");

    By firstNameFieldLocator = By.id("FirstName");
    By lastNameFieldLocator = By.id("LastName");
    By emailFieldLocator = By.id("Email");
    By passwordFieldLocator = By.id("Password");
    By confirmPasswordFieldLocator = By.id("ConfirmPassword");
    By registerButtonLocator = By.id("register-button");
    By resultLocator = By.cssSelector(".result");

    String email = System.currentTimeMillis() + "@email.com";

    @Test
    public void registerTest1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("User: " + email);
        getElement(registerLink).click();
        typeIn(firstNameFieldLocator, "Selma");
        typeIn(lastNameFieldLocator, "Habota");
        typeIn(emailFieldLocator,email);
        typeIn(passwordFieldLocator,"selma12345");
        typeIn(confirmPasswordFieldLocator,"selma12345");
        getElement(registerButtonLocator).click();

        String expectedText = "Your registration completed";
        String actualText = getElement(resultLocator).getText();
        Assert.assertEquals(actualText, expectedText, "Text not matched!");

        String actualUrl = "https://demowebshop.tricentis.com/registerresult/1";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Url not matched");
    }
}
