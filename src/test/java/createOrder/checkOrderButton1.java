package createOrder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.time.Duration;

public class checkOrderButton1 {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void textShownWhenPressArrow () {
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        // Заходим на главную страницу
        mainPage.open();
        // Закрываем сообщение про куки
        mainPage.clickCookieButton();
        // Нажимаем на верхнюю кнопку ЗАКАЗАТЬ
        mainPage.clickOrderButtonUp();
        // Вводим имя в поле ИМЯ
        mainPage.enterYourName1();
        // Вводим фамилию в поле ФАМИЛИЯ
        mainPage.enterYourLastName1();
        // Вводим адрес в поле АДРЕС
        mainPage.enterYourAddress1();
        // Выбираем станцию метро
        mainPage.enterFieldMetroStation1();
        // Заполняем поле ТЕЛЕФОН
        mainPage.enterYourPhoneNumber1();
        // Нажимаем на кнопку ДАЛЕЕ
        mainPage.clickNextButton();
        // Выбираем дату
        mainPage.clickFieldDeliveryDate1();
        // Выбираем срок аренды
        mainPage.clickFieldDropdown1();
        // Нажимаем ЗАКАЗАТЬ
        mainPage.clickMiddleOrderButton();
        // Подтверждаем заказ кнопкой ДА
        mainPage.clickConfirmOrderButton();
        // Метод для проверки того, что появилось всплывающее окно с сообщением об успешном создании заказа
        mainPage.clickCheckStatusButton();
    }

    @After
    public void teardown() {
        //закроем браузер
        driver.quit();
    }
}
