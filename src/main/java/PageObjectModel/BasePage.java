package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "E:\\My Learning\\JAVA\\myTestProject\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
