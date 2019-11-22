package lv.janisroze.firstProject.pages;

import lv.janisroze.firstProject.pages.base.Base;
import org.openqa.selenium.By;

public class OrderPage extends Base {

    private static By NAME_FIELD = By.id("billing:firstname");
    private static By SURNAME_FIELD = By.id("billing:lastname");
    private static By EMAIL_FIELD = By.id("billing:email");
    private static By PHONE_FIELD = By.id("billing:telephone");
    private static By ADDRESS_FIELD = By.id("billing:street1");
    private static By CITY_FIELD = By.id("billing:city");
    private static By POSTAL_CODE_FIELD = By.id("billing:postcode");

    public void setUser(){
        user.setName("Janis");
        user.setSurname("Rozins");
        user.setEmail("janis.rozins@inbox.lv");
        user.setPhoneNumber("+37155667788");
        user.setAddress("Brivibas 66");
        user.setCity("Liepaja");
        user.setPostalCode("2055");
    }

    public void fillInForm() {
        driver.findElement(NAME_FIELD).sendKeys(user.getName());
        driver.findElement(SURNAME_FIELD).sendKeys(user.getSurname());
        driver.findElement(EMAIL_FIELD).sendKeys(user.getEmail());
        driver.findElement(PHONE_FIELD).sendKeys(user.getPhoneNumber());
        driver.findElement(ADDRESS_FIELD).sendKeys(user.getAddress());
        driver.findElement(CITY_FIELD).clear();
        driver.findElement(CITY_FIELD).sendKeys(user.getCity());
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(user.getPostalCode());
    }
}
