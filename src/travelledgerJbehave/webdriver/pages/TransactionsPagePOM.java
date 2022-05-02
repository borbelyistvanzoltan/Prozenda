package travelledgerJbehave.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.junit.Assert.assertTrue;

public class TransactionsPagePOM extends AbstractPage {

    public static final Keys ENTER = Keys.ENTER;
    String fileUploadLocation = "/Users/borbelyistvan/Documents/Prozenda/Travelledger/Prozenda.txt";
    WebDriverWait webDriverWait = new WebDriverWait(getDriverProvider().get(), Duration.ofSeconds(6));

    Actions action = new Actions(getDriverProvider().get());

    //TODO: use dynamic route definition
    By fileUploadsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[3]/span[1]");
    By uploadFileBtnInSubMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[1]/button[1]/span[1]");
    By dropFileBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div");
    By inputType = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div/input");
    By uploadBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/div[2]/button");
    By importCheckBox = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/label/span[1]/span[1]/input");
    By uploadBtnAgain = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[5]/div[2]/button");

    By bookingRefernceFilterFieldFromBuyer = By.xpath("//table[1]/thead/tr[2]/th[5]/div/div/input");
    By bookingRefernceFilterFieldAfterUpload = By.xpath("//table[1]/thead/tr[2]/th[10]/div/div/input");
    By checkBoxAfterUploadFromBuyer = By.xpath("//table[2]/tbody/tr/td[1]/span/span/input");
    By bookingRefernceFilterFieldFromSeller = By.xpath("//table[1]/thead/tr[2]/th[6]/div/div/input");

    By updatePartnerBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[2]/button/span[1]");

    By commercialLinkField = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div[2]/div/div/div");
    By prozendaTestAutomationCommercialLink = By.xpath("/html/body/div[5]/div[3]/ul/li");
    By commercialLinkSelectionOkBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div[2]/button");
    By commitBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[1]/button/span[1]");

    By bookingsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[1]");
    By logoutBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/ul[2]/div/div[2]/span");

    By quickViewDropDown = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div/div[1]/h6/div/label/div/div");
    By sellerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[5]");
    By buyerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[2]");

    By tableColumnReferenceSeller = By.xpath("//table[2]/tbody/tr/td[6]");
    By tableColumnReferenceBuyer = By.xpath("//table[2]/tbody/tr/td[5]");

    By firstElementTxStatusField = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div");

    By statusDropDown = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div[2]/div[3]/ul");
    By acceptedStatusFromDropDownList = By.xpath("//table[2]/tbody/tr[1]/td[13]/div");
    By rejectStatusFromDropDownList = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div[2]/div[3]/ul/li[3]");
    By cancelReasonCodeFromDropDownList = By.xpath("//table[2]/tbody/tr[1]/td[14]/div/div[2]/div[3]/ul/li[5]");
    By amountField = By.xpath("//table[2]/tbody/tr[1]/td[12]/div/div/input");

    public TransactionsPagePOM(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void navigateToFileUploadsPage() throws InterruptedException {
        //TODO: change Thread.sleep methods to wait methods

        findElement(fileUploadsBtnInMenu).click();
        Thread.sleep(1000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getCheckBoxBtnPath()));
    }

    public void checkParameterElementIsExist(String transactionNumber) throws InterruptedException {
        //TODO: change Thread.sleep methods to wait methods

        filterBookingReferenceFromSellerSide(transactionNumber);
        List<WebElement> col = findElements(tableColumnReferenceSeller);
        Thread.sleep(1000);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        log.println(transactionNumber + " transaction appear in Bookings page from Seller side!");
    }

    public void checkParameterElementIsExistFromBuyerSide(String transactionNumber) throws InterruptedException {
        //TODO: change Thread.sleep methods to wait methods

        filterBookingReference(transactionNumber);
        webDriverWait.until(ExpectedConditions.textToBe(tableColumnReferenceBuyer,transactionNumber));

        List<WebElement> col = findElements(tableColumnReferenceBuyer);
        Thread.sleep(1000);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        log.println(transactionNumber + " transaction appear in Bookings page from Buyer side!");
    }

    public void changeQuickViewToSellerAllDue() {
        findElement(quickViewDropDown).click();
        findElement(sellerAllDueOption).click();
        log.println("Selected Seller All Due option in quick view drop down menu.");
    }

    public void changeQuickViewToBuyerAllDue() {
        findElement(quickViewDropDown).click();
        findElement(buyerAllDueOption).click();
        log.println("Selected Buyer All Due option in quick view drop down menu.");
    }

    //Method to upload file
    public void uploadTransactionFile() throws InterruptedException {
        //TODO: change Thread.sleep methods to wait methods

        log.println("Click upload file in sub menu.");
        findElement(uploadFileBtnInSubMenu).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dropFileBtn));
        log.println("Upload file button in sub menu clicked and drop file button loaded.");
        WebElement uploadElement = findElement(inputType);
        uploadElement.sendKeys(fileUploadLocation);

        log.println("Transaction file selected lets click upload button.");
        Thread.sleep(3000);
        findElement(uploadBtn).click();
        log.println("Upload button clicked lets click check box.");

        // Check box side if available:
        findElement(importCheckBox).click();
        Thread.sleep(3000);

        findElement(uploadBtnAgain).click();
        Thread.sleep(3000);
    }

    public void commitTransaction(String transactionNumber) throws InterruptedException {
        //TODO: change Thread.sleep methods to wait methods
        //TODO: divide this method - too long, multiple functions

        filterBookingReferenceAfterFileUpload(transactionNumber);
        log.println("Filter the transaction number.");
        Thread.sleep(2000);
        findElement(checkBoxAfterUploadFromBuyer).click();
        log.println("Checkbox selected after commetting transaction.");
        Thread.sleep(2000);
        findElement(updatePartnerBtn).click();
        log.println("Update button clicked.");
        Thread.sleep(15000);

        //TODO: manually step: type Prozenda2 into text box.

        //findElement(By.xpath("//*[contains(@id,'mui')]")).click();
        log.println("Partnername is Prozenda2 set by manually.");
        Thread.sleep(1000);
        findElement(commercialLinkField).click();
        Thread.sleep(1000);
        findElement(prozendaTestAutomationCommercialLink).click();
        log.println("Commercial link is Prozenda Test automation.");
        Thread.sleep(1000);
        findElement(commercialLinkSelectionOkBtn).click();
        Thread.sleep(5000);
        log.println("Wait to disappear message.");

        findElement(bookingsBtnInMenu).click();
        log.println("Go to Bookings page.");
        Thread.sleep(2000);

        findElement(fileUploadsBtnInMenu).click();
        log.println("Go to back to File uploads page.");
        Thread.sleep(2000);

        filterBookingReferenceAfterFileUpload(transactionNumber);
        log.println("Filter the transaction number.");

        findElement(checkBoxAfterUploadFromBuyer).click();
        log.println("Checkbox selected.");
        Thread.sleep(2000);

        findElement(commitBtn).click();
        log.println("Commit button clicked.");
        Thread.sleep(2000);
    }

    //Method to navigate Bookings
    public void navigatesToBookings () throws InterruptedException {
        //webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(alertMessageAfterUpload));
        //For double polling
        Thread.sleep(15000);
        findElement(bookingsBtnInMenu).click();
        Thread.sleep(1000);
    }

    //Method to logout
    public void logout() {
        findElement(logoutBtn).click();
    }

    //Method to click on blank status transaction and change to Accepted
    public void clickOnBlankStatusFieldAndSelectAcceptedStatus(String transactionNumber) throws InterruptedException {
        //TODO: divide this method - too long, multiple functions
        findElement(firstElementTxStatusField).click();
        log.println("Blank status field clicked.");
        findElement(acceptedStatusFromDropDownList).click();
        log.println("ACCEPTED selected.");
        assertTrue(findElement(firstElementTxStatusField).getText().equals("ACCEPTED"));
        log.println("ACCEPTED checked and changed successfully.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(fileUploadsBtnInMenu));
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigate to File upload page.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(uploadFileBtnInSubMenu));
        findElement(bookingsBtnInMenu).click();
        log.println("Navigate back to Booking page.");

        // This sleep is must because double polling of the Booking page
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(quickViewDropDown));
        findElement(quickViewDropDown).click();
        log.println("Quick view drop box clicked.");
        findElement(buyerAllDueOption).click();
        log.println("Buyer All Due option selected.");

        filterBookingReference(transactionNumber);

        webDriverWait.until(ExpectedConditions.textToBe(tableColumnReferenceBuyer,transactionNumber));

        assertTrue(findElement(firstElementTxStatusField).getText().equals("ACCEPTED"));

        log.println("ACCEPTED checked and changed successfully.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectRejectedStatus(String transactionNumber) throws InterruptedException {
        //TODO: divide this method - too long, multiple functions
        findElement(firstElementTxStatusField).click();
        log.println("Blank status field clicked.");
        findElement(rejectStatusFromDropDownList).click();

        findElement(cancelReasonCodeFromDropDownList).click();
        log.println("REJECTED selected.");

        assertTrue(findElement(firstElementTxStatusField).getText().equals("REJECTED"));
        log.println("REJECTED checked and changed successfully.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(fileUploadsBtnInMenu));
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigated to File upload page.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(uploadFileBtnInSubMenu));
        findElement(bookingsBtnInMenu).click();
        log.println("Navigated back to Booking page.");

        // This sleep is must because double polling of the Booking page
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(quickViewDropDown));
        findElement(quickViewDropDown).click();
        log.println("Quick view drop box clicked.");

        findElement(buyerAllDueOption).click();
        log.println("Buyer All Due option selected.");

        filterBookingReference(transactionNumber);

        webDriverWait.until(ExpectedConditions.textToBe(tableColumnReferenceBuyer,transactionNumber));
        assertTrue(findElement(firstElementTxStatusField).getText().equals("REJECTED"));
        log.println("REJECTED checked and changed successfully.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectAmendedStatus(String transactionNumber) throws InterruptedException {
        //TODO: divide this method - too long, multiple functions
        findElement(amountField).sendKeys("200");
        log.println("Set amount to 200");

        findElement(firstElementTxStatusField).click();
        log.println("Blank status field clicked.");

        findElement(cancelReasonCodeFromDropDownList).click();
        log.println("AMENDED selected automatically, reason code set.");

        assertTrue(findElement(firstElementTxStatusField).getText().equals("AMENDED"));
        log.println("AMENDED checked and changed successfully.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(fileUploadsBtnInMenu));
        findElement(fileUploadsBtnInMenu).click();
        log.println("Navigated to File upload page.");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(uploadFileBtnInSubMenu));
        findElement(bookingsBtnInMenu).click();
        log.println("Navigated back to Booking page.");

        // This sleep is must because double polling of the Booking page
        Thread.sleep(1000);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(quickViewDropDown));
        findElement(quickViewDropDown).click();
        log.println("Quick view drop box clicked.");

        findElement(buyerAllDueOption).click();
        log.println("Buyer All Due option selected.");

        filterBookingReference(transactionNumber);
        Thread.sleep(1000);

        log.println(findElement(firstElementTxStatusField).getText());
        assertTrue(findElement(firstElementTxStatusField).getText().equals("AMENDED"));
        log.println("AMENDED checked and changed successfully.");
    }

    // Validating Tx Status dropdown elements
    public void isFoundAllOptions(String transactionNumber) throws InterruptedException {
        findElement(firstElementTxStatusField).click();
        log.println("Clicked the TX status dropbox.");

        WebElement status = findElement(statusDropDown);
        log.println("TX status dropbox elements has found.");

        List<WebElement> links = status.findElements(By.tagName("li"));
        for (int i = 0; i < links.size(); i++) {
            assertTrue(links.get(i).getText().equals("ACCEPTED") || links.get(i).getText().equals("AMENDED") || links.get(i).getText().equals("REJECTED"));
        }

        log.println("Assertion of ACCEPTED, AMENDED, REJECTED Tx status are passed.");
        action.sendKeys(Keys.ESCAPE).perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firstElementTxStatusField));
    }

    public void filterBookingReference(String transactionNumber) {
        findElement(bookingRefernceFilterFieldFromBuyer).sendKeys(transactionNumber);
        action.sendKeys(ENTER).perform();
        log.println("Filter " + transactionNumber + " booking reference successfully.");
    }

    public void filterBookingReferenceAfterFileUpload(String transactionNumber) throws InterruptedException {
        findElement(bookingRefernceFilterFieldAfterUpload).sendKeys(transactionNumber);
        Thread.sleep(2000);
    }

    public void filterBookingReferenceFromSellerSide(String transactionNumber) throws InterruptedException {
        findElement(bookingRefernceFilterFieldFromSeller).sendKeys(transactionNumber);
        Thread.sleep(4000);
    }

    public void waitForLoadingMainPage() throws InterruptedException {
        // We have to wait with Thread.sleep() because the main page polling
        Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(fileUploadsBtnInMenu));
        log.println("Transaction page loaded successfully.");
    }
}