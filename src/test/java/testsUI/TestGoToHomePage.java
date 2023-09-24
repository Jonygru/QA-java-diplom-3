package testsUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.*;

@RunWith(Parameterized.class)
public class TestGoToHomePage {
    private WebDriver driver;
    private final By button;
    private final String url;
    public TestGoToHomePage(By button, String url) {
        this.button = button;
        this.url = url;
    }
        @Before
    public void updown(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get("https://stellarburgers.nomoreparties.site"+ url);
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {By.xpath(".//p[text()='Конструктор']"),"/login"},
                {By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a"),"/feed"},
                {By.xpath(".//p[text()='Конструктор']"),"/feed"},
                {By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a"),"/login"},
        };
    }
    @Test
    public  void testSLoginOnButtonYourAccount(){

        HeaderPageObject headerPageObject = new HeaderPageObject(driver);
        headerPageObject.clickGoToHomePage(button);


        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.getTextButtonLoginInToYourAccount();
        String expected = "Войти в аккаунт";
        String actual = homePageObject.getTextButtonLoginInToYourAccount();
        Assert.assertEquals(expected,actual);

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
