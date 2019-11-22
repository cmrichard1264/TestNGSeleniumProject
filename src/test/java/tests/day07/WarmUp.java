package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println("Number of links: "+links.size());
        for(WebElement webElement: links){
            System.out.println(webElement.getText());
        }
        driver.quit();










    }
}
