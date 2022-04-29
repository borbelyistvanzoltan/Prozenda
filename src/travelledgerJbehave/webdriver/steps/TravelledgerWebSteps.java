package travelledgerJbehave.webdriver.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
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
    public void navigateToImportFilePage() throws InterruptedException {
        pages.transactionsPagePOM().navigateToFileUploadsPage();
    }

    @Then("Upload transaction file from")
    public void uploadTransactionFile() throws InterruptedException {
        pages.transactionsPagePOM().uploadTransactionFile();
    }

    @Then("Commit \"$transactionNumber\"")
    public void commitTransaction(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().commitTransaction(transactionNumber);
    }

    @Then("Navigate to Bookings page")
    public void navigatesToBookingsPage() throws InterruptedException {
        pages.transactionsPagePOM().navigatesToBookings();
    }

    @Then("Change dropdown and select Seller - All Due")
    public void selectDropDownAndCheckTableFromSellerSide() {
        pages.transactionsPagePOM().changeQuickViewToSellerAllDue();
    }

    @Then("Change dropdown and select Buyer - All Due")
    public void selectDropDownAndCheckTableFromBuyerSide() {
        pages.transactionsPagePOM().changeQuickViewToBuyerAllDue();
    }

    @Then("Check \"$transactionNumber\" transaction committed")
    public void checkTransactionCommitted(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().checkParameterElementIsExist(transactionNumber);
    }

    @Then("Check \"$transactionNumber\" transaction committed from Buyer side")
    public void checkTransactionCommittedFromBuyerSide(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().checkParameterElementIsExistFromBuyerSide(transactionNumber);
    }

    @Then("Logout")
    public void logout() {
        pages.transactionsPagePOM().logout();
    }

    @Then("Click on the \"$transactionNumber\" transaction status which has blank status and select ACCEPTED status")
    public void clickOnBlankStatusFieldAndSelectAcceptedStatus(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().clickOnBlankStatusFieldAndSelectAcceptedStatus(transactionNumber);
    }

    @Then("Click on the \"$transactionNumber\" transaction status which has blank status and select REJECTED status")
    public void clickOnBlankStatusFieldAndSelectRejectedStatus(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().clickOnBlankStatusFieldAndSelectRejectedStatus(transactionNumber);
    }

    @Then("Click on the \"$transactionNumber\" transaction status which has blank status and select AMENDED status")
    public void clickOnBlankStatusFieldAndSelectAmendedStatus(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().clickOnBlankStatusFieldAndSelectAmendedStatus(transactionNumber);
    }

    @Then("Check that transaction status dropdown has proper elements for \"$transactionNumber\"")
    public void isFoundAllOptionsInTxStatusDropdown(String transactionNumber) throws InterruptedException {
        pages.transactionsPagePOM().isFoundAllOptions(transactionNumber);
    }

    @Then("Filter for \"$transactionNumber\" booking reference")
    public void filterBookingReference(String transactionNumber) {
        pages.transactionsPagePOM().filterBookingReference(transactionNumber);
    }
}
