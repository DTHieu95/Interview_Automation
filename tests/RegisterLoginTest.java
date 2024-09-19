import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    private static String email;
    private static String password;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

        // Generate unique email and password for this test run
        email = "test" + System.currentTimeMillis() + "@example.com";
        password = "SecurePass" + System.currentTimeMillis();

    }

    @BeforeMethod
    public void navigateToURL(){
        driver.get("https://account.tokenize.exchange/login");
    }

    @Test(priority = 1)
    public void testSuccessfulRegistration() {
        loginPage.navigateToRegisterPage();

        registerPage.register(email, password, password);

        Assert.assertTrue(registerPage.isRegistrationSuccessMessageDisplayed(), "Registration success message not displayed");
    }

    @Test(priority = 2, dependsOnMethods = "testSuccessfulRegistration")
    public void testSuccessfulLogin() {
        loginPage.login(email, password);

        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in after login attempt");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}