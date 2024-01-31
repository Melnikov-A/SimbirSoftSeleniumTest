package simbirsoft.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import simbirsoft.helpers.Attach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {

    public static WebDriver driver;
    public String BaseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    public static final String GRID_HUB_URL = "http://192.168.0.119:4444/wd/hub";

    public void setUp(boolean useRemote) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        if (useRemote) {
            driver = new RemoteWebDriver(new URL(GRID_HUB_URL), capabilities);
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(BaseUrl);

    }

    @BeforeEach
    void init() throws MalformedURLException {
        setUp(Boolean.parseBoolean(System.getProperty("useRemote", "false")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterEach
    void addAttachments() {
        Attach.attachCSVFile("transactions.csv");
        driver.close();
        driver.quit();
    }
}


