package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookTicketPage {
    private WebDriver driver;
    private String dateDate = "//select[@name='Date']//option[text()='%s']";
    private By amountTicket = By.cssSelector("select[name='TicketAmount']");
    private By bookTicketbutton = By.xpath("//input[@value='Book ticket']");

    public void BookTicketPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectDepartdate(int date){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, date);
        Date afterDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String formatdate = dateFormat.format(afterDate);
        By selectDate = By.xpath(String.format(dateDate, formatdate));
        driver.findElement(selectDate).click();
    }

    public void selectAmountTicket(int amount) {
        driver.findElement(amountTicket).sendKeys(String.valueOf(amount));
    }

    public void clickBookTicket(){
        driver.findElement(bookTicketbutton).click();
    }

    public void bookTicket(int date, int amount){
        selectDepartdate(date);
        selectAmountTicket(amount);
        clickBookTicket();
    }
}
