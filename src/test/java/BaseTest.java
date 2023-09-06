import io.qameta.allure.Step;
import org.example.pages.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.qameta.allure.Step;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected static WebDriver driver;
    private String baseUrl = "https://academybugs.com/find-bugs/";

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Step("Start browser and open Find Bugs page")
    @BeforeMethod
    public void testSetUp() throws IOException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Step("Test completed")
    @AfterSuite
    public void tearDown(){
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
