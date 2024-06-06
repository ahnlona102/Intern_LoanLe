package org.loanle.chapter5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseChap5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Navigate to Railway
        String url = " http://saferailway.somee.com/";
        driver.get(url);
        driver.navigate().refresh();

        // Maximize the browser window
        driver.manage().window().maximize();

        //Step 1. Login Railway System with a valid account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.gotologinpage();
        loginPage.login("ltanhloan102@grr.la", "123456789");

        //Step 2. Click on Timetable tab
        //Step 3. Click on “check price” of Sai Gon-Da Nang
        //Step 4. Click on “book ticket” of “Soft seat”
        //Step 5. Choose Depart date is next week (next 7 days) and Ticket amount is 2
        //Step 6. Click on “book ticket”
        TimetablePage timetablePage = new TimetablePage(driver);
        timetablePage.gototimetablepage();
        WebElement checkPricebtn = timetablePage.checkPrice("Sài Gòn", "Đà Nẵng");
        checkPricebtn.click();
        WebElement checkSeatbtn = timetablePage.checkSeat("Soft seat");
        checkSeatbtn.click();
        timetablePage.selectDepartDate(7);
        timetablePage.selectAmountTicket(2);
        timetablePage.bookTicketbtn();

        //Expected: Ticket booked successfully!” is shown with corrected ticket info
        SuccessPage successPage = new SuccessPage(driver);
        successPage.checkSuccessMessage("Ticket booked successfully!");
        successPage.checkInformation("Sài Gòn", "Đà Nẵng", "Soft seat", "6/12/2024", 2);
        driver.quit();


    }
}
