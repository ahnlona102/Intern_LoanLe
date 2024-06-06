package org.loanle.chapter2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunTestOnChrome {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
