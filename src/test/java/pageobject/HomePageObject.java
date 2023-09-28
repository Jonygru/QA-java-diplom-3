package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    private By buttonLoginInToYourAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private By buttonPlaceAnOrder = By.xpath(".//button[text()='Оформить заказ']");


    private By rolls = By.xpath(".//span[text()='Булки']");
    private By rollsElements = By.xpath(".//div/ul[1]/a/img[@alt='Флюоресцентная булка R2-D3']");

    private By sauces = By.xpath(".//span[text()='Соусы']");
    private By saucesElements = By.xpath(".//div/ul[2]/a/img[@alt='Соус Spicy-X']");


    private By fillings = By.xpath(".//span[text()='Начинки']/parent::div");
    private By fillingsElements = By.xpath(".//div/ul[3]/a/img[@alt='Мясо бессмертных моллюсков Protostomia']");
    private By firstElements = By.xpath(".//p[@class='text text_type_main-medium mb-8']");


    public void clickOnButtonLoginInToYourAccount(){
        driver.findElement(buttonLoginInToYourAccount).click();
        new WebDriverWait(driver, 5);
    }

    public String getTextButtonPlaceAnOrder() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonPlaceAnOrder));
        return driver.findElement(buttonPlaceAnOrder).getText();
    }
    public String getTextButtonLoginInToYourAccount() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLoginInToYourAccount));
        return driver.findElement(buttonLoginInToYourAccount).getText();
    }

    public void clickOnButton(By button){
        driver.findElement(button).click();
        new WebDriverWait(driver, 5);
    }

    public void clickOnRolls(){
        WebElement element = driver.findElement(fillingsElements);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(rolls).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(rollsElements));
    }
    public void clickOnFirstElementRolls(){
        driver.findElement(rollsElements).click();
    }
    public void clickOnSauces(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(sauces));
        driver.findElement(sauces).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(saucesElements));
    }
    public void clickOnFirstElementSauces(){
        driver.findElement(saucesElements).click();
    }


    public void clickOnFillings(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(fillings));
        driver.findElement(fillings).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(fillingsElements));
    }
    public void clickOnFirstElementFillings(){
        driver.findElement(fillingsElements).click();
    }

    public String getTextFirstElement(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstElements));
        return driver.findElement(firstElements).getText();
    }
}
