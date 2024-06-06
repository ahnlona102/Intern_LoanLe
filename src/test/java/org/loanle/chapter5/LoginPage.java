package org.loanle.chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By loginNavigate = By.linkText("Login");
    private final By emailtextbox = By.cssSelector("input[name='username']");
    private final By passwordtextbox = By.xpath("//input[@type='password']");
    private final By loginbutton = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.cssSelector("p.message.error.LoginForm");
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void gotologinpage() {
        webDriver.findElement(loginNavigate).click();
    }

    private WebElement getemailTxtbox() {
        return webDriver.findElement(emailtextbox);
    }

    private WebElement getPasswordTxtbox() {
        return webDriver.findElement(passwordtextbox);
    }

    private WebElement getLoginBtn() {
        return webDriver.findElement(loginbutton);
    }

    private WebElement getErrorMessage() {
        return webDriver.findElement(errorMessage);
    }

    public void login(String email, String password) {
        getemailTxtbox().sendKeys(email);
        getPasswordTxtbox().sendKeys(password);
        getLoginBtn().click();
    }

    public String getErrorMessageText() {

        return getErrorMessage().getText();
    }

}
