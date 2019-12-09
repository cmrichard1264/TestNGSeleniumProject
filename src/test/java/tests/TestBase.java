package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;

//this class will be a test foundation for all test classes
//we will put here only before and after parts

public abstract class TestBase  {

    //ExtentReports itself does not build any reports, but allows reporters to access information, which in
    //urn build the said reports. An example of building an HTML report and adding information to ExtentX:
    //ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
    //ExtentXReporter extentx = new ExtentXReporter("localhost");
    protected static ExtentReports extentReports;

    // The ExtentHtmlReporter creates a rich standalone HTML file.
    //It allows several configuration options via the <code>config()</code> method.
    protected static ExtentHtmlReporter extentHtmlReporter;

    //Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected static ExtentTest extentTest;

    @BeforeTest
    @Parameters({"test", "env_url"})
    public void beforeTest(@Optional String test, @Optional String env_url){
        //location of report
        //going to ne next to target folder, test-output folder
        String reportName = "report";
        if(test != null){
            reportName = test;
        }
        String filePath = System.getProperty("user.dir")+"/test-output/"+reportName+".html";
        extentReports = new ExtentReports();
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("Vytrack Test Results");
        //system information
        String env = ConfigurationReader.getProperty("url");
        if(env_url != null){
            env = env_url;
        }
        extentReports.setSystemInfo("Environment", env);
        extentReports.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }


    @AfterTest
    public void afterTest(){
        //writes test information from the started reporters to their output view
        extentReports.flush();
    }


    @BeforeMethod
    @Parameters("env_url")
    public void setup(@Optional String env_url){
        String url = ConfigurationReader.getProperty("url");
        if(env_url != null){
            url = env_url;
        }
        Driver.get().get(url);
    }

    //ITesTResult class describes the result of a test.(in TestNG)
    @AfterMethod
    public void teardown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getName());
            extentTest.fail(result.getThrowable());
            try {
                //BrowserUtils.getScreenshot(result.getName()) - takes screenshot and returns location of that screenshot
                extentTest.addScreenCaptureFromPath(BrowserUtils.getScreenshot(result.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test case was skipped : "+result.getName());
        }


        Driver.close();
    }




}
