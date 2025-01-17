package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends Data {
    public static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();


    @BeforeMethod
    public static void openBrowser(){

        options.addArguments("--disable-popup-blocking"); // Pop-up'ları engelle
        options.addArguments("--disable-blink-features=AutomationControlled"); // Otomasyon izi bırakmayı azalt
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(URL);

    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
}
