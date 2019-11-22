package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttributesTest {

    public static void main(String[] args) {


        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("arichard2020@gmail.com");
        System.out.println(input.getAttribute("value"));
        WebElement retrieve =driver.findElement(By.id("form_submit"));
        retrieve.submit();
        driver.close();
    }
}
