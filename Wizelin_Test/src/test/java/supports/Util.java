package supports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Util {
    private static WebDriverWait wait;
    public static WebDriver driver;

    public static void openBrowser() {
        initBrowser("chrome");
        driver.manage().window().maximize();
    }

    public static void visit(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebElement getElement(By element) {
        return driver.findElement(element);
    }

    public static List<WebElement> getElements(By element) {
        return driver.findElements(element);
    }

    public static void waitForElementPresent(How how, String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(how.buildBy(locator)));
    }

    public static void waitForElementPresent(By element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void sendKey(By element, String withText) {
        waitForElementPresent(element);
        getElement(element).clear();
        getElement(element).sendKeys(withText);
    }

    public static void click(By element) {
        waitForElementPresent(element);
        getElement(element).click();
    }

    public static void select(By selectBox, int selectIndex) {
        new Select(getElement(selectBox)).selectByIndex(selectIndex);
    }

    public static void select(By selectBox, String selectOption) {
        new Select(getElement(selectBox)).selectByVisibleText(selectOption);
    }

    public static void scrollToViewElement(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", getElement(element));
    }

    public static void scrollToTopPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }

    public static void scrollToBottomPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void setWait() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static String getText(By element) {
        waitForElementPresent(element);
        return getElement(element).getText();
    }

    public static String getAttribute(By element, String attribute) {
        waitForElementPresent(element);
        return getElement(element).getAttribute(attribute);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void focusNewTab(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public static boolean isDisplayed(By element) {
        waitForElementPresent(element);
        return getElement(element).isDisplayed();
    }

    public static boolean isSelected(By element) {
        return getElement(element).isSelected();
    }

    public static boolean isNotDisplayed(By element) {
        return getElements(element).isEmpty();
    }

    public static void initBrowser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.err.println("The browser " + browserName + "is not supported");
        }
    }

    public static void setUp() {
        openBrowser();
    }
}
