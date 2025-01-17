package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BaseTest{

    public HomePage findLogin(){
        WebElement loginIcon = driver.findElement(By.id("user_1_"));
        Actions action = new Actions(driver);
        action.moveToElement(loginIcon).perform();
        return this;
    }

}
