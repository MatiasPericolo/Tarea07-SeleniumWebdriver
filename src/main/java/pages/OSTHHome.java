package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OSTHHome {
    WebDriver driver;
    By pageTitle = By.cssSelector("h3");

    public OSTHHome(WebDriver driver){
        this.driver=driver;
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
}
