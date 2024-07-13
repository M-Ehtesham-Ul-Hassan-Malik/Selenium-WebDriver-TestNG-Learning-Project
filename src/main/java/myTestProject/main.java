package myTestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class main {
    public static void main(String[] args) {
        try {
            // Set the path for the ChromeDriver
            System.setProperty("webdriver.chrome.driver", "E:\\My Learning\\JAVA\\myTestProject\\chromedriver-win64\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            // Navigate to the login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Create a WebDriverWait instance with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // Wait until the username field is present and enter the username
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
            usernameField.sendKeys("Admin");

            // Wait until the password field is present and enter the password
            WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
            passwordField.sendKeys("admin123");

            // Wait until the login button is clickable and click it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-button")));
            loginButton.click();

            // Wait for the dashboard to be loaded
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app")));

            // Print page source for debugging
//            String pageSource = driver.getPageSource();
//            System.out.println("Page source after login attempt:");
//            System.out.println(pageSource);


            // Wait for the profile menu to be clickable and click it
            WebElement profileMenu = wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-tab")));
            profileMenu.click();

            // Wait for the logout link to be clickable and click it
            WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/auth/logout']")));
            logoutLink.click();

            // Wait for the login page to be loaded again
            wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));

            // Print the title and URL of the page
            String title = driver.getTitle();
            System.out.println("Page Title after logout: " + title);

            String url = driver.getCurrentUrl();
            System.out.println("Page URL after logout: " + url);

            // Close the browser after a delay
            Thread.sleep(10000);  // Wait for 10 seconds
            driver.quit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
