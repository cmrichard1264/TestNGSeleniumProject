package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
