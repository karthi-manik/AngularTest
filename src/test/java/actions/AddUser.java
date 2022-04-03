package actions;

import jdk.incubator.jpackage.internal.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AddUserPage;
import pageObjects.BaseClass;
import utilities.ExcelUtils;

import java.util.List;

public class AddUser extends BaseClass {

    static WebDriverWait wait = new WebDriverWait(driver, 60);

    public AddUser(WebDriver driver) {
        super(driver);
    }

    public static void fnAddUser(int iTestCaseRow) throws Exception {

        String[] UserData = new String[8];

        for(int i=0; i<UserData.length; i++){
            UserData[i] = ExcelUtils.getCellData(iTestCaseRow, i+2);
        }
        Log.info("Data is retrieved from Test Data Sheet");

        AddUserPage.linkAddUser().click();
        Log.info("Add User Link is clicked");

        wait.until(ExpectedConditions.presenceOfElementLocated(AddUserPage.waitForAddUserPopup()));
        Log.info("Waited till Add User Popup is displayed");

        AddUserPage.txtFirstName().sendKeys(UserData[0]);
            Log.info("First Name is entered");
        AddUserPage.txtLastName().sendKeys(UserData[1]);
            Log.info("Last Name is entered");
        AddUserPage.txtUserName().sendKeys(UserData[2]);
            Log.info("UserName is entered");
        AddUserPage.txtPassword().sendKeys(UserData[3]);
            Log.info("Password is entered");
        AddUserPage.radioCustomer(UserData[4]).click();
            Log.info("Customer Radio button is selected");
        AddUserPage.drpRole().click();
            Log.info("Role dropdown is clicked");
        Select sel = new Select(AddUserPage.drpRole());
        sel.selectByValue(UserData[5]);
            Log.info("Role is selected from dropdown");
        AddUserPage.txtEmail().sendKeys(UserData[6]);
            Log.info("Email is entered");
        AddUserPage.txtCellPhone().sendKeys(UserData[7]);
            Log.info("Cell Phone number is entered");
        AddUserPage.btnSave().click();
            Log.info("Save button is clicked");

        Assert.assertEquals(AddUserPage.valUserName().getText(),UserData[2]);
            Log.info("Assert Successful");

    }



}
