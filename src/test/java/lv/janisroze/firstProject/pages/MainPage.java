package lv.janisroze.firstProject.pages;

import lv.janisroze.firstProject.pages.base.Base;
import org.openqa.selenium.By;

public class MainPage extends Base {

    private static By ACCEPT_COOKIES = By.cssSelector(".cc-actions > a:first-child");
    private static By NOTIFICATIO_CANCEL = By.id("onesignal-popover-cancel-button");
    private static By SEARCH_BOX = By.id("search");
    private static By CART_BUTTON = By.cssSelector(".item #mini-cart");
    private static By FIRST_ITEM = By.cssSelector(".category-products .item:first-child");
    private static By ITEM_NAME = By.cssSelector(".item:first-child > h2 > a");
    private static By ITEM_PRICE = By.cssSelector(".item:first-child .price");

    public void acceptCookies() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        waitClick(ACCEPT_COOKIES);
        driver.findElement(ACCEPT_COOKIES).click();
    }

    public void searchItem(String itemName) {
        waitClick(SEARCH_BOX);
        driver.findElement(SEARCH_BOX).sendKeys(itemName);
        driver.findElement(SEARCH_BOX).submit();
    }

    public void selectFirstItem() {
        waitClick(FIRST_ITEM);
        order.setProductName(driver.findElement(ITEM_NAME).getText());
        order.setProductPrice(driver.findElement(ITEM_PRICE).getText());
        driver.findElement(FIRST_ITEM).click();
    }

    public void cancelNotifications() {
        waitUntil(NOTIFICATIO_CANCEL);
        driver.findElement(NOTIFICATIO_CANCEL).click();
    }

    public void openCart() {
        waitClick(CART_BUTTON);
        driver.findElement(CART_BUTTON).click();
    }
}
