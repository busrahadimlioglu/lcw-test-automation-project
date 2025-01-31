package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterSelection extends BaseTest{

    @Step("5-6 yaş seçilir")
    public void selectFiveSix() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement fiveSix = driver.findElement(By.xpath("//span[contains(text(),'5-6 Yaş')]"));
        // Elemanı görünür hale getirir
        js.executeScript("arguments[0].scrollIntoView(true);", fiveSix);
        fiveSix.click();
        Thread.sleep(4000);
    }
    @Step("6 yaş seçilir")
    public void selectSix() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement six = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='desktop-filter-area desktop-filter-area--fixed']/div[@class='desktop-filter-area__content']/div[@class='filter']/div[@class='collapsible-filter-container']/div[@class='collapsible-filter-container__body']/div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']/div[3]/span[1]")));
        js.executeScript("arguments[0].scrollIntoView(true);", six);
        six.click();
        Thread.sleep(4000);
    }
    @Step("6-7 yaş seçilir")
    public void selectSixSeven() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sixSeven = driver.findElement(By.xpath("//span[contains(text(),'6-7 Yaş')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", sixSeven);
        sixSeven.click();
        Thread.sleep(4000);
    }
    @Step("Bej renk seçilir")
    public void selectColor() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement bejRenk = driver.findElement(By.xpath("//img[@src='https://img-lcwaikiki.mncdn.com//resource/images/icon/bej.png']"));
        js.executeScript("arguments[0].scrollIntoView(true);", bejRenk);
        bejRenk.click();
        Thread.sleep(4000);
    }
}
