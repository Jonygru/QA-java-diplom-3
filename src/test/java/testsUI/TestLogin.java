package testsUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
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
import pageobject.HomePageObject;
import pageobject.LoginPageObject;
import users.ApiUser;
import users.FullUser;
import users.UserGenerator;
@RunWith(Parameterized.class)

public class TestLogin {
    private WebDriver driver;
    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    String token;
    private final By button;
    private final String url;

    public TestLogin(By button, String url) {
        this.button = button;
        this.url = url;
    }

    @Before
    public void updown(){
        fullUser = userGenerator.generic();
        ValidatableResponse userResponse = endpoint.createUser(fullUser);
        token = endpoint.getToken(userResponse);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site"+ url);
    }
    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {By.xpath(".//button[text()='Войти в аккаунт']"), ""},
                {By.xpath(".//p[text()='Личный Кабинет']"), ""},
                {By.xpath(".//a[text()='Войти']"), "/register"},
                {By.xpath(".//a[text()='Войти']"), "/forgot-password"},

        };
    }
    @Test
    public  void testSLoginOnButtonYourAccount(){
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickOnButton(button);
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.addEmailField(fullUser.getEmail());
        loginPageObject.addPasswordField(fullUser.getPassword());
        loginPageObject.clickOnLogin();
        String expected = "Оформить заказ";
        String actual = homePageObject.getTextButtonPlaceAnOrder();
        Assert.assertEquals(expected,actual);
    }
    @After
    public void teardown() {
        endpoint.deleteUser(token);
        driver.quit();
    }
}
