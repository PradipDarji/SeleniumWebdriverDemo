package CommonPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommonUtilitiesMethods {

    public WebDriver driver;

    public CommonUtilitiesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public  boolean clickonDesiredLink(By webElement) {
        try {
            Thread.sleep(5000);
            WebElement generic_WebL = (new WebDriverWait(driver, 90))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));
                generic_WebL.click();
                return true;

        } catch (Exception e) {
            return false;
        }
    }

    public  boolean clickonDesiredLinkusingfindElement(By webElement) {
        try {
            Thread.sleep(5000);
            WebElement generic_WebL = (new WebDriverWait(driver, 90))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));

            if (generic_WebL.isDisplayed()) {
              WebElement webL = driver.findElement(webElement);
                webL.click();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public  boolean enterTextDesiredTextArea(By webElement, String data) {
        try {
            Thread.sleep(5000);
            WebElement generic_WebL = (new WebDriverWait(driver, 90))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));
            if ( generic_WebL.isDisplayed()) {

                generic_WebL.sendKeys(data);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean handleNewWindow() {
        try {
            Set<String> allWindowHandles = driver.getWindowHandles();
            for (String windowHandle : allWindowHandles) {
                driver.switchTo().window(windowHandle);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public  boolean verifyElementPresenDisplayed(By Webelement) {
        try {
            Thread.sleep(5000);
            WebElement generic_WebL = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.visibilityOfElementLocated(Webelement));

            if ( generic_WebL.isDisplayed()) {

                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }



    public WebElement sendKeysToElementByXpath(By xpath, String keys, int wait){
        try{
            Thread.sleep(wait*1000);
            WebElement generic_WebL = (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.elementToBeClickable(xpath));
            generic_WebL.sendKeys(keys);
            return generic_WebL;
        }catch (Exception ex){
            return null;
        }
    }

    public WebElement sendKeysToElement(WebElement element, String keys, int wait){
        try{
            Thread.sleep(wait*1000);
            WebElement generic_WebL = (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            generic_WebL.sendKeys(keys);
            return generic_WebL;
        }catch (Exception ex){
            return null;
        }
    }

    public WebElement clickElementAndWaitByXpath(By xpath, int sleepTimeMS){
        try{
            WebElement generic_WebL = (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.elementToBeClickable(xpath));
            generic_WebL.click();
            Thread.sleep(sleepTimeMS);
            return generic_WebL;
        }catch (Exception ex){
            return null;
        }
    }

    public WebElement clickElementAndWait(WebElement element, int sleepTimeMS){
        try{
            WebElement generic_WebL = (new WebDriverWait(driver,10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            generic_WebL.click();
            Thread.sleep(sleepTimeMS);
            return generic_WebL;
        }catch (Exception ex){
            return null;
        }
    }

    public boolean verifyElementIsTypeableByXpath(By element){
        try{
            sendKeysToElementByXpath(element, "", 2);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean verifyElementIsTypeable(WebElement element){
        try{
            element.sendKeys("");
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean verifyElementIsClickableByXpath(By xpath){
        try{
            WebElement element = (new WebDriverWait(driver,15))
                    .until(ExpectedConditions.elementToBeClickable(xpath));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public WebElement clickOnElementByXpath(By webElement, int wait) {
        try {
            Thread.sleep(wait * 1000);
            WebElement generic_WebL = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));
            generic_WebL.click();
            return generic_WebL;

        } catch (Exception e) {
            return null;
        }
    }

    public boolean clickOnElement(WebElement webElement, int wait) {
        try{
            Thread.sleep(wait * 1000);
            webElement.click();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    // edited
    public boolean findAndClick(By webElement) {
        try {
            waitMS(3000);
            WebElement generic_WebL = (new WebDriverWait(driver, 30))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));
            generic_WebL.click();
            waitMS(1000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyElementVisibleByXpath(By webElement) {
        try {
            Thread.sleep(3000);
            WebElement generic_WebL = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOfElementLocated(webElement));
            return generic_WebL.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String stringifyXpath(By xpath){
        return xpath.toString().substring(10);
    }

    public WebElement verifyElementInListByXpath(String option, List<WebElement> dropdownOptions){

        WebElement element;
        int i = 0;

        while(i < dropdownOptions.size()){
            element = dropdownOptions.get(i);
            if(element.getAttribute("textContent").toLowerCase().contains(option.toLowerCase()))
                return dropdownOptions.get(i);
            i++;
        }
        return null;
    }

    public boolean waitMS(int ms){
        try{
            Thread.sleep(ms);
        }catch (Exception ex){ }
        return true;
    }

    public boolean verifyElementPresent(By element) {
        try {
            WebElement ele = (new WebDriverWait(driver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyElementSelected(By path){
        try {
            WebElement element = (new WebDriverWait(driver,15))
                    .until(ExpectedConditions.presenceOfElementLocated(path));
            return element.isSelected();
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean switchToNewTab(){
        try {
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1)); //need to switch to new tab to work on new page
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean closeTabAndSwitchBack(){
        try {
            driver.switchTo().window(driver.getWindowHandle()).close();
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size() - 1));
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean quickCheck(By path){
        try{
            WebElement element = (new WebDriverWait(driver,1))
                    .until(ExpectedConditions.visibilityOfElementLocated(path));
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
