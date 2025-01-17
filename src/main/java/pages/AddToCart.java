package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart extends BaseTest{
    public void selectSize(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'5-6 Yaş')]")));
        sizeButton.click();
    }
    public void addCart(){
        WebElement addCartButton = driver.findElement(By.xpath("//button[normalize-space()='SEPETE EKLE']"));
        addCartButton.click();
    }
    public void goToCart(){
        WebElement goToCartButton = driver.findElement(By.xpath("//a[contains(@href,'https://www.lcw.com/sepetim')]"));
        goToCartButton.click();
    }
}
