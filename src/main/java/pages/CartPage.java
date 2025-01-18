package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage extends BaseTest{

    public void addToFavorite(){
        WebElement addFavorite = driver.findElement(By.xpath("//i[@class='fa fa-heart-o']"));
        addFavorite.click();
    }

    public void productDetail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //sepetteki ilk ürünün renk bilgisi bulunur
        WebElement cartProductColorElement = driver.findElement(By.xpath("(//span[@class='rd-cart-item-color'])[1]"));
        String actualProductColor = cartProductColorElement.getText();

        //sepetteki ürünün adet bilgisi bulunur
        WebElement cartProductQuantityElement = driver.findElement(By.xpath("//input[@value='1']"));
        String actualProductQuantity = cartProductQuantityElement.getAttribute("value");

        assertEquals("Renk: Koyu Bej", actualProductColor); //Sepetteki ürünün renginin "Renk: Bej" olup olmadığını kontrol edilir
        assertEquals("1", actualProductQuantity); //Sepetteki ürünün adeti "1" olup olmadığını kontrol edilir

        WebElement cartProductNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='rd-cart-item-code']")));
        String actualProductName = cartProductNameElement.getText();

        assertEquals("Mont", actualProductName);
    }
    public void productPrice() throws InterruptedException {
        //ürün fiyat bilgisi bulunur
        WebElement productPriceElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        String productPrice = productPriceElement.getText();

        //ürünün sepette yazan fiyat bilgisi bulunur
        WebElement productCartPriceElement = driver.findElement(By.cssSelector("div[class='price-info-area'] span[class='total-grand-box-amount']"));
        String productCartPrice = productCartPriceElement.getText();

        assertEquals(productPrice, productCartPrice); //sepet tutarı ve ödeme tutarı kontrolü yapılır
        Thread.sleep(4000);
    }

    public void goToPayment() throws InterruptedException {
        WebElement goToPaymentButton = driver.findElement(By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']"));
        goToPaymentButton.click();
        Thread.sleep(4000);
    }
    public void goToFavorite() throws InterruptedException {
        WebElement goToFavoriteButton = driver.findElement(By.xpath("//a[@href='/favorilerim']"));
        goToFavoriteButton.click();
        Thread.sleep(4000);
    }
}
