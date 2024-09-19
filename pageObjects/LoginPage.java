import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private final By registerLink = By.linkText("Sign Up");
    private final By emailField = By.id("Rl8t6l6");
    private final By passwordField = By.id("Rl956l6");
    private final By loginButton = By.xpath("//button[text(🙁'Log In']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegisterPage() {
        click(registerLink);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public boolean isUserLoggedIn(){
        return true;
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}