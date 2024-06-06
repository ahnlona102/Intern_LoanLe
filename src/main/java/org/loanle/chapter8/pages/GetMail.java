package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GetMail {
    private WebDriver driver;
    private By usernametxtbox = By.xpath("//span[@id='inbox-id']");
    private By usernameinput = By.xpath("//span[@title='Click to Edit']//input[1]");
    private By domainselect = By.id("gm-host-select");
    private By setbtn = By.xpath("//span[@id='inbox-id']//button[1]");
    private By uncheckbox = By.xpath("(//input[@type='checkbox'])[1]");
    private By emailField = By.id("email-widget");

    public GetMail(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement userNametxtbox = driver.findElement(usernametxtbox);
        userNametxtbox.click();
        WebElement enterUser = driver.findElement(usernameinput);
        enterUser.sendKeys(username);
    }
    public void selectDomain(String domain) {
        Select domainSelection = new Select(driver.findElement(domainselect));
        domainSelection.selectByValue(domain);
    }
    public void clickSetbtn() {
        WebElement setButton = driver.findElement(setbtn);
        setButton.click();
    }
    public void clickUncheckbox() {
        WebElement uncheck = driver.findElement(uncheckbox);
        uncheck.click();
    }
    public void getEmail(){
        WebElement email = driver.findElement(emailField);
        email.getText();
    }
    public void getMail(String username, String domain) {
        enterUsername(username);
        selectDomain(domain);
        clickSetbtn();
        clickUncheckbox();
        getEmail();
    }

}
