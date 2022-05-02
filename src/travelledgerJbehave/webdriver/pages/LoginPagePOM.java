package travelledgerJbehave.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginPagePOM extends AbstractPage {

    By loginBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div/div[1]/main/div/form/button");

    private WebDriverProvider driverProvider;

    public LoginPagePOM(WebDriverProvider driverProvider) {
        super(driverProvider);
        this.driverProvider = driverProvider;
    }

    public void open() {
        get("https://qa.abtlg.io");
        manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        manage().window().fullscreen();
    }

    public void login(String email, String pass) {
        findElement(By.id("email")).sendKeys(email);
        findElement(By.id("password")).sendKeys(pass);
        findElement(loginBtn).click();
    }
}
