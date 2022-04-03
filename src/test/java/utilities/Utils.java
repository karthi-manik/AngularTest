package utilities;

import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import utilities.reports.ExtentTestManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver driver;

    public static WebDriver LaunchURL(int iTestCaseRow) throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/kram3014/OneDrive - 7-Eleven, Inc/Pratices/AngularTest/Driver/chromedriver 3");

        driver = new ChromeDriver();

        String URL = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_URL);
        driver.get(URL);

        driver.manage().window().maximize();

        return driver;
    }

    public static String getTestCaseName(String sTestCase)throws Exception{

        String value = sTestCase;
        try{
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;

        }catch (Exception e){
            Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
            throw (e);
        }

    }

    public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
        try{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));
        } catch (Exception e){
            Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
            throw new Exception();
        }
    }
}
