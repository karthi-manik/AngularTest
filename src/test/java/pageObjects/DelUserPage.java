package pageObjects;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.reports.ExtentTestManager;

import java.util.List;

public class DelUserPage extends BaseClass {

    public DelUserPage(WebDriver driver) {
        super(driver);
    }

    public static By waitForAddUserPopup(){
        try{
            By element = By.xpath("//h3[text()='Add User']");
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }

    }

    public static List<WebElement> lstUserName(){
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']//td[3]"));
            return elements;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static List<WebElement> lstDel(){
        try {
            List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='smart-table-data-row ng-scope']//td[11]/button"));
            return elements;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }
    public static WebElement btnDelOkConfirm(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[text()='OK']"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }
}
