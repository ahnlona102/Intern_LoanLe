package org.loanle.chapter8.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmEmail {
    private WebDriver driver;
    private By confirmLink = By.xpath("//td[text()='thanhletraining03@gmail.com ']/following-sibling::td");
}
