package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Data {
    public static WebDriver driver;
    static ChromeOptions options = new ChromeOptions();


    @BeforeMethod
    public static void openBrowser(){

        //pop-up ve bildirimleri engeller
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize(); //tarayıcı penceresi maksimum boyut olur
        driver.manage().deleteAllCookies(); //tarayıcıdaki çerezleri temizlenir
        driver.get(URL); //lcw anasayfa açılır

    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit(); //test sonrası tarayıcı kapatılır
    }
}
