package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigUtils;

import java.util.Properties;

public class main {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set the path for the ChromeDriver
            System.setProperty("webdriver.chrome.driver", "E:\\My Learning\\JAVA\\myTestProject\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            Properties prop = ConfigUtils.getProps("data");
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // Navigate to the login page
            driver.get(prop.getProperty("url"));  //used data driven method
            //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Create an instance of the LoginPage
            LoginPage loginPage = new LoginPage(driver, wait);

            // Perform login
            loginPage.login("Admin", "admin123");

            // Wait for the dashboard to be loaded
            WebElement dashboardElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app")));
            if (dashboardElement != null) {
                System.out.println("Login successfully!");
            } else {
                System.out.println("Login failed!");
            }

            //Create instance of Logout
            LoginPage logout = new LoginPage(driver, wait);

            // Perform logout
            logout.logout();

            //verification
            String url = driver.getCurrentUrl();
            System.out.println("Page URL after logout: " + url);
            if (url.contains("/login"))
                System.out.println("logout successfully");


        } catch (Exception e) {
            System.out.println("Error during execution: " + e.getMessage());
        } finally {
            if (driver != null) {
                // Close the browser after a delay
                try {
                    Thread.sleep(2000);  // Wait for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.quit();
            }
        }
    }
}
