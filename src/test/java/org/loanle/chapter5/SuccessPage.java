package org.loanle.chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {
    private final By checkmessage = By.cssSelector("h1[align='center']");
    private final By checkdepartStation = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(1)");
    private final By checkarriveStation = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(2)");
    private final By checkseatType = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(3)");
    private final By checkdepartDate = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(4)");
    private final By checkamountTicket = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(7)");
    private final WebDriverWait wait;

    public SuccessPage(WebDriver webDriver) {
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public boolean checkSuccessMessage(String expectedMessage) {
        WebElement checkdisplay = wait.until(ExpectedConditions.presenceOfElementLocated(checkmessage));
        String actualMessage = checkdisplay.getText();
        return actualMessage.equals(expectedMessage);
    }

    public boolean checkInformation(String departStation, String arriveStation, String seatType, String departDate, int amountTicket) {
        WebElement checkdepart = wait.until(ExpectedConditions.presenceOfElementLocated(checkdepartStation));
        WebElement checkarrive = wait.until(ExpectedConditions.presenceOfElementLocated(checkarriveStation));
        WebElement checkseat = wait.until(ExpectedConditions.presenceOfElementLocated(checkseatType));
        WebElement checkdate = wait.until(ExpectedConditions.presenceOfElementLocated(checkdepartDate));
        WebElement checkamount = wait.until(ExpectedConditions.presenceOfElementLocated(checkamountTicket));
        String departstation = checkdepart.getText();
        String arrivestation = checkarrive.getText();
        String seat = checkseat.getText();
        String date = checkdate.getText();
        String amount = checkamount.getText();

        return departstation.equals(departStation)
                && arrivestation.equals(arriveStation)
                && seat.equals(seatType)
                && date.equals(departDate)
                && Integer.parseInt(amount) == amountTicket;


    }
}
