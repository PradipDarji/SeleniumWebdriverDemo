package LoginPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO {
    public WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver=driver;
    }

    /********************** Start Locators **********************/

    public By loginLink_xpath=By.xpath("//a[contains(.,'4. Login')]");
    public By username_xpath=By.xpath("//input[@name='username']");
    public By password_xpath=By.xpath("//input[@name='password']");
    public By loginButton_xpath=By.xpath("//input[@type='button']");
    public By successMsg_xpath=By.xpath("//b[contains(.,'**Successful Login**')]");

    /********************** End Locators **********************/

    /********************** Start Methods **********************/

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

    public boolean verifyFileds(By fieldxpath) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(ExpectedConditions.visibilityOfElementLocated(fieldxpath));

            WebElement filds = (new WebDriverWait(driver, 90))
                    .until(ExpectedConditions.visibilityOfElementLocated(fieldxpath));
            if (filds.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    /********************** End Methods **********************/
}
