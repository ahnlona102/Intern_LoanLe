package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketBookedSuccessPage {
    private final WebDriver driver;
    private final By checkmessage = By.cssSelector("h1[align='center']");
    private final By checkdepartStation = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(1)");
    private final By checkarriveStation = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(2)");
    private final By checkseatType = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(3)");
    private final By checkdepartDate = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(4)");
    private final By checkamountTicket = By.cssSelector("#content > div > table > tbody > tr.OddRow > td:nth-child(7)");

    public TicketBookedSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSuccessMessage(String expectedMessage) {
        WebElement message = driver.findElement(checkmessage);
        return message.getText().equals(expectedMessage);
    }

    public boolean checkInformation(String departStation, String arriveStation, String seatType, String departDate, int amountTicket) {
        WebElement depart = driver.findElement(checkdepartStation);
        WebElement arrive = driver.findElement(checkarriveStation);
        WebElement seat = driver.findElement(checkseatType);
        WebElement date = driver.findElement(checkdepartDate);
        WebElement amount = driver.findElement(checkamountTicket);

        return depart.getText().equals(departStation) &&
                arrive.getText().equals(arriveStation) &&
                seat.getText().equals(seatType) &&
                date.getText().equals(departDate) &&
                amount.getText().equals(String.valueOf(amountTicket));

    }
}

