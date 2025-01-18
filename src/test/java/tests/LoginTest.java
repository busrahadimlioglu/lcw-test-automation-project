package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //çerezleri reddet basarak pop-up kapanır
        WebElement rejectCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookieseal-banner-reject")));
        rejectCookiesButton.click();

        homePage.findLogin(); //home page sayfasında giriş yap ikonu üzerine gidilir
        homePage.clickLogin(); //giriş yap butonuna tıklanır

        loginPage.fillEmail(email);
        loginPage.continueLogin();
        loginPage.fillPassword(password);
        loginPage.completeLogin();

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

        //engelleyici öğeyi gizlemek için 'display' stili 'none' olarak ayarlanır
        js.executeScript("document.querySelector('.evam-first-screenControl').style.display='none';");
        Thread.sleep(3000);

        addToCart.selectSize(); //ürün bedeni seçilir
        addToCart.addCart(); //ürün sepete eklenir
        addToCart.goToCart();

        cartPage.addToFavorite();
        cartPage.productDetail(); //ürün detay bilgileri kontrol edilir
        cartPage.productPrice(); //ürün tutarı kontrol edilir
        cartPage.goToPayment();
        cartPage.goToFavorite();
    }
}