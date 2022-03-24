package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    public static String browser;

    public static WebDriver getDriver(){

        browser = PropertiesFile.getProperty("browser");

        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/geckodriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
