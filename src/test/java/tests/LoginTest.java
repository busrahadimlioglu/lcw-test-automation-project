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

public class LoginTest extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CategorySelection categorySelection = new CategorySelection();
    FilterSelection filterSelection = new FilterSelection();
    ProductList productList = new ProductList();
    AddToCart addToCart = new AddToCart();
    CartPage cartPage = new CartPage();

    @Test
    public void loginTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement rejectCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieseal-banner-reject")));
        rejectCookiesButton.click();

        homePage.findLogin();
        Actions action = new Actions(driver);
        Thread.sleep(3000);
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

        categorySelection.selectKid();
        Thread.sleep(2000);
        categorySelection.selectGirl();
        Thread.sleep(2000);
        categorySelection.selectMont();
        Thread.sleep(2000);

        filterSelection.selectFiveSix();
        Thread.sleep(4000);
        filterSelection.selectSix();
        Thread.sleep(4000);
        filterSelection.selectSixSeven();
        Thread.sleep(4000);
        filterSelection.selectColor();
        Thread.sleep(4000);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        productList.sortDropdown();
        productList.mostSales();
        Thread.sleep(3000);
        productList.selectProduct();
        //WebElement fourthProduct = driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4)"));
        //fourthProduct.click();
        Thread.sleep(3000);

        js.executeScript("document.querySelector('.evam-first-screenControl').style.display='none';");
        Thread.sleep(3000);

        addToCart.selectSize();
        Thread.sleep(3000);
        addToCart.addCart();
        Thread.sleep(3000);
        addToCart.goToCart();
        Thread.sleep(3000);

        cartPage.addToFavorite();
        cartPage.productDetail();
        cartPage.productPrice();
        Thread.sleep(4000);
        cartPage.goToPayment();
        Thread.sleep(4000);
        cartPage.goToFavorite();
        Thread.sleep(4000);

    }

}