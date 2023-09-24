package testsUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPageObject;
import pageobject.RegisterPageObject;
import users.FullUser;
import users.UserGenerator;

public class TestAreRegistration {
    private WebDriver driver;
    FullUser fullUser;
    private final UserGenerator userGenerator = new UserGenerator();

    @Before
    public void updown(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
           driver.get("https://stellarburgers.nomoreparties.site/login");
        fullUser = userGenerator.generic();
    }


    @Test
    public  void testSuccessfulRegistration(){
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.clickForRegistrationOnPageLogin();
        RegisterPageObject registerPageObject = new RegisterPageObject(driver);
        registerPageObject.addNameField(fullUser.getName());
        registerPageObject.addEmailField(fullUser.getEmail());
        registerPageObject.addPasswordField(fullUser.getPassword());
        registerPageObject.clickOnButtonRegistration();
        String expected = "Вход";
        String actual = loginPageObject.getTextPageLogin();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public  void testNotSuccessfulRegistration(){

        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.clickForRegistrationOnPageLogin();
        RegisterPageObject registerPageObject = new RegisterPageObject(driver);
        registerPageObject.addNameField(fullUser.getName());
        registerPageObject.addEmailField(fullUser.getEmail());
        registerPageObject.addPasswordField("12345");
        registerPageObject.clickOnButtonRegistration();
        String expected = "Некорректный пароль";
        String actual = registerPageObject.getTextErrorInPassword();
        Assert.assertEquals(expected,actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
