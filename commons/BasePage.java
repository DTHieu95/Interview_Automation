import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) {
        waitElementClickable(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement textbox = waitElementVisible(locator);
        textbox.clear();
        textbox.sendKeys(text);
    }

    protected WebElement waitElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}