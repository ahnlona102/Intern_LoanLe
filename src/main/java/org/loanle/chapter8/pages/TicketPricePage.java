package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketPricePage {
    private WebDriver driver;
    private final String seatType = "//td[text()='%s']/following-sibling::td//a[contains(@href, 'BookTicketPage')]";

    public void TicketPricePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSeatType(String seattype) {
        driver.findElement(By.xpath(String.format(seatType, seattype))).click();
    }

}
