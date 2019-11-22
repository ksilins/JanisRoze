package lv.janisroze.firstProject.pages;

import lv.janisroze.firstProject.pages.base.Base;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage extends Base {

    private static By ADD_TO_CART_BUTTON = By.id("product-addtocart-button");
    private static By PRODUCT_NAME = By.cssSelector(".product-name  > h1");
    private static By PRODUCT_PRICE = By.cssSelector(".product-type-data .price");

    public void addToCart() {
        waitUntil(PRODUCT_NAME);
        assertThat(driver.findElement(PRODUCT_NAME).getText()).isEqualToIgnoringCase(order.getProductName());
        assertThat(driver.findElement(PRODUCT_PRICE).getText()).isEqualToIgnoringCase(order.getProductPrice());
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }
}
