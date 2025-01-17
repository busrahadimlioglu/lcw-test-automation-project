package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CategorySelectionPage categorySelectionPage = new CategorySelectionPage();
    FilterSelectionPage filterSelectionPage = new FilterSelectionPage();

    @Test
    public void loginTest() throws InterruptedException {
        homePage.findLogin();
        Actions action = new Actions(driver);
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        homePage.clickLogin();
        Thread.sleep(3000);

        loginPage.fillEmail(email);
        Thread.sleep(3000);
        loginPage.continueLogin();
        Thread.sleep(3000);
        loginPage.fillPassword(password);
        Thread.sleep(3000);
        loginPage.completeLogin();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        categorySelectionPage.selectKid();
        Thread.sleep(2000);
        categorySelectionPage.selectGirl();
        Thread.sleep(2000);
        categorySelectionPage.selectMont();
        Thread.sleep(2000);

        filterSelectionPage.selectFiveSix();
        Thread.sleep(4000);
        filterSelectionPage.selectSix();
        Thread.sleep(4000);
        filterSelectionPage.selectSixSeven();
        Thread.sleep(4000);
        filterSelectionPage.selectColor();
        Thread.sleep(4000);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        WebElement sortByDropdown = driver.findElement(By.xpath("//button[@class='dropdown-button__button']"));
        js.executeScript("arguments[0].scrollIntoView(true);", sortByDropdown);
        js.executeScript("arguments[0].click();", sortByDropdown);
        Thread.sleep(4000);

        WebElement mostSaleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='En çok satanlar']")));
        mostSaleButton.click();
        Thread.sleep(4000);

        WebElement fourtProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4)")));
        fourtProduct.click();
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.evam-first-screenControl').style.display='none';");
        Thread.sleep(3000);
        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'5-6 Yaş')]")));
        sizeButton.click();
        Thread.sleep(4000);

        WebElement addToChart = driver.findElement(By.xpath("//button[normalize-space()='SEPETE EKLE']"));
        addToChart.click();
        Thread.sleep(4000);

        WebElement goToChart = driver.findElement(By.xpath("//a[contains(@href,'https://www.lcw.com/sepetim')]"));
        goToChart.click();
        Thread.sleep(4000);

        WebElement addFavorite = driver.findElement(By.xpath("//i[@class='fa fa-heart-o']"));
        addFavorite.click();


        //WebElement cartProductNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cart-product-name')]")));
        //String actualProductName = cartProductNameElement.getText();

        WebElement cartProductColorElement = driver.findElement(By.xpath("(//span[@class='rd-cart-item-color'])[1]"));
        String actualProductColor = cartProductColorElement.getText();

        WebElement cartProductQuantityElement = driver.findElement(By.xpath("//input[@value='1']"));
        String actualProductQuantity = cartProductQuantityElement.getAttribute("value");


        //assertEquals("expectedProductName", actualProductName);
        assertEquals("Renk: Bej", actualProductColor);
        assertEquals("1", actualProductQuantity);

        WebElement productPriceElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        String productPrice = productPriceElement.getText();

        WebElement productChartPriceElement = driver.findElement(By.cssSelector("div[class='price-info-area'] span[class='total-grand-box-amount']"));
        String productChartPrice = productChartPriceElement.getText();
        assertEquals(productPrice, productChartPrice);

        Thread.sleep(4000);

        WebElement goToPayment = driver.findElement(By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']"));
        goToPayment.click();

        Thread.sleep(4000);

        WebElement goToFavorite = driver.findElement(By.xpath("//a[@href='/favorilerim']"));
        goToFavorite.click();

        Thread.sleep(4000);

    }

}