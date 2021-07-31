package SighUpPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SighUpPO {

    public WebDriver driver;

    public SighUpPO(WebDriver driver) {
        this.driver=driver;
    }

    /********************** Start Locators **********************/

    public By addUserLink_xpath=By.xpath("//a[contains(.,'3. Add a User')]");
    public By sighnUpUser_xpath=By.xpath("//input[@name='username']");
    public By sighnUpPassword_xpath=By.xpath("//input[@name='password']");
    public By saveButton_xpath=By.xpath("//input[@type='button']");

    /********************** End Locators **********************/




    /********************** Start Methods **********************/

    public  boolean clickOnLink() {
        try {
            driver.findElement(addUserLink_xpath).click();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    //Click on element
    public  boolean clickOnElement(By webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            WebElement generic_WebL = (new WebDriverWait(driver, 90))
                    .until(ExpectedConditions.presenceOfElementLocated(webElement));
            generic_WebL.click();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    //Enter data
    public boolean inputText(By webElement,String inputTextData){
        try{

           WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));

            WebElement input= (new WebDriverWait(driver,30)).
                    until(ExpectedConditions.presenceOfElementLocated(webElement));

            input.click();
            input.clear();
            input.sendKeys(inputTextData);

            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    /********************** End Methods **********************/
}
