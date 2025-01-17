package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

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
        Thread.sleep(3000);

        driver.navigate().to(URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.querySelector('.popup-close-button').click();");
        Thread.sleep(2000);
        WebElement kidIcon = driver.findElement(By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']"));
        action.moveToElement(kidIcon).perform();
        Thread.sleep(2000);
        WebElement girlIcon = driver.findElement(By.xpath("//span[normalize-space()='KIZ ÇOCUK']"));
        action.moveToElement(girlIcon).perform();
        Thread.sleep(2000);
        WebElement montButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']")));
        montButton.click();
        Thread.sleep(2000);


        // "5-6 Yaş" filtresine kaydır ve tıkla
        WebElement fiveSixYas = driver.findElement(By.xpath("//span[contains(text(),'5-6 Yaş')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", fiveSixYas); // Elemanı görünür hale getir
        fiveSixYas.click();
        Thread.sleep(4000);
        WebElement sixYas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='desktop-filter-area desktop-filter-area--fixed']/div[@class='desktop-filter-area__content']/div[@class='filter']/div[@class='collapsible-filter-container']/div[@class='collapsible-filter-container__body']/div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']/div[3]/span[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", sixYas);
        sixYas.click();

        Thread.sleep(4000);
        WebElement sixSevYas = driver.findElement(By.xpath("//span[contains(text(),'6-7 Yaş')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", sixSevYas);
        sixSevYas.click();
        Thread.sleep(4000);
        WebElement bejRenk = driver.findElement(By.xpath("//img[@src='https://img-lcwaikiki.mncdn.com//resource/images/icon/bej.png']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bejRenk);
        bejRenk.click();

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