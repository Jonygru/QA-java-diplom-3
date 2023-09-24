package testsUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.*;
public class TestGoToSauces {
    private WebDriver driver;

    @Before
    public void updown(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site");

    }
    @Test
    public  void testGoToSauces(){
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickOnSauces();
        homePageObject.clickOnFirstElementSauces();
        String expected = "Соус Spicy-X";
        String actual = homePageObject.getTextFirstElement();
        Assert.assertEquals(expected,actual);

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
