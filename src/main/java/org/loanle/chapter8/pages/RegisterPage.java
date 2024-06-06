package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;
    private By emailtxtbox = By.name("email");
    private By passwordtxtbox = By.name("password");
    private By confirmPass = By.id("confirmPassword");
    private By passporttxtbox = By.name("pid");
    private By registerbtn = By.cssSelector("p.form-actions>input");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        WebElement emailTxtbox = driver.findElement(emailtxtbox);
        emailTxtbox.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordTxtbox = driver.findElement(passwordtxtbox);
        passwordTxtbox.sendKeys(password);
    }
    public void enterConfirmPass(String confirmPass){
        WebElement confirmPassTxtbox = driver.findElement(this.confirmPass);
        confirmPassTxtbox.sendKeys(confirmPass);
    }
    public void enterPassport(String passport){
        WebElement passportTxtbox = driver.findElement(passporttxtbox);
        passportTxtbox.sendKeys(passport);
    }
    public void clickRegisterBtn(){
        WebElement registerBtn = driver.findElement(registerbtn);
        registerBtn.click();
    }
    public void register(String email, String password, String confirmPass, String passport){
        enterEmail(email);
        enterPassword(password);
        enterConfirmPass(confirmPass);
        enterPassport(passport);
        clickRegisterBtn();
    }

}
