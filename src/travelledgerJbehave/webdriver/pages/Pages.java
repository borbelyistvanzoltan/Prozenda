package travelledgerJbehave.webdriver.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class Pages {

    private final WebDriverProvider driverProvider;

    private LoginPagePOM loginPagePOM;
    private TransactionsPagePOM transactionsPagePOM;

    public Pages(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public LoginPagePOM loginPagePOM(){
        if ( loginPagePOM == null ){
            loginPagePOM = new LoginPagePOM(driverProvider);
        }
        return loginPagePOM;
    }

    public TransactionsPagePOM transactionsPagePOM() {
        if ( transactionsPagePOM == null ){
            transactionsPagePOM = new TransactionsPagePOM(driverProvider);
        }
        return transactionsPagePOM;
    }
}
