package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest{

    public void fillEmail(String text){
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@name='emailAndPhone']"));
        emailTextBox.sendKeys(email);
    }

    public void continueLogin(){
        WebElement continueButton = driver.findElement(By.xpath(" //button[@class='login-form__button login-form__button--bg-blue']"));
        continueButton.click();
    }

    public void fillPassword(String text){
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys(password);
    }
    public void completeLogin() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Giriş Yap')]"));
        loginButton.click();
        Thread.sleep(3000);
        driver.navigate().to(URL);
    }

}
