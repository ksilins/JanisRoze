package lv.janisroze.firstProject.pages;

import lv.janisroze.firstProject.pages.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends Base {

    private static By NAME_FIELD = By.id("billing:firstname");
    private static By SURNAME_FIELD = By.id("billing:lastname");
    private static By EMAIL_FIELD = By.id("billing:email");
    private static By PHONE_FIELD = By.id("billing:telephone");
    private static By ADDRESS_FIELD = By.id("billing:street1");
    private static By CITY_FIELD = By.id("billing:city");
    private static By POSTAL_CODE_FIELD = By.id("billing:postcode");

    private static By DELIVERY_SPINNER = By.id("loader_checkout-shipping-method-load");
    private static By OMNIVA_DELIVERY = By.id("s_method_scandipost24");
    private static By COURIER_DELIVERY = By.id("s_method_dlw_dlw_lv");
    private static By POSTAL_DELIVERY = By.id("s_method_tablerate_bestway");
    private static By DIRECT_DELIVERY = By.id("s_method_shippingrates_jr_default");
    private static By SELF_DELIVERY = By.id("s_method_payonpickup_payonpickup");

    private static By PAYMENT_SPINNER = By.id("loader_co-payment-form");
    private static By GIFT_VOUCHER_PAY = By.id("giftvoucher");
    private static By VOUCHER_CODE_FIELD = By.id("giftvoucher_code");
    private static By TRANSFER_PAY = By.id("p_method_banktransfer");
    private static By PAYPAL_PAY = By.id("p_method_paypal_express");
    private static By SWEDBANK_PAY = By.id("p_method_banklinkswedlv");
    private static By CARD_PAY = By.id("p_method_firstdatalv");

    private static By DISCOUNT_CODE = By.id("coupon_code");

    public void setUser() {
        user.setName("Janis");
        user.setSurname("Rozins");
        user.setEmail("janis.rozins@inbox.lv");
        user.setPhoneNumber("+37155667788");
        user.setAddress("Brivibas 66");
        user.setCity("Liepaja");
        user.setPostalCode("2055");
    }

    public void fillInCustomerInfo() {
        driver.findElement(NAME_FIELD).sendKeys(user.getName());
        driver.findElement(SURNAME_FIELD).sendKeys(user.getSurname());
        driver.findElement(EMAIL_FIELD).sendKeys(user.getEmail());
        driver.findElement(PHONE_FIELD).sendKeys(user.getPhoneNumber());
        driver.findElement(ADDRESS_FIELD).sendKeys(user.getAddress());
        driver.findElement(CITY_FIELD).clear();
        driver.findElement(CITY_FIELD).sendKeys(user.getCity());
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(user.getPostalCode());
        Select cityRegionSelect = new Select(driver.findElement(By.id("billing:region_id")));
        cityRegionSelect.selectByValue("370");
        Select countrySelect = new Select(driver.findElement(By.id("billing:country_id")));
        countrySelect.selectByValue("LV");
    }

    public void fillInDeliveryType(String type) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELIVERY_SPINNER));
        switch (type) {
            case "Courier":
                driver.findElement(COURIER_DELIVERY).click();
                break;
            case "Post":
                driver.findElement(POSTAL_DELIVERY).click();
                break;
            case "Direct":
                driver.findElement(DIRECT_DELIVERY).click();
                break;
        }
    }

    public void fillInDeliveryType(String type, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(DELIVERY_SPINNER));
        switch (type) {
            case "Omniva":
                driver.findElement(OMNIVA_DELIVERY).click();
                Select station = new Select(driver.findElement(By.id("s_method_scandipost24_extra_box")));
                station.selectByValue("scandipost24_" + value);
                break;
            case "Self":
                driver.findElement(SELF_DELIVERY).click();
                Select office = new Select(driver.findElement(By.id("s_method_payonpickup_payonpickup_shop")));
                office.selectByValue("payonpickup_payonpickup_" + value);
                break;
        }

    }

    public void fillInPayment(String type, boolean voucher) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        waitUntil(PAYMENT_SPINNER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(PAYMENT_SPINNER));

        if (voucher) {
            waitUntil(GIFT_VOUCHER_PAY);
            driver.findElement(GIFT_VOUCHER_PAY).click();
            waitUntil(PAYMENT_SPINNER);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(PAYMENT_SPINNER));
            driver.findElement(VOUCHER_CODE_FIELD).sendKeys("VOUCHERCODE");
        }
        switch (type) {
            case "Transfer":
                driver.findElement(TRANSFER_PAY).click();
                break;
            case "Paypal":
                driver.findElement(PAYPAL_PAY).click();
                break;
            case "Swedbank":
                driver.findElement(SWEDBANK_PAY).click();
                break;
            case "Card":
                driver.findElement(CARD_PAY).click();
                break;
        }
    }
     public void discountCode() {
        driver.findElement(DISCOUNT_CODE).sendKeys("DISCOUNTCODE");
     }
}
