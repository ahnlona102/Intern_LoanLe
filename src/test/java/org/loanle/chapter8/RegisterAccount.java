package org.loanle.chapter8;

import com.beust.jcommander.Parameter;
import org.loanle.chapter8.basepage.BasePage;
import org.loanle.chapter8.pages.ConfirmEmail;
import org.loanle.chapter8.pages.GetMail;
import org.loanle.chapter8.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class RegisterAccount extends BasePage {
    private WebDriver driver;
    private GetMail getMail;
    private RegisterPage registerPage;
    private ConfirmEmail confirmEmail;

    @Parameters({"MailUrl", "RegisterUrl"})
    @BeforeClass
    public void setUp(String url) {
        initializeTestBaseSetup(url);
        driver = getDriver();
        getMail = new GetMail(driver);
        registerPage = new RegisterPage(driver);
        confirmEmail = new ConfirmEmail(driver);
    }




}
