package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.security.PublicKey;

public class FramesPractice {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }

    @Test(description = "iFrame example")
    public void test1() {
        driver.findElement(By.linkText("iFrame")).click();
        //since element inside the frame, element is not visible for selenium
        //without switching to the frame
        //we can switch to frame based on id, name, index(starting from 0). web element
        driver.switchTo().frame("mce_0_ifr");
        //Without switching , we cannot see inner HTML document
        //which one to use< id, name, index , weblelemnt?
        //1. id or name <iframe id="mce_0_ifr";   name = "some_frame">
        //2. webelment driver.findElement(By.cssSelector("iframe[class='some_frame']"));
        //3. index [iframe1, iframe2, iframe3...]
        WebElement inputArea = driver.findElement(By.id("tinymce"));
        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText, expectedText);

        BrowserUtils.wait(2);
        inputArea.clear();
        BrowserUtils.wait(2);
        inputArea.sendKeys("Java is fun!");
        BrowserUtils.wait(2);

        //to exit from the frame
        driver.switchTo().defaultContent();


    }

    //in case of nested frames
    //we must switch to first frame --> then again to another frame, that is inside
    // -- html
    // -- frame #1
    // ---- frame #2
    @Test(description = "Nested Frames Example")
    public void test2() {
        //it's not switch to frame
        //it's a navigation action
        driver.findElement(By.linkText("Nested Frames")).click();
        //we switch to frame based on webelement

        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        //the reason why we are switching here
        //is because content that is inside a frame is not visible for selenium
        //it's like when you are on the first floor
        //trying to find what is on the second floor
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());
        driver.switchTo().defaultContent();//to exit from all frames, got to first floor

        driver.switchTo().frame("frame-top"); //second floor
        driver.switchTo().frame("frame-left");//third floor
        System.out.println(driver.findElement(By.tagName("body")).getText());//print text of body
    }

    //    var btn1 = document.getElementsByTagName('a')[1];
//    btn1.click()
    @Test(description = "Click with JS executor")
    public void test3() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //Example 1 is a beginning of the phrase <a href='http:'>Example 1.....</a>
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        BrowserUtils.wait(2);//wait for demo
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //arguments[0] = link1 web element
        //whenever regular selenium methods are not working, I use js executor
        //or for scrolling
        //arguments[0].click() is an alternative for link1.click()
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);//wait for demo
    }
    //document.getElementsByName('full_name')[0].setAttribute('value','My name')


    @Test(description = "Enter text with JS executor")
    public void test4() {
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));
        //to create javascriptexecutor object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //enter full name
        //arguments[0].setAttribute('value', 'John Smith') it's the same as name.sendKeys("John Smith");
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'someemail@email.com')", email);
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);
        BrowserUtils.wait(2);
    }






    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
