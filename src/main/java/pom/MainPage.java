package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private final String url = "https://qa-scooter.praktikum-services.ru/";


    // Кнопка ДА ВСЕ ПРИВЫКЛИ
    private final By cookieButton = By.xpath("//*[@id='rcc-confirm-button']");

    // Кнопка ЗАКАЗАТЬ в верхней части страницы
    private final By orderButtonUp = By.className("Button_Button__ra12g");

    // Поле ИМЯ
    private final By yourName = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");

    // Поле ФАМИЛИЯ
    private final By yourLastName = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");

    // Поле АДРЕС
    private final By yourAddress = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле МЕТРО
    private final By fieldMetroStation = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    private final By sokolnikiMetroStation = By.xpath(".//div[text()='Сокольники']/parent::button");
    private final By komsomolskayaMetroStation = By.xpath(".//div[text()='Комсомольская']/parent::button");

    // Поле ТЕЛЕФОН
    private final By yourPhoneNumber = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка ДАЛЕЕ
    private final By nextButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Поле КОГДА
    private final By fieldDeliveryDate = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    // Выбор даты
    private final By deliveryDateCurrentDateButton = By.xpath(".//div[@class='react-datepicker__week']/div[@tabindex='0']");
    private final By deliveryDateFirstDayOfTheMonthButton = By.xpath("(.//div[@class='react-datepicker__week'])[1]/div[text()='1']");


    // Поле СРОК АРЕНДЫ
    private final By fieldDropdown = By.xpath(".//div[@class='Dropdown-root']//div[@class='Dropdown-placeholder']");
    private final By dropdownPeriod = By.xpath(".//div[@class='Dropdown-root is-open']//div[text()='сутки']");
    private final By dropdownPeriod1 = By.xpath(".//div[@class='Dropdown-root is-open']//div[text()='двое суток']");


    // Кнопка ЗАКАЗАТЬ в форме внизу
    private final By middleOrderButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text()='Заказать']");

    // Кнопка ДА
    private final By confirmOrderButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

    //Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа
    private final By checkStatusButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//div[text()='Заказ оформлен']");

    private WebDriver driver;



    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void open() {
        driver.get(url);
    }

    // Метод для клика по кнопке ДА ВСЕ ПРИВЫКЛИ
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // Метод для клика по верхней кнопке ЗАКАЗАТЬ
    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }

    // Метод для введения имени в поле ИМЯ
    public void enterYourName() {
        driver.findElement(yourName).sendKeys("Баффи");
    }

    public void enterYourName1() {
        driver.findElement(yourName).sendKeys("Чиполлино");
    }

    // Метод для введения фамилии в поле ФАМИЛИЯ
    public void enterYourLastName() {
        driver.findElement(yourLastName).sendKeys("Саммерз");
    }

    public void enterYourLastName1() {
        driver.findElement(yourLastName).sendKeys("Иванов");
    }

    // Метод для введения адреса в поле АДРЕС
    public void enterYourAddress() {
        driver.findElement(yourAddress).sendKeys("Ленина, 21");
    }

    public void enterYourAddress1() {
        driver.findElement(yourAddress).sendKeys("Садовая, 33");
    }

    // Метод для введения названия метро в поле МЕТРО
    public void enterFieldMetroStation() {
        driver.findElement(fieldMetroStation).click();
        driver.findElement(sokolnikiMetroStation).click();
    }

    public void enterFieldMetroStation1() {
        driver.findElement(fieldMetroStation).click();
        driver.findElement(komsomolskayaMetroStation).click();
    }

    // Метод для введения номера телефона в поле НОМЕР ТЕЛЕФОНА
    public void enterYourPhoneNumber() {
        driver.findElement(yourPhoneNumber).sendKeys("+79244771234");
    }

    public void enterYourPhoneNumber1() {
        driver.findElement(yourPhoneNumber).sendKeys("+79244772345");
    }

    // Метод для клика по кнопке ДАЛЕЕ
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    // Метод для выбора даты в поле КОГДА ПРИВЕЗТИ САМОКАТ
    public void clickFieldDeliveryDate() {
        driver.findElement(fieldDeliveryDate).click();
        driver.findElement(deliveryDateCurrentDateButton).click();
    }

    public void clickFieldDeliveryDate1() {
        driver.findElement(fieldDeliveryDate).click();
        driver.findElement(deliveryDateFirstDayOfTheMonthButton).click();
    }


    // Метод для выбора срока аренды в поле СРОК АРЕНДЫ
    public void clickFieldDropdown() {
        driver.findElement(fieldDropdown).click();
        driver.findElement(dropdownPeriod).click();
    }

    public void clickFieldDropdown1() {
        driver.findElement(fieldDropdown).click();
        driver.findElement(dropdownPeriod1).click();
    }


    // Метод для нажатия кнопки ЗАКАЗАТЬ
    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    // Метод для подтверждения заказа
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    // Метод для проверки того, что появилось всплывающее окно с сообщением об успешном создании заказа
    public void clickCheckStatusButton() {
        driver.findElement(checkStatusButton).click();
    }



}
