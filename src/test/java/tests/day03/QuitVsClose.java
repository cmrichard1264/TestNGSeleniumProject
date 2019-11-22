package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver() ;
        driver.get("http://practice.cybertekschool.com/new_tab");
        Thread.sleep(4000);
        driver.quit();
    }
}
