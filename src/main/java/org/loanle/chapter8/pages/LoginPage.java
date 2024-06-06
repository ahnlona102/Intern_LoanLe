package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final By emailtextbox = By.xpath("(//label[text()='Email:']/following::input)[1]");
    private final By passwordtextbox = By.xpath("//input[@type='password']");
    private final By loginbutton = By.xpath("//input[@value='login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebElement inputEmail = driver.findElement(emailtextbox);
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement inputPassword = driver.findElement(passwordtextbox);
        inputPassword.sendKeys(password);
    }

    public void clickLoginBtn() {
        WebElement loginBtn = driver.findElement(loginbutton);
        loginBtn.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
    }
}

