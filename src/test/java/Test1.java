import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1 {
    private WebDriver driver;

    @Before
    public void updown(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Msi/WebDriver/bin");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

    }


    @Test
    public  void test1(){
        System.out.println("Test");
    }

}
