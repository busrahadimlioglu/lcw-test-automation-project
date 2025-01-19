package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage extends BaseTest{

    @Step("Giriş yap ikonu üzerine gidilir")
    public void findLogin() throws InterruptedException {
        WebElement loginIcon = driver.findElement(By.id("user_1_"));
        Actions action = new Actions(driver);
        action.moveToElement(loginIcon).perform();
        Thread.sleep(3000);
    }

    @Step("Giriş yap tıklanır")
    public void clickLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']")));
        signupButton.click();
        Thread.sleep(3000);
    }

}
