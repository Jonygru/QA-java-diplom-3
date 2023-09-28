package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    private By registration = By.xpath(".//a[text()='Зарегистрироваться']");
    private By buttonLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By emailField = By.xpath(".//label[text()='Email']/parent::div/input");
    private By passwordField = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private By pageLogin = By.xpath(".//div/h2[text()='Вход']");


    public void clickForRegistrationOnPageLogin(){
        driver.findElement(registration).click();
    }
    public String getTextButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        return driver.findElement(buttonLogin).getText();
    }
    public void clickOnLogin(){
        driver.findElement(buttonLogin).click();
    }
    public void addEmailField(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void addPasswordField(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    public String getTextPageLogin() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(pageLogin));
        return driver.findElement(pageLogin).getText();
    }
}
