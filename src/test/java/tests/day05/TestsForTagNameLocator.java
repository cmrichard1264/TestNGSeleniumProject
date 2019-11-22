package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsForTagNameLocator {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        driver.findElement(By.name("email")).sendKeys("test_email@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());




       driver.quit();

    }
}
