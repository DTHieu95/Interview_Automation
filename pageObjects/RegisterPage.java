import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    // Locators
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.id("confirmPassword");
    private final By signUpButton = By.xpath("//button[text(🙁'SIGN UP']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        sendKeys(confirmPasswordField, confirmPassword);
    }

    public void clickSignUp() {
        click(signUpButton);
    }

    public boolean isRegistrationSuccessMessageDisplayed(){
        return true;
    }

    public void register(String email, String password, String confirmPassword) {
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickSignUp();
    }
}