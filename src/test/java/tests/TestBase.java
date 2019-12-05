package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.ConfigurationReader;
import utils.Driver;

//this class will be a test foundation for all test classes
//we will put here only before and after parts

public abstract class TestBase  {

    //ExtentReports itself does not build any reports, but allows reporters to access information, which in
    //urn build the said reports. An example of building an HTML report and adding information to ExtentX:
    //ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
    //ExtentXReporter extentx = new ExtentXReporter("localhost");
    protected ExtentReports extentReports;

    // The ExtentHtmlReporter creates a rich standalone HTML file.
    //It allows several configuration options via the <code>config()</code> method.
    protected ExtentHtmlReporter extentHtmlReporter;

    //Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){

    }



    @BeforeMethod
    public void setup(){
        String url = ConfigurationReader.getProperty("url");
        Driver.get().get(url);

    }


    @AfterMethod
    public void teardown(){

        Driver.close();
    }
}
