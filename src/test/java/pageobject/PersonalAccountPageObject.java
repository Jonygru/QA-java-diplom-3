package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPageObject {
    private WebDriver driver;

    public PersonalAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private By textOnPagePersonalAccount = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private By buttonLogout = By.xpath(".//button[text()='Выход']");


    public String getTextOnPagePersonalAccount() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(textOnPagePersonalAccount));
        return driver.findElement(textOnPagePersonalAccount).getText();
    }

    public void clickOnButtonLogout(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
    }




}
