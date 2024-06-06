package org.loanle.chapter2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunTestOnFirefox {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.driver", "src\\main\\resources\\driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String url = "https://www.selenium.dev/documentation/";
        String expectedTitle = "The Selenium Browser Automation Project | Selenium";
        String actualTitle = "";
        driver.get(url);
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
        driver.close();
    }
}
