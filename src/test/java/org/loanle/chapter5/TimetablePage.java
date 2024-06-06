package org.loanle.chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimetablePage {
    private final By timetableNavigate = By.linkText("Timetable");
    private final By checkPricebtn = By.xpath("//table[@class='NoBorder']");
    private final By departDate = By.cssSelector("select[name='Date']");
    private final By amountTicket = By.cssSelector("select[name='TicketAmount']");
    private final By bookTicketbutton = By.xpath("//input[@value='Book ticket']");
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public TimetablePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getTimetableNavigate() {
        return wait.until(ExpectedConditions.elementToBeClickable(timetableNavigate));
    }

    private WebElement getBookTicket() {
        return wait.until(ExpectedConditions.elementToBeClickable(bookTicketbutton));
    }

    public void gototimetablepage() {
        getTimetableNavigate().click();
    }

    public WebElement checkPrice(String departStation, String arriveStation) {
        String xpath = String.format("//tr[td[text()='%s' and following-sibling::td[text()='%s']]]", departStation, arriveStation);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }


    public WebElement checkSeat(String seatType) {
        String Xpath = String.format("//td[text()='Soft seat']", seatType);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
    }

    public void selectDepartDate(int plusDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date = currentDate.plusDays(plusDate);
        String formatDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        WebElement departdate = wait.until(ExpectedConditions.elementToBeClickable(departDate));
        Select departDate = new Select(departdate);
        departDate.selectByValue(formatDate);
    }

    public void selectAmountTicket(int amount) {
        WebElement amountticket = wait.until(ExpectedConditions.elementToBeClickable(amountTicket));
        Select amountTicket = new Select(amountticket);
        amountTicket.selectByValue(String.valueOf(amount));
    }

    public void bookTicketbtn() {
        getBookTicket().click();
    }
}
