package tests;

import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\My Learning\\JAVA\\myTestProject\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Login Test", priority = 1)
    public void login() {
        Properties prop = ConfigUtils.getProps("data");
        driver.get(prop.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("Admin", "admin123");
        String url = driver.getCurrentUrl();
        //Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertTrue(url.contains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));




    }

    @Test(description = "Logout Test", dependsOnMethods = "login", priority = 2)
    public void logout() {
        LoginPage logout = new LoginPage(driver, wait);
        logout.logout();

        // Verification
        String url = driver.getCurrentUrl();
        System.out.println("Page URL after logout: " + url);
        Assert.assertTrue(url.contains("/login"), "Logout failed: URL does not contain '/login'.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
