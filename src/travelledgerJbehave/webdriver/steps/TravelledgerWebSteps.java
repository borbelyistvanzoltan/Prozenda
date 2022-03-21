package travelledgerJbehave.webdriver.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import travelledgerJbehave.webdriver.pages.Pages;

public class TravelledgerWebSteps {

    private final Pages pages;

    public TravelledgerWebSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Login page")
    public void userIsOnLoginPage(){
        pages.loginPagePOM().open();
    }

    @Given("I login as: \"$email\" with password: \"$pass\"")
    public void loginToMainPage(String email, String pass) {
        pages.transactionsPagePOM().open(email, pass);
    }

    @Given("Wait for loading main page")
    public void waitForMainPage() throws InterruptedException {
        pages.transactionsPagePOM().waitForLoadingMainPage();
    }

    @Then("Navigate to Import file page")
    public void navigateToImportFilePage() {
        pages.transactionsPagePOM().navigateToImportFilePage();
    }

    @Then("Select Auto commit uploaded invoices checkbox")
    public void selectCheckbox() {
        pages.transactionsPagePOM().selectCheckBox();
    }

    @Then("Upload transaction file")
    public void uploadTransactionFile(String location) {
        pages.transactionsPagePOM().uploadTransactionFile(location);
    }

    @Then("Navigate to Bookings page")
    public void navigatesToBookingsPage() {
        pages.transactionsPagePOM().navigatesToBookings();
    }

    @Then("Check that the transactions have been commited and can be viewed")
    public void checkTransactionsCommited() throws InterruptedException {
        pages.transactionsPagePOM().checkCommitedTransactions();
    }

    @Then("Logout")
    public void logout() {
        pages.transactionsPagePOM().logout();
    }
}
