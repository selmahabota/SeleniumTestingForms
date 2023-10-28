import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class ShoppingCartTest extends BaseTest{

    By booksLocator = By.xpath("//ul[@class='top-menu']/li[1]/a[contains(text(),Books)]");
    By addFirstBookLocator = By.xpath("//div[@data-productid='13']//div[@class='details']//div[@class='add-info']//input");
    By addSecondBookLocator = By.xpath("//div[@data-productid='45']//div[@class='details']//div[@class='add-info']//input");
    By computerLocator= By.xpath("//ul[@class='top-menu']/li[2]/a[contains(text(),Computers)]");
    By notebookLocator= By.xpath("//ul[@class='top-menu']//li[2]//ul//li[2]/a[contains(text(),Notebooks)]");
    By addNotebookLocator = By.xpath("//div[@data-productid='31']//div[@class='details']//div[@class='add-info']//input");
    By shoppingCartLocator = By.xpath("//div[@class='header-links']/ul/li[3]/a");
    By firstPriceLocator = By.xpath("//tbody/tr[1]//td[@class='subtotal nobr end']//span[2]");
    By secondPriceLocator = By.xpath("//tbody/tr[2]//td[@class='subtotal nobr end']//span[2]");
    By thirdPriceLocator = By.xpath("//tbody/tr[3]//td[@class='subtotal nobr end']//span[2]");
    By totalPriceLocator = By.xpath("//span[@class='product-price order-total']/strong");

    @Test
    public void shoppingCartTest1() throws InterruptedException
    {
        Thread.sleep(3000);
        getElement(booksLocator).click();
        Thread.sleep(2000);
        getElement(addFirstBookLocator).click();
        Thread.sleep(2000);
        getElement(addSecondBookLocator).click();
        Thread.sleep(5000);

        Actions a = new Actions(driver);
        WebElement mainMenu = getElement(computerLocator);
        a.moveToElement(mainMenu).perform();
        getElement(notebookLocator).click();

        Thread.sleep(2000);
        getElement(addNotebookLocator).click();
        Thread.sleep(2000);
        getElement(shoppingCartLocator).click();
        Thread.sleep(5000);

        double price1=Double.parseDouble(getElement(firstPriceLocator).getText());
        double price2=Double.parseDouble(getElement(secondPriceLocator).getText());
        double price3=Double.parseDouble(getElement(thirdPriceLocator).getText());
        double actualTotal= price1+price2+price3;
        System.out.println("Ukupna cijena: " + actualTotal);
        double expectedTotal = Double.parseDouble(getElement(totalPriceLocator).getText());
        System.out.println("Ukupna ocekivana cijena: " + expectedTotal);
        Assert.assertEquals(actualTotal, expectedTotal, "Price not matched");
    }

}
