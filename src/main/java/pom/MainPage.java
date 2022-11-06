package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    //кнопка ЗАКАЗАТЬ вверху:
    private final By orderButtonUp = By.xpath(".//div[contains(@class,'Header_Nav')]/button[@class='Button_Button__ra12g']");

    //кнопка ЗАКАЗАТЬ внизу:
    private final By orderButtonDown = By.xpath(".//div[contains(@class,'Home_FinishButton__1_cWm')]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка ДА ВСЕ ПРИВЫКЛИ во всплывающем окне о куки:
    private final By cookieButton = By.id("rcc-confirm-button");



    //вопрос "Сколько это стоит? И как оплатить?"
    private final By paymentQuestion = By.id("accordion__heading-0");

    //вопрос "Хочу сразу несколько самокатов! Так можно?"
    private final By manyScootersQuestion = By.id("accordion__heading-1");

    //вопрос "Как рассчитывается время аренды?"
    private final By dropdownPeriodQuestion = By.id("accordion__heading-2");

    //вопрос "Можно ли заказать самокат прямо на сегодня?"
    private final By todayOrderQuestion = By.id("accordion__heading-3");

    //вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By extendQuestion = By.id("accordion__heading-4");

    //вопрос "Вы привозите зарядку вместе с самокатом?"
    private final By chargerQuestion = By.id("accordion__heading-5");

    //вопрос "Можно ли отменить заказ?"
    private final By cancelQuestion = By.id("accordion__heading-6");

    //вопроса "Я жизу(тут опечатка) за МКАДом, привезёте?"
    private final By mkadQuestion = By.id("accordion__heading-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    //открыть сайт Яндекс Самокат
    public void open(){
        driver.get(url);
    }

    //нажать на кнопку ДА ВСЕ ПРИВЫКЛИ
    public void pressCookieButton() {
        driver.findElement(cookieButton).click();
    }

    //выбрать кнопку ЗАКАЗАТЬ: 0 - кнопка вверху, 1 - кнопка внизу
    public void clickOrderButton (int numberOfButton) {
        if (numberOfButton == 0) {
            driver.findElement(orderButtonUp).click();
        } else if (numberOfButton == 1) {
            WebElement element = driver.findElement(By.className("accordion"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(orderButtonDown).click();
        }
    }

    //проверить первый вопрос (о цене)
    public void checkPaymentQuestion() {
        //скроллим до вопроса
        WebElement element = driver.findElement(paymentQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(paymentQuestion).click();
        //ждем, пока всплывет ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1= driver.findElement(By.id("accordion__panel-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-0")).getText();
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",answer);
        System.out.println("Ответ о цене соответствует ОР.");
    }

    //проверить вопрос о заказе нескольких самокатов
    public void checkManyScootersQuestion() {
        //скроллим до вопроса
        WebElement element = driver.findElement(manyScootersQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(manyScootersQuestion).click();
        //ждем, пока загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-1")).getText();
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",answer);
        System.out.println("Ответ о заказе нескольких самокатов соответствует ОР.");
    }

    //проверить вопрос о рассчете времени аренды
    public void checkDropdownPeriodQuestion(){
        //скроллим до вопроса
        WebElement element = driver.findElement(dropdownPeriodQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(dropdownPeriodQuestion).click();
        //Ждем, пока загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-2"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-2")).getText();
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",answer);
        System.out.println("Ответ о рассчете времени аренды соответствует ОР.");
    }

    //проверить вопрос о возможности заказа на сегодня
    public void checkTodayOrderQuestion() {
        //скроллим до вопроса
        WebElement element = driver.findElement(todayOrderQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(todayOrderQuestion).click();
        //ждем, пока загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-3"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-3")).getText();
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",answer);
        System.out.println("Ответ о возможности заказа на сегодня соответствует ОР.");
    }

    //проверить вопрос о продлении
    public void checkExtendQuestion(){
        //скроллим до вопроса
        WebElement element = driver.findElement(extendQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(extendQuestion).click();
        //ждем, когда загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-4")).getText();
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",answer);
        System.out.println("Ответ о продлении заказа соответствует ОР.");
    }

    //проверить вопрос про зарядку
    public void checkChargerQuestion(){
        //скроллим до вопроса
        WebElement element = driver.findElement(chargerQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(chargerQuestion).click();
        //ждем, когда загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-5"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        ////проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-5")).getText();
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",answer);
        System.out.println("Ответ о зарядке соответствует ОР.");
    }

    //проверить вопрос об отмене заказа
    public void checkCancelQuestion(){
        //скроллим до вопроса
        WebElement element = driver.findElement(cancelQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(cancelQuestion).click();
        //ждем, когда загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-6"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-6")).getText();
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",answer);
        System.out.println("Ответ об отмене заказа соответствует ОР.");
    }

    //проверить вопрос о МКАДе
    public void checkMkadQuestion(){
        //скроллим до вопроса
        WebElement element = driver.findElement(mkadQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        //кликаем по вопросу
        driver.findElement(mkadQuestion).click();
        //ждем, когда загрузится ответ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //скроллим до ответа
        WebElement element1 = driver.findElement(By.id("accordion__panel-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
        //проверяем, что ответ соответствует ОР
        String answer = driver.findElement(By.id("accordion__panel-7")).getText();
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",answer);
        System.out.println("Ответ о МКАДе соответствует ОР.");
    }
}
