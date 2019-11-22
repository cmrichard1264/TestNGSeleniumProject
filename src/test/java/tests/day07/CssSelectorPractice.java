package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
    //Which locator to use?
    //#1 id
    //#2 css
    //#3 xpath
    //## whatever
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //lets fill in all buttons, and click on them one by one
        //why i put "." instead of space? because its 2 class names ".btn.btn-primary"
        //in this case we will find all buttons that have: class="btn btn-primary"
        //or like this [class='btn btn-primary'], no need for "."
        //"." means class name
        //"#" means id
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));
        for(WebElement button: buttons){
            button.click();
            BrowserUtils.wait(1);
            WebElement message = driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());
        }
        //find element with a tag name h3, that has a parent element, with a class name container
        WebElement header = driver.findElement(By.cssSelector(".container > h3"));
        System.out.println(header.getText());

        WebElement p = driver.findElement(By.cssSelector("[class='container'] >p"));
        System.out.println(p.getText());
        driver.quit();







    }












}
