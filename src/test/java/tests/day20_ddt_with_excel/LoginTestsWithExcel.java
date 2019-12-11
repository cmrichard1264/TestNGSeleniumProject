package tests.day20_ddt_with_excel;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Map;

public class LoginTestsWithExcel extends TestBase {

    @Test(dataProvider = "credentials", description = "Login with different credentials")
    public void loginTest(String username, String password, String firstName, String lastName, String result) {
        extentTest = extentReports.createTest(("Login as " + username));
        if (username.equals("username")) {
            throw new SkipException("Test was skipped because it's first row!");
        } else {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            BrowserUtils.waitForPageTitle("Dashboard");
            Assert.assertEquals(Driver.get().getTitle(), "Dashboard");
            extentTest.pass("Login test passed for user " + username);
        }
    }

    //is a test data supplier
    //as many sets of data it returns
    //as many times exactly same test will run
   @DataProvider(name = "credentials")
    public static Object[][] credentials(){
        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        return qa2.getDataArray();
    }

















    public static void main(String[] args) {

        ExcelUtil qa2 = new ExcelUtil("vytrack_testusers.xlsx", "QA2-short");
        System.out.println("Row count: "+ qa2.rowCount());
        System.out.println("Column count: "+qa2.columnCount());
        System.out.println(qa2.getColumnsNames());
        //map is a data structure
        for(Map<String, String> map : qa2.getDataList()){
            System.out.println(map.get("username"));
        }






    }


}
