package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class EnterTextPractice2 {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver.findElement(By.name("email"));
        //Keys.Enter will simulate ENTER button press
        input.sendKeys("arichard2020@gmail.com", Keys.ENTER);
        WebElement confirmation = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmation.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.close();
    }
}
