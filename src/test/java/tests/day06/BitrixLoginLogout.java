package tests.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;



public class BitrixLoginLogout {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/");
        //enter email
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk65@cybertekschool.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//div[@onclick='showUserMenu()']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//*[@id=\"popup-window-content-menu-popup-user-menu\"]/div/div/a[3]")).click();
        BrowserUtils.wait(2);
        driver.quit();
    }
}
