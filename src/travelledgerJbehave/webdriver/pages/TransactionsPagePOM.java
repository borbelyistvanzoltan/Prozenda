package travelledgerJbehave.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TransactionsPagePOM extends AbstractPage {

    By loginBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div/div[1]/main/div/form/button");
    By importFileBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[3]");
    By autoCommitCheckBox = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div[2]/div/div[1]/label/span[1]/span[1]/input");
    By uploadFileBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div[2]/div/div[2]/button");
    By bookingsBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[1]");
    By logoutBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/ul[2]/div/div[2]/span");

    WebDriverWait webDriverWait = new WebDriverWait(getDriverProvider().get(), Duration.ofSeconds(6));

    public TransactionsPagePOM(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open(String email, String pass) {
        findElement(By.id("email")).sendKeys(email);
        findElement(By.id("password")).sendKeys(pass);
        findElement(loginBtn).click();
    }

    public By getImportFileBtn() {
        return importFileBtn;
    }

    public By getBookingsBtn() {
        return bookingsBtn;
    }

    //getter for checkBox button
    public By getCheckBoxBtnPath() {
        return autoCommitCheckBox;
    }

    public void navigateToImportFilePage() {
        clickImportFileBtn();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getCheckBoxBtnPath()));
    }

    //Method to select checkBox
    public void selectCheckBox() {
        findElement(autoCommitCheckBox).click();
    }

    //Method to select file
    // TODO: need dummy Transaction file to upload it
    public void uploadTransactionFile(String location) {
        //WebElement uploadFile = findElement(uploadFileBtn);
        //uploadFile.click();
        //uploadFile.sendKeys(location);
    }

    //Method to click import button
    public void clickImportFileBtn() {
        findElement(importFileBtn).click();
    }

    //Method to navigate Bookings
    public void navigatesToBookings () {
        findElement(bookingsBtn).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getBookingsBtn()));
    }

    //Method to check transactions
    public void checkCommitedTransactions () throws InterruptedException {
        //TODO
        Thread.sleep(3000);
    }

    //Method to logout
    public void logout() {
        findElement(logoutBtn).click();
        //quit();
    }

    //Method to find blank status transaction
    public void findBlankStatusTransaction () {
        //TODO
    }

    public void waitForLoadingMainPage() throws InterruptedException {
        Thread.sleep(6000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getImportFileBtn()));
    }
}
