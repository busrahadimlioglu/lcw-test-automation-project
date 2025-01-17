package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage extends BaseTest{

    public void addToFavorite(){
        WebElement addFavorite = driver.findElement(By.xpath("//i[@class='fa fa-heart-o']"));
        addFavorite.click();
    }

    public void productDetail(){
        WebElement cartProductColorElement = driver.findElement(By.xpath("(//span[@class='rd-cart-item-color'])[1]"));
        String actualProductColor = cartProductColorElement.getText();

        WebElement cartProductQuantityElement = driver.findElement(By.xpath("//input[@value='1']"));
        String actualProductQuantity = cartProductQuantityElement.getAttribute("value");

        assertEquals("Renk: Bej", actualProductColor);
        assertEquals("1", actualProductQuantity);

        //WebElement cartProductNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cart-product-name')]")));
        //String actualProductName = cartProductNameElement.getText();

        //assertEquals("expectedProductName", actualProductName);
    }
    public void productPrice(){
        WebElement productPriceElement = driver.findElement(By.xpath("//span[@class='rd-cart-item-price mb-15']"));
        String productPrice = productPriceElement.getText();

        WebElement productCartPriceElement = driver.findElement(By.cssSelector("div[class='price-info-area'] span[class='total-grand-box-amount']"));
        String productCartPrice = productCartPriceElement.getText();

        assertEquals(productPrice, productCartPrice);
    }
}
