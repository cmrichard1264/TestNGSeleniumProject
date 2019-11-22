package VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class Login {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // setting environment
        ChromeDriver driver = new ChromeDriver(); // choosing browser
       // driver.get("http://google.com");
      //  BrowserUtils.wait(5); // setting time for demo
        driver.navigate().to("https://qa2.vytrack.com/user/login"); //navigating to the website
        BrowserUtils.wait(5);
        WebElement username = driver.findElement(By.name("_username"));  // navigating to a username functionality
        username.sendKeys("storemanager225"); //store manager credentials
        BrowserUtils.wait(5);
        WebElement password = driver.findElement(By.name("_password")); //navigating to a password functionality
        password.sendKeys("UserUser123");  //store manager password
        BrowserUtils.wait(5);
        WebElement login = driver.findElement(By.id("_submit")) ;  // navigating to LOG IN button
        login.click();  // clicking LOG IN button
        BrowserUtils.wait(5);
        String expectedResult = "https://qa2.vytrack.com/";
        String actualResult = driver.getCurrentUrl();
        if(expectedResult.equals(actualResult)){
            System.out.println("Whoo-Hoo: Test passed");  //if the login successful
        }else{
            System.out.println("Test failed"); // if the login failed
        }

        BrowserUtils.wait(3);

        driver.close(); // close the browser
    }
}
