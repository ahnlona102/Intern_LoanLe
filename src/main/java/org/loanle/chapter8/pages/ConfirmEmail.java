package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmEmail {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By confirmMess = By.xpath("//td[text()='thanhletraining03@gmail.com ']/following-sibling::td");
    private final By confirmLink = By.xpath("//a[contains(@href, 'http://www.saferailway.somee.com/Account/Confirm?confirmationCode=')]");

    public ConfirmEmail(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickConfirmMess() {
        WebElement confirmMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmMess));
        confirmMessage.click();
    }

    public void clickConfirmLink() {
        WebElement confirm = driver.findElement(confirmLink);
        confirm.click();
    }

    public void clickConfirmEmail() {
        clickConfirmMess();
        clickConfirmLink();
    }
}
