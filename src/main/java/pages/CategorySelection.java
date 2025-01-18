package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategorySelection extends BaseTest{
    public void selectKid() {
        Actions action = new Actions(driver);
        WebElement kidCategory = driver.findElement(By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']"));
        action.moveToElement(kidCategory).perform();
    }
    public void selectGirl() {
        Actions action = new Actions(driver);
        WebElement girlCategory = driver.findElement(By.xpath("//span[normalize-space()='KIZ ÇOCUK']"));
        action.moveToElement(girlCategory).perform();
    }

    public void selectMont(){
        WebElement montCategory = driver.findElement(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']"));
        montCategory.click();
    }
}
