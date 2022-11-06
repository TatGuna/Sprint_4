package textInArrow;

import pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class checkTextInArrow {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();(если надумаешь сделать проверку в Огненной Лисе)
        MainPage mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        mainPage.open();
        mainPage.pressCookieButton();
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    @Test
    public void checkQuestions(){
        MainPage mainPage = new MainPage(driver);

        mainPage.checkPaymentQuestion();
        mainPage.checkManyScootersQuestion();
        mainPage.checkDropdownPeriodQuestion();
        mainPage.checkTodayOrderQuestion();
        mainPage.checkExtendQuestion();
        mainPage.checkChargerQuestion();
        mainPage.checkCancelQuestion();
        mainPage.checkMkadQuestion();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
