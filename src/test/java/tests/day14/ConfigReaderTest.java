package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {
    /* #browser type
       browser=chrome
       #url of our application
       url=https://qa1.vytrack.com/

       #credentials
       user_name=storemanager85
       password=UserUser123*/

    @Test
    public void test1() {
        String expectedBrowser = "chrome";
        //we write keys in "key" as a String
        //as a return, you will get value
        //key=value
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
        System.out.println(ConfigurationReader.getProperty("url"));
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));
    }
}







