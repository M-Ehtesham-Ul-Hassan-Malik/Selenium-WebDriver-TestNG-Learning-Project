package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Correct locators for the username and password fields
    By usernameField = By.name("username");
    By passwordField = By.name("password");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String username, String password) {
        try {
            WebElement usernameElement = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
            usernameElement.sendKeys(username);
            WebElement passwordElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
            passwordElement.sendKeys(password);
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
            loginButton.click();
            System.out.println("Login button clicked");
        } catch (Exception e) {
            System.out.println("Login page elements not found: " + e.getMessage());
        }
    }

    public void logout() {
        try {
            WebElement profileMenu = wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-tab")));
            profileMenu.click();

            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/auth/logout']")));
            logoutLink.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
        }
    }
}
