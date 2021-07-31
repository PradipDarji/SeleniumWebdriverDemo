package SighUpTS;

import Base.BaseTest;
import ExtendReport.ExtentTestManager;
import SighUpPO.SighUpPO;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SighUPTC extends BaseTest{

    public int flag=1;

    public SighUPTC() {
    }

    public SighUPTC(WebDriver passDriver, int Flag) {
        driver=passDriver;
        flag=Flag;
    }


    //Created by: Ravi Jogiya on 27-06-2018.
    @Test
    public void createNewUser(){
        if (flag > 0) {
            ExtentTestManager.getTest().getTest().setName("Test-1:Create new user");
            ExtentTestManager.getTest().assignCategory("Component: Sigh Up");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "Execution Start for Test-1");

        SighUpPO sighUpPO=new SighUpPO(driver);

        String userName="Ravi";
        String password="Jogiya";


        //Step-1: Click on 'Add User' Link
        Assert.assertTrue(sighUpPO.clickOnElement(sighUpPO.addUserLink_xpath), "Unable to Click on 'Add User' Link");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Add User' Link", "Clicked 'Add User' Link");

        //Step-2: Enter Username
        Assert.assertTrue(sighUpPO.inputText(sighUpPO.sighnUpUser_xpath,userName), "Unable to Enter Username");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Username", "Test data :"+userName);

        //Step-2: Enter Password
        Assert.assertTrue(sighUpPO.inputText(sighUpPO.sighnUpPassword_xpath,password), "Unable to Enter Password");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Enter Password", "Test data :"+password);

        //Step-4: Click on 'Save' button
        Assert.assertTrue(sighUpPO.clickOnElement(sighUpPO.saveButton_xpath), "Unable to Click on 'Save' button");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Click on 'Save' button", "Clicked 'Save' button");
    }

}
