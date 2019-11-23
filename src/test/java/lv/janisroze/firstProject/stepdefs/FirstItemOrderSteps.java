package lv.janisroze.firstProject.stepdefs;

import lv.janisroze.firstProject.pages.MainPage;
import lv.janisroze.firstProject.pages.OrderPage;
import lv.janisroze.firstProject.pages.ProductPage;
import lv.janisroze.firstProject.pages.base.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstItemOrderSteps {
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    OrderPage orderPage = new OrderPage();

    @Before
    public void setup() {
        Base.startBrowser();
    }

    @Test
    public void orderItem() {
        mainPage.acceptCookies();
        mainPage.cancelNotifications();
        mainPage.searchItem("batman");
        mainPage.selectFirstItem();
        productPage.addToCart();
        mainPage.openCart();
        orderPage.setUser();
        orderPage.fillInCustomerInfo();
//        "Self" value examples: 7, 11, 17, 24, 31, 33, 47
//        "Omniva" value examples: 9940, 9158, 9950, 9206, 9983
        orderPage.fillInDeliveryType("Omniva", "9983");
        orderPage.fillInPayment("Paypal", true);
        orderPage.discountCode();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        Base.stopBrowser();
    }
}
