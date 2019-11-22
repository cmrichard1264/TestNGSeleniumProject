package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;


public class WindowSwitching {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        //after 3 seconds, another website will be opened in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "Title is wrong");
    }

    @Test(description = "Verify that user is able to see a new window")
    public void test2(){
        driver.findElement(By.linkText("New tab")).click();
        //record id of original window
        String oldWindow = driver.getWindowHandle();
        //after 3 seconds, another website will be opened in the second window
        //selenium doesn't switch automatically to the new window
        BrowserUtils.wait(4);
        //in selenium every window has an id. That id calls window handle
        //to read the window handle we use method " getWindowHandle()"
        //after new window opens, we can get a list of all windows id
        //list - it is a data structure
        //set - is also a data structure, but it doesn't allow duplicates
        //also no access to it
        //there is no .get()  method
        //that's why, we need to loop through the set, to read a data from there
        Set<String> windowHandles = driver.getWindowHandles();
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(oldWindow)){
                driver.switchTo().window(windowHandle);
            }
        }
        //let's verify that title of new window is a Fresh tab
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong!");
        //comeback to original page
        //we can build a function, that will jump, in between windows
        //based on page title
        String pageTitle = "Practice";
        for(String windowHandle : windowHandles){
            //keep jumping from window to window
            driver.switchTo().window(windowHandle);
            //once the page title found Exit
            if(driver.getTitle().equals(pageTitle)){
                break;
            }
        }
        System.out.println(driver.getTitle());

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
