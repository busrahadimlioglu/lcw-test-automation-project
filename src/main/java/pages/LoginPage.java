package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest{

    public void fillEmail(String text) throws InterruptedException {
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@name='emailAndPhone']"));
        emailTextBox.sendKeys(text);
        Thread.sleep(3000);
    }

    public void continueLogin() throws InterruptedException {
        WebElement continueButton = driver.findElement(By.xpath(" //button[@class='login-form__button login-form__button--bg-blue']"));
        continueButton.click();
        Thread.sleep(3000);
    }

    public void fillPassword(String text) throws InterruptedException {
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys(text);
        Thread.sleep(3000);
    }
    public void completeLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Giriş Yap')]"));
        loginButton.click();
        Thread.sleep(3000);
        driver.navigate().to(URL); //anasayfaya yönlendirir
        Thread.sleep(2000);
    }

}
