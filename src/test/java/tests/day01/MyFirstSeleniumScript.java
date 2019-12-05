package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        //setup webdriver based on the browser we need
        WebDriverManager.chromedriver().setup();
        //create an object of appropriate class
        ChromeDriver driver = new ChromeDriver();
        //get method allows to open the website
        driver.get("http://google.com");





        //getTitle();   is a method to read page title

    }
}
