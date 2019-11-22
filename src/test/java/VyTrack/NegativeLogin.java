package VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

public class NegativeLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // setting environment
        ChromeDriver driver = new ChromeDriver(); // choosing browser
        // driver.get("http://google.com");
        //  BrowserUtils.wait(5); // setting time for demo
        driver.navigate().to("https://qa2.vytrack.com/user/login"); //navigating to the website
        BrowserUtils.wait(1);
        WebElement username = driver.findElement(By.name("_username"));  // navigating to a username functionality
        username.sendKeys("Storemanager225"); //store manager credentials
        BrowserUtils.wait(1);
        WebElement password = driver.findElement(By.name("_password")); //navigating to a password functionality
        password.sendKeys("userUser123");  //store manager password
        BrowserUtils.wait(1);
        WebElement login = driver.findElement(By.id("_submit")) ;  // navigating to LOG IN button
        login.click();  // clicking LOG IN button
        BrowserUtils.wait(1);
        WebElement invalidCredentials = driver.findElement(By.xpath("//div[contains(@class,'alert alert-error')]"));
        String expectedResult = "Invalid user name or password.";
        String actualResult = invalidCredentials.getText();
        if(expectedResult.equals(actualResult)){
            System.out.println("Whoo-Hoo: Test passed");  //if the login successful
        }else{
            System.out.println("Test failed"); // if the login failed
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);

        }

        BrowserUtils.wait(2);

        driver.close(); // close the browser
    }
}
