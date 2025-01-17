package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends Data {
    public static WebDriver driver;


    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(URL);

    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
}
