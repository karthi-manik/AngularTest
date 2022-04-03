package pageObjects;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.reports.ExtentTestManager;

import java.util.List;

public class AddUserPage extends BaseClass {

    public AddUserPage(WebDriver driver) {
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

    public static WebElement linkAddUser(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-link pull-right']"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtFirstName(){
        try {
            WebElement element = driver.findElement(By.name("FirstName"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtLastName(){
        try {
            WebElement element = driver.findElement(By.name("LastName"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtUserName(){
        try {
            WebElement element = driver.findElement(By.name("UserName"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtPassword(){
        try {
            WebElement element = driver.findElement(By.name("Password"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement radioCustomer(String Cust){
        try {
            List<WebElement> elements = driver.findElements(By.name("optionsRadios"));
            WebElement element = elements.get(0);
            switch(Cust){
                case "Company AAA":
                    element = elements.get(0);
                    break;

                case "Company BBB":
                    element = elements.get(1);
                    break;
            }
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement drpRole(){
        try {
            WebElement element = driver.findElement(By.name("RoleId"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtEmail(){
        try {
            WebElement element = driver.findElement(By.name("Email"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement txtCellPhone(){
        try {
            WebElement element = driver.findElement(By.name("Mobilephone"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement btnSave(){
        try {
            WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

    public static WebElement valUserName(){
        try {
            WebElement element = driver.findElement(By.xpath("//tr[@class='smart-table-data-row ng-scope']//td[3]"));
            return element;
        }catch(ElementNotVisibleException e){
            ExtentTestManager.getTest().log(Status.FAIL, e);
            return null;
        }
    }

}
