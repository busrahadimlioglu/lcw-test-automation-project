package tests;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;
import utils.Listeners;

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
    @Epic("LC Waikiki Otomasyon Projesi")
    @Description("Giriş yapıldıktan sonra belirli ürün seçenekleri seçilerek ödeme adımına gidilir")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //çerezleri reddet basarak pop-up kapanır
        WebElement rejectCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieseal-banner-reject")));
        rejectCookiesButton.click();
        Listeners.saveTextLog("Sayfa yüklendi: https://www.lcw.com");

        homePage.findLogin(); //home page sayfasında giriş yap ikonu üzerine gidilir
        homePage.clickLogin(); //giriş yap butonuna tıklanır

        loginPage.fillEmail(email);
        loginPage.continueLogin();
        loginPage.fillPassword(password);
        loginPage.completeLogin();
        Listeners.saveTextLog("Giriş yapıldı");

        categorySelection.selectKid(); //"Çocuk&Bebek" kategorisi seçilir
        categorySelection.selectGirl(); //"Kız çocuk(6-14 YAŞ)" kategorisi seçilir
        categorySelection.selectMont(); //"Mont ve Kaban" alt menüsü seçilir

        filterSelection.selectFiveSix(); //"5-6 Yaş" filtresine kaydırır ve tıklar
        filterSelection.selectSix(); //"6 Yaş" filtresine kaydırır ve tıklar
        filterSelection.selectSixSeven(); //"6-7 Yaş" filtresine kaydırır ve tıklar
        filterSelection.selectColor(); //"Bej" filtresine kaydırır ve tıklar

        //Sayfayı en alttan en üste kaydırır
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        productList.sortDropdown(); //"Sırala" tıklanarak dropdown menü açılır
        productList.mostSales(); //çok satanlar şeçilir
        productList.selectProduct(); //listelenen ürünlerden 4. ürün seçilir
        Listeners.saveTextLog("Ürün seçildi");

        //engelleyici öğeyi gizlemek için 'display' stili 'none' olarak ayarlanır
        //js.executeScript("document.querySelector('.evam-first-screenControl').style.display='none';");
        Thread.sleep(3000);

        addToCart.selectSize();
        Listeners.takeScreenshot(driver);
        addToCart.addCart();
        Listeners.saveTextLog("Ürün sepete eklendi");
        addToCart.goToCart();

        cartPage.addToFavorite();
        cartPage.productDetail();//ürün detay bilgileri kontrol edilir
        Listeners.takeScreenshot(driver);
        cartPage.productPrice(); //ürün tutarı kontrol edilir
        cartPage.goToPayment();
        cartPage.goToFavorite();
        Listeners.takeScreenshot(driver);
    }
}