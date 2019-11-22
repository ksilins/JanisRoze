package lv.janisroze.firstProject.stepdefs;

import lv.janisroze.firstProject.pages.MainPage;
import lv.janisroze.firstProject.pages.OrderPage;
import lv.janisroze.firstProject.pages.ProductPage;
import org.junit.Test;

public class FirstItemOrderSteps {
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    OrderPage orderPage = new OrderPage();

    @Test
    public void orderItem() {
        mainPage.acceptCookies();
        mainPage.cancelNotifications();
        mainPage.searchItem("pop");
        mainPage.selectFirstItem();
        productPage.addToCart();
        mainPage.openCart();
        orderPage.setUser();
        orderPage.fillInForm();
    }
}
