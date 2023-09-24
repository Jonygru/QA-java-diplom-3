package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPageObject {
    private WebDriver driver;

    public HeaderPageObject(WebDriver driver) {
        this.driver = driver;
    }
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    private By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    private By buttonPersonalAccoun = By.xpath(".//p[text()='Личный Кабинет']");

    public void clickOnButtonConstructor(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonConstructor));
        driver.findElement(buttonConstructor).click();
    }
    public void clickOnLogoStellarBurgers(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(logoStellarBurgers));
        driver.findElement(logoStellarBurgers).click();
    }
    public void clickGoToHomePage(By button){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(button));
        driver.findElement(button).click();
    }
    public void clickOnButtonPersonalAccoun(){
        driver.findElement(buttonPersonalAccoun).click();
        new WebDriverWait(driver, 5);
    }
}
