package textInArrow;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import java.time.Duration;


public class checkTextInArrow1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void textShownWhenPressArrow () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //скроллим до "Вопросов о важном"
        WebElement element = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        //кликаем на стрелку первого вопроса
        driver.findElement(By.id("accordion__heading-1")).click();

        //ждем-с, пока появится текст про 400 рублей
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        //задаем переменную text
        String text = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        //метод проверяет, что открывается соответствующий текст
        assertEquals(driver.findElement(By.id("accordion__panel-1")).getText(), text);
    }

    @After
    public void teardown() {
        //закроем браузер
        driver.quit();
    }
}

