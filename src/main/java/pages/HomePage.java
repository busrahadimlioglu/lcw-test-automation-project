package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BaseTest{

    public HomePage findLogin(){
        WebElement loginIcon = driver.findElement(By.id("user_1_"));
        Actions action = new Actions(driver);
        action.moveToElement(loginIcon).perform();
        return this;
    }

    public HomePage clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='cart-action__btn cart-action__btn--bg-blue']")));
        signupButton.click();
        return this;
    }

}
