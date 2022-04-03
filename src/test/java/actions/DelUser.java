package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.AddUserPage;
import pageObjects.BaseClass;
import pageObjects.DelUserPage;
import utilities.Constant;
import utilities.ExcelUtils;
import utilities.Log;

import java.util.List;

public class DelUser extends BaseClass {

    static WebDriverWait wait = new WebDriverWait(driver, 60);

    public DelUser(WebDriver driver) {
        super(driver);
    }

    public static void fnDelUser(int iTestCaseRow) throws Exception {

        String UserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        Log.info("Username is retrieved from Test Data Sheet");

        List<WebElement> elements1 = DelUserPage.lstUserName();
            Log.info("List of all Usernames are retrieved from web table");

        int i=0;
        for(WebElement element: elements1){
            //System.out.println(element.getText());
            if(element.getText().equals(UserName)) {
                List<WebElement> elements2 = DelUserPage.lstDel();
                    Log.info("List of Delete links are retrieved");
                for(int j=0; j<elements2.size(); j++){
                    if(j==i){
                        elements2.get(j).click();
                        Log.info("Delete corresponding to Username retrieved from data sheet is clicked");
                        DelUserPage.btnDelOkConfirm().click();
                        Log.info("OK button on confirmation popup is clicked");
                    }
                }
            }
            i++;
        }

        List<WebElement> elements3 = DelUserPage.lstUserName();
            Log.info("Updated List of Usernames are retrieved from web table");

        for(WebElement element: elements3){
            Assert.assertNotEquals(element.getText(), UserName);
                Log.info("Assert successfully done");
        }

    }



}
