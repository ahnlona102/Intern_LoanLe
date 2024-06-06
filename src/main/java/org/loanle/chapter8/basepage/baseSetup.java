package org.loanle.chapter8.basepage;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class baseSetup {
    private WebDriver driver;
    static String driverPath = "resources\\driver";
    String navigatePage = "//a[.='%s']";
    public WebDriver getDriver(){
        return driver;
    }
    private void setDriver(String url){
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void navigatepage(String pagename){
        By navigate = By.xpath(String.format(navigatePage, pagename));
        driver.findElement(navigate).click();
    }

    @Parameter(names = {"url"})
    @BeforeClass
    public void initializeTestBaseSetup(String url) {
        try {
            setDriver(url);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
