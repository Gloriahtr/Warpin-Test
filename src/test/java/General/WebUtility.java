package General;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUtility {

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chrome\\chromedriver.exe");
    }

    private static ChromeDriver _driver;

    public static ChromeDriver getChromeInstance() {
        if (_driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            _driver = new ChromeDriver(options);
        }
        return _driver;
    }

    public static void redirectTo(String url) {
        _driver.navigate().to(url );
    }

    public static  void waitAndFill(By id, String value) {
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(id));
        _driver.findElement(id).sendKeys(value);
    }

    public static void waitAndClick(By id) {
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(id));
        _driver.findElement(id).click();
    }

    public static  void waitForPresent(By id) {
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(id));
    }

    public static void ddlSelectItem(By id, String text){
        _driver.findElement(id).sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        WebElement selectedItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-id-2\"]/li/div[text()='" + text + "']")));
        selectedItem.click();
    }

    public static String getText(By by)
    {
       WebElement e=_driver.findElement(by);
       return e.getText();
    }

    public static WebElement pageScrollInView(By by)
    {
        WebElement e =_driver.findElement(by);
        JavascriptExecutor jse = (JavascriptExecutor)_driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",e);
        return e;
    }


}
