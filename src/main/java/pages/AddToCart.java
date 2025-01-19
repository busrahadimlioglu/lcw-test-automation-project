package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCart extends BaseTest{
    @Step("Ürün yaş grubu seçilir")
    public void selectSize() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement sizeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'5-6 Yaş')]")));
        sizeButton.click();
        Thread.sleep(3000);
    }
    @Step("Sepete ekle butonuna tıklanır")
    public void addCart() throws InterruptedException {
        WebElement addCartButton = driver.findElement(By.xpath("//button[normalize-space()='SEPETE EKLE']"));
        addCartButton.click();
        Thread.sleep(3000);
    }
    @Step("Sepete gidilir")
    public void goToCart() throws InterruptedException {
        WebElement goToCartButton = driver.findElement(By.xpath("//a[contains(@href,'https://www.lcw.com/sepetim')]"));
        goToCartButton.click();
        Thread.sleep(3000);
    }
}
