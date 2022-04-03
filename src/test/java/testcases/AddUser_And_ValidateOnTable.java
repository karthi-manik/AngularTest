package testcases;

import actions.AddUser;
import com.aventstack.extentreports.Status;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.Utils;
import utilities.reports.ExtentTestManager;

public class AddUser_And_ValidateOnTable {

    public WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    // Following TestNg Test case pattern, and divided a Test case in to three different part.
    // In Before Method, your code will always be the same for every other test case.
    // In other way before method is your prerequisites of your main Test Case
    @BeforeMethod
    public void beforeMethod() throws Exception {

        DOMConfigurator.configure("log4j.xml");

        // Getting the Test Case name, as it will going to use in so many places
        // The main use is to get the TestCase row from the Test Data Excel sheet
        sTestCaseName = this.toString();

        // From above method we get long test case name including package and class name etc.
        // The below method will refine your test case name, exactly the name use have used
        sTestCaseName = Utils.getTestCaseName(this.toString());

        // Start printing the logs and printing the Test Case name
        Log.startTestCase(sTestCaseName);
        ExtentTestManager.startTest(sTestCaseName);

        // Setting up the Test Data Excel file using Constants variables
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

        // Fetching the Test Case row number from the Test Data Sheet
        // This row number will be feed to so many functions, to get the relevant data from the Test Data sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

        // Launching the browser, this will take the Browser Type from Test Data Sheet
        driver = Utils.LaunchURL(iTestCaseRow);
        ExtentTestManager.getTest().log(Status.PASS, "App is successfully Launched");

        // Initializing the Base Class for Selenium driver
        // Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
        new BaseClass(driver);
    }

    // This is the starting of the Main Test Case
    @Test
    public void main() throws Exception {

        // Every exception thrown from any class or method, will be catch here and will be taken care off

        try{

            AddUser.fnAddUser(iTestCaseRow);
            ExtentTestManager.getTest().log(Status.PASS, "Add User is successfully done and validated");


            // Now your test is about to finish but before that you need to take decision to Pass your test or Fail
            // For selenium your test is pass, as you do not face any exception and you come to the end or you test did not stop anywhere
            // But for you it can be fail, if any of your verification is failed
            // This is to check that if any of your verification during the execution is failed

            if(BaseClass.bResult==true){
                // If the value of boolean variable is True, then your test is complete pass and do this
                ExcelUtils.setCellData("Passed", iTestCaseRow, Constant.Col_Result);
            }else{
                // If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
                // This is to throw exception in case of fail test, this exception will be caught by catch block below
                throw new Exception("Test Case Failed because of Verification");
            }

            // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test
        }catch (Exception e){

            // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
            ExcelUtils.setCellData("Failed", iTestCaseRow, Constant.Col_Result);
            ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

            // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot

            Utils.takeScreenshot(driver, sTestCaseName);
            // This will print the error log message
            Log.error(e.getMessage());
            // Again throwing the exception to fail the test completely in the TestNG results
            throw (e);
        }

    }

    // Its time to close the finish the test case

    @AfterMethod
    public void afterMethod() {

        // Printing beautiful logs to end the test case
        Log.endTestCase(sTestCaseName);
            driver.close();
        ExtentTestManager.endTest();

    }


}
