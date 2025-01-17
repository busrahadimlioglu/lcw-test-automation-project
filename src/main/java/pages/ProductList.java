package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductList extends BaseTest{

    public void sortDropdown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sortByDropdown = driver.findElement(By.xpath("//button[@class='dropdown-button__button']"));
        js.executeScript("arguments[0].scrollIntoView(true);", sortByDropdown);
        js.executeScript("arguments[0].click();", sortByDropdown);
        Thread.sleep(4000);
    }
    public void mostSales(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement mostSalesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='En çok satanlar']")));
        mostSalesButton.click();
    }

    /*public void selectProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement fourthProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4)")));
        fourthProduct.click();
    }*/
}
