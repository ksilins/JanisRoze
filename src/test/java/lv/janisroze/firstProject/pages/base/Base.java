package lv.janisroze.firstProject.pages.base;

import lv.janisroze.firstProject.model.Order;
import lv.janisroze.firstProject.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static Order order = new Order();
    public static User user = new User();
    protected static WebDriver driver;
    private static String BASE_URL = "https://www.janisroze.lv/lv/";

    public static void startBrowser() {
        String driverPath = "/Users/user/IdeaProjects/QA2Repo/src/test/resources/";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public static void stopBrowser() {
        driver.quit();
    }

    protected static void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected static void waitClick(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
