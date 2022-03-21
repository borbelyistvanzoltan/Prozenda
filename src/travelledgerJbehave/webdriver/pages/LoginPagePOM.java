package travelledgerJbehave.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPagePOM extends AbstractPage {

    private WebDriverProvider driverProvider;

    public LoginPagePOM(WebDriverProvider driverProvider) {
        super(driverProvider);
        this.driverProvider = driverProvider;
    }

    public void open() {
        get("https://qa.abtlg.io");
        manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
