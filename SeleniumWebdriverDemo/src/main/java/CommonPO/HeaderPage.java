package CommonPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {

    public WebDriver driver;
    public CommonUtilitiesMethods util;

    public By userSettingsButton_xpath = By.xpath("//*[@id='navbar']/descendant::i[@class='settingicon']/descendant::img[@class='user-settings-icon']");

    public HeaderPage(WebDriver driver){
        this.driver=driver;
        this.util = new CommonUtilitiesMethods(driver);
    }

    //POM: Verify User Setting text
    public boolean verifyUserSettingsButton(){
        try {
            WebElement userSettingsWebL=(new WebDriverWait(driver,30))
                    .until(ExpectedConditions.visibilityOfElementLocated(userSettingsButton_xpath));
          if(driver.findElement(userSettingsButton_xpath).isDisplayed())
          {
              return true;
          }
          else
               return false;
        }
        catch (Exception ex){
            return false;
        }
    }
}
