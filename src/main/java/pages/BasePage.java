package pages;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/driver/chromedriver.exe");

    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getChromeDriver() {
        if (this.driver == null) {
            return driver = new ChromeDriver();
        } else {
            return this.driver;
        }
    }
}
