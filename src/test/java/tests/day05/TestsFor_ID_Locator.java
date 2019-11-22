package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestsFor_ID_Locator {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);
        WebElement button = driver.findElement(By.id("disappearing_button"));
        button.click();
        BrowserUtils.wait(2);

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());
        driver.quit();
    }
}
