package org.loanle.chapter5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class TimetablePage {
    private final By timetableNavigate = By.linkText("Timetable");
    //private final By checkPricebtn = By.xpath("//table[@class='NoBorder']");
    //private final By departDate = By.cssSelector("select[name='Date']");
    private final By amountTicket = By.cssSelector("select[name='TicketAmount']");
    private final By bookTicketbutton = By.xpath("//input[@value='Book ticket']");
    private final WebDriver webDriver;
    private final WebDriverWait wait;

    String bookTicketPage = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'BookTicketPage')]";
    String checkPriceLink = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'TicketPricePage')]";
    String seatTypeLink = "//td[text()='%s']/following-sibling::td//a[contains(@href, 'BookTicketPage')]";
    String dateDate = "//select[@name='Date']//option[text()='%s']";


    public TimetablePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    private WebElement getTimetableNavigate() {
        return wait.until(ExpectedConditions.elementToBeClickable(timetableNavigate));
    }

    public void gototimetablepage() {
        getTimetableNavigate().click();
    }


    public void checkPrice(String departStation, String arriveStation) {
        By checkPricebtn = By.xpath(String.format(checkPriceLink, departStation, arriveStation));
        webDriver.findElement(checkPricebtn).click();
    }


    public void checkSeat(String seatType) {
        By checkSeatbtn = By.xpath(String.format(seatTypeLink, seatType));
        webDriver.findElement(checkSeatbtn).click();
    }

    public void selectDepartDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date nextweek = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formatdate = dateFormat.format(nextweek);
        By selectDate = By.xpath(String.format(dateDate, formatdate));
        webDriver.findElement(selectDate).click();
    }

    public void selectAmountTicket(int amount) {
        WebElement amountticket = wait.until(ExpectedConditions.elementToBeClickable(amountTicket));
        Select amountTicket = new Select(amountticket);
        amountTicket.selectByValue(String.valueOf(amount));
    }

    public void bookTicket() {
        WebElement bookticketbtn = wait.until(ExpectedConditions.elementToBeClickable(bookTicketbutton));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", bookticketbtn);
        bookticketbtn.click();
    }
}
