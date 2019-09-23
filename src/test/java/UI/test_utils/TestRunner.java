package UI.test_utils;

import cucumber.api.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import UI.test_base.PageInstance;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@CucumberOptions(strict = true, monochrome = true,
        features = "src/test/resources/features",
        glue = "UI.step_definition",
        format = {"pretty","json:target/cucumber.json"},
        tags = { "@Regression" })

public class TestRunner extends PageInstance {

    public static Properties config = null;

    public void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//resources//config//configuration.properties");
        config.load(ip);
    }

    public void configureDriverPath() throws IOException {
            String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    public void openBrowser() throws Exception {
            LoadConfigProperty();
            configureDriverPath();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void setEnv() throws Exception {
        LoadConfigProperty();
        String baseUrl = config.getProperty("siteUrl");
        driver.get(baseUrl);
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        openBrowser();
        maximizeWindow();
        deleteAllCookies();
        setEnv();
    }

    @AfterSuite(alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}