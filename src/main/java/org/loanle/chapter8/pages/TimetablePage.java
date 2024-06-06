package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimetablePage {
    private final WebDriver driver;
    private final String checkPricePage = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'TicketPricePage')]";
    private final String bookTicketPage = "//tr[td[text()='%s' and following-sibling::td[text()='%s']]]//a[contains(@href, 'BookTicketPage')]";

    public TimetablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkPrice(String departStation, String arrivalStation) {
        WebElement checkPricebtn = driver.findElement(By.xpath(String.format(checkPricePage, departStation, arrivalStation)));
        checkPricebtn.click();
    }

    public void bookTicket(String departStation, String arrivalStation) {
        WebElement bookTicketbtn = driver.findElement(By.xpath(String.format(bookTicketPage, departStation, arrivalStation)));
        bookTicketbtn.click();
    }

}
