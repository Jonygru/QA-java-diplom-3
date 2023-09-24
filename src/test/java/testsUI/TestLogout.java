package testsUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.*;
import users.ApiUser;
import users.FullUser;
import users.UserGenerator;

public class TestLogout {
    private WebDriver driver;
    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();
    private final ApiUser endpoint = new ApiUser();
    String token;


    @Before
    public void updown(){
        fullUser = userGenerator.generic();
        ValidatableResponse userResponse = endpoint.createUser(fullUser);
        token = endpoint.getToken(userResponse);

        //Вход в аккаунт
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site");

        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.clickOnButton(By.xpath(".//button[text()='Войти в аккаунт']"));
        LoginPageObject loginPageObject1 = new LoginPageObject(driver);
        loginPageObject1.addEmailField(fullUser.getEmail());
        loginPageObject1.addPasswordField(fullUser.getPassword());
        loginPageObject1.clickOnLogin();


    }

    @Test
    public  void testSLoginOnButtonYourAccount(){
        HeaderPageObject headerPageObject = new HeaderPageObject(driver);
        headerPageObject.clickOnButtonPersonalAccoun();
        PersonalAccountPageObject personalAccountPageObject = new PersonalAccountPageObject(driver);

        personalAccountPageObject.clickOnButtonLogout();

        String expected = "Вход";
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        String actual = loginPageObject.getTextPageLogin();
        Assert.assertEquals(expected,actual);
    }
    @After
    public void teardown() {
        driver.quit();
        endpoint.deleteUser(token);
    }
}
