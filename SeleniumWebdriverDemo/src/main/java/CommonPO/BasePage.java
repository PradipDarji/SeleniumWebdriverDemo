package CommonPO;

import org.openqa.selenium.WebDriver;

/**
 * Created by tanupam on 17-05-2017.
 */
public class BasePage {

    public WebDriver driver;
    public HeaderPage headerPage;
    public CommonUtilitiesMethods util;

    public BasePage(WebDriver driver){
        this.driver = driver;
        headerPage = new HeaderPage(driver);

        util = new CommonUtilitiesMethods(driver);
    }

    public CommonUtilitiesMethods getUtil() { return util; }

    public HeaderPage getHeaderPage(){
        return headerPage;
    }

    /*public void sleepFor(int seconds){
        try {
            Thread.sleep(1000*seconds);
        }catch (Exception e){
            System.out.println(e);
            return;
        }
    }*/
}
