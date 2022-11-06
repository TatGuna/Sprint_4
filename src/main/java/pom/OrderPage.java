package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class OrderPage {
    //поле ИМЯ (госсссподи почему никто по-человечески не может объяснить, как работать в гитхабе?!)
    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    //поле ФАМИЛИЯ
    private final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    //поле АДРЕС
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //поле СТАНЦИЯ МЕТРО
    private final By fieldMetroStation = By.xpath(".//input[@class='select-search__input']");

    //поле ТЕЛЕФОН
    private final By fieldPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //кнопка ДАЛЕЕ
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    //поле КОГДА ПРИВЕЗТИ САМОКАТ
    private final By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //поле СРОК АРЕНДЫ
    private final By dropdownPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");


    //кнопка ЗАКАЗАТЬ после заполнения всех необходимых полей
    private final By middleOrderButton = By.xpath(".//div[contains(@class,'Order_Buttons__1xGrp')]/button[text()='Заказать']");

    //кнопка ДА
    private final By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(),'Да')]");

    //всплывающее окно ЗАКАЗ ОФОРМЛЕН
    private final By orderIsCreated = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    private final WebDriver driver;

    public OrderPage(WebDriver driver){

        this.driver = driver;
    }

    //заполнени поля ИМЯ
    public void inputName(String text){//ввод имени в поле имени
        driver.findElement(fieldName).sendKeys(text);
    }

    //заполнение поля ФАМИЛИЯ
    public void inputLastName(String text){//ввод фамилии
        driver.findElement(fieldLastName).sendKeys(text);
    }

    //заполнение поля АДРЕС
    public void inputAddress(String text){//ввод адреса
        driver.findElement(fieldAddress).sendKeys(text);
    }

    //заполнение поля СТАНЦИЯ МЕТРО
    public void selectMetroStation(String metro){
        driver.findElement(fieldMetroStation).click();
        driver.findElement(fieldMetroStation).sendKeys(metro);
        driver.findElement(fieldMetroStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //заполнение поля ТЕЛЕФОН
    public void inputPhoneNumber(String text){//ввод номера телефона
        driver.findElement(fieldPhoneNumber).sendKeys(text);
    }

    //клик по кнопке ДАЛЕЕ
    public void clickNextButton(){//кликнуть на кнопку "Далее"
        driver.findElement(nextButton).click();
    }

    //заполнение поля КОГДА ПРИВЕЗТИ САМОКАТ
    public void selectDeliveryDate(String text){
        driver.findElement(deliveryDate).click();
        driver.findElement(deliveryDate).sendKeys(text, Keys.ENTER);
    }

    //заполнение поля СРОК АРЕНДЫ
    public void selectDropdownPeriod(String period){
        driver.findElement(dropdownPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='" +period+"']")).click();
    }

    //клик по кнопке ЗАКАЗАТЬ
    public void clickMiddleOrderButton(){//клик на кнопку "Заказать"
        driver.findElement(middleOrderButton).click();
    }

    //подтвердить оформление заказа
    public void clickConfirmButton(){//клик на "Да" в окне подтверждения заказа
        driver.findElement(confirmButton).click();
    }

    //проверить создание заказа
    public void checkOrderIsCreated(){
        String textOfCreated = driver.findElement(orderIsCreated).getText();
        Assert.assertThat("Ошибка, заказ не оформлен, как же так, ёжкин кот!?!", textOfCreated, startsWith("Заказ оформлен"));
    }
}