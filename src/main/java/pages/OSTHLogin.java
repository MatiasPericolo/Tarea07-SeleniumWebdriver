package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OSTHLogin {

    WebDriver driver;
    By usernameLabel = By.id("username");
    By passwordLabel = By.id("password");
    By ingresarButton = By.cssSelector("button");
    By pageTitle = By.cssSelector("h2:nth-child(4)");
    By stateText = By.id("estado");

    public OSTHLogin(WebDriver driver){
        this.driver=driver;
    }

    public void setUsernameLabel(String username){
        driver.findElement(usernameLabel).sendKeys(username);
    }

    public void setPasswordLabel(String password){
        driver.findElement(passwordLabel).sendKeys(password);
    }

    public void clickIngresar(){
        driver.findElement(ingresarButton).click();
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public String getStateText(){
        return driver.findElement(stateText).getText();
    }

    public void ingresarAOSTH(String username, String password){
        setUsernameLabel(username);

        setPasswordLabel(password);

        clickIngresar();
    }
}
