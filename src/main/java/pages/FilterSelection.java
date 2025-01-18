package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterSelection extends BaseTest{

    public FilterSelection selectFiveSix(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // "5-6 Yaş" filtresine kaydır ve tıkla
        WebElement fiveSix = driver.findElement(By.xpath("//span[contains(text(),'5-6 Yaş')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", fiveSix); // Elemanı görünür hale getir
        fiveSix.click();
        return this;
    }
    public FilterSelection selectSix(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement six = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='desktop-filter-area desktop-filter-area--fixed']/div[@class='desktop-filter-area__content']/div[@class='filter']/div[@class='collapsible-filter-container']/div[@class='collapsible-filter-container__body']/div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']/div[3]/span[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", six);
        six.click();
        return this;
    }
    public FilterSelection selectSixSeven(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sixSeven = driver.findElement(By.xpath("//span[contains(text(),'6-7 Yaş')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", sixSeven);
        sixSeven.click();
        return this;
    }
    public FilterSelection selectColor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bejRenk = driver.findElement(By.xpath("//img[@src='https://img-lcwaikiki.mncdn.com//resource/images/icon/bej.png']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bejRenk);
        bejRenk.click();
        return this;
    }
}
