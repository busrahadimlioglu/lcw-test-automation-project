package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategorySelection extends BaseTest{
    @Step("Çocuk&Bebek kategorisi seçilir")
    public void selectKid() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement kidCategory = driver.findElement(By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']"));
        action.moveToElement(kidCategory).perform();
        Thread.sleep(2000);
    }
    @Step("Kız Çocuk kategorisi şeçilir")
    public void selectGirl() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement girlCategory = driver.findElement(By.xpath("//span[normalize-space()='KIZ ÇOCUK']"));
        action.moveToElement(girlCategory).perform();
        Thread.sleep(2000);
    }

    @Step("Mont Kaban kategorisi seçilir")
    public void selectMont() throws InterruptedException {
        WebElement montCategory = driver.findElement(By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']"));
        montCategory.click();
        Thread.sleep(2000);
    }
}
