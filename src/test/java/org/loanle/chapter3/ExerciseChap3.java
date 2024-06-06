package org.loanle.chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExerciseChap3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Step 1: Get a free email here https://www.guerrillamail.com/inbox
        String baseUrl = "https://www.guerrillamail.com/inbox";
        driver.get(baseUrl);
        driver.findElement(By.xpath("//span[@id='inbox-id']")).click();
        driver.findElement(By.xpath("//span[@title='Click to Edit']//input[1]")).sendKeys("ltanhloan102");
        Select domain = new Select(driver.findElement(By.id("gm-host-select")));
        domain.selectByValue("grr.la");
        driver.findElement(By.xpath("//span[@id='inbox-id']//button[1]")).click();
        //Get email
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        WebElement emailField = driver.findElement(By.id("email-widget"));
        String email = emailField.getText();

        //Step 2: Navigate http://saferailway.somee.com/
        driver.switchTo().newWindow(WindowType.TAB);
        String url = "http://saferailway.somee.com/";
        driver.get(url);
        driver.navigate().refresh();

        //Step 3. Register account with email step 1
        WebElement tab = driver.findElement(By.linkText("Register"));
        tab.click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.id("confirmPassword")).sendKeys("123456789");
        driver.findElement(By.name("pid")).sendKeys("872642349324");
        driver.findElement(By.cssSelector("p.form-actions>input")).click();

        //Step 4. Confirm email will send to email at step 1
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement confirmLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='thanhletraining03@gmail.com ']/following-sibling::td")));
        confirmLink.click();
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'http://www.saferailway.somee.com/Account/Confirm?confirmationCode=')]")));
        confirm.click();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        //Login
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("(//label[text()='Email:']/following::input)[1]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value='login']")).click();
        //Go to “Book ticket”, book 2 tickets to Phan Thiet
        WebElement bookTicket = driver.findElement(By.linkText("Book ticket"));
        bookTicket.click();
        Select departDate = new Select(driver.findElement(By.name("Date")));
        departDate.selectByVisibleText("6/9/2024");
        Select departStation = new Select(driver.findElement(By.name("DepartStation")));
        departStation.selectByVisibleText("Nha Trang");
        Select arriveStation = new Select(driver.findElement(By.name("ArriveStation")));
        arriveStation.selectByVisibleText("Phan Thiết");
        Select seatType = new Select(driver.findElement(By.name("SeatType")));
        seatType.selectByVisibleText("Hard seat");
        Select amount = new Select(driver.findElement(By.name("TicketAmount")));
        amount.selectByVisibleText("2");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form/fieldset/input")).click();
        System.out.println("Ticket booked successfully!");

        driver.quit();

    }
}
