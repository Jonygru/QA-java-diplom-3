package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPageObject {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
    private By nameField = By.xpath(".//label[text()='Имя']/parent::div/input");
    private By emailField = By.xpath(".//label[text()='Email']/parent::div/input");
    private By passwordField = By.xpath(".//label[text()='Пароль']/parent::div/input");
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    private By errorInPassword = By.xpath(".//p[@class='input__error text_type_main-default']");

    public void addNameField(String name){
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }
    public void addEmailField(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void addPasswordField(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickOnButtonRegistration(){
        WebElement element = driver.findElement(buttonRegistration);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonRegistration).click();
//        new WebDriverWait(driver, 5)
//                .until(ExpectedConditions.visibilityOfElementLocated(errorInPassword));

    }
    public String getTextErrorInPassword() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(errorInPassword));
        return driver.findElement(errorInPassword).getText();
    }




    }
