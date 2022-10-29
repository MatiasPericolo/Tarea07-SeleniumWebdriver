package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OSTHHome;
import pages.OSTHLogin;

public class TestOSTHLogin {

    String dirverPath = "C:\\Users\\Peri\\Downloads\\chromedriver.exe";
    WebDriver driver;
    OSTHLogin pageLogin;
    OSTHHome pageHome;

    @BeforeEach
    public void setup() {

        System.setProperty("webdriver.chrome.driver",dirverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cs.uns.edu.ar/~mll/temp/testing/examen/login.html");

    }

    @Test
    public void case1(){
        pageLogin = new OSTHLogin(driver);

        Assertions.assertEquals(pageLogin.getPageTitle(),"Obra Social de los Trabajadores de Hogwarts");

        pageLogin.ingresarAOSTH("","");

        Assertions.assertEquals(pageLogin.getStateText(),"Atención: Debe ingresar un nombre de usuario");

    }

    @Test
    public void case2(){
        pageLogin = new OSTHLogin(driver);

        Assertions.assertEquals(pageLogin.getPageTitle(),"Obra Social de los Trabajadores de Hogwarts");

        pageLogin.ingresarAOSTH("dumbridge","");

        Assertions.assertEquals(pageLogin.getStateText(),"Atención: El password no puede estar vacío");

    }

    @Test
    public void case3(){
        pageLogin = new OSTHLogin(driver);

        Assertions.assertEquals(pageLogin.getPageTitle(),"Obra Social de los Trabajadores de Hogwarts");

        pageLogin.ingresarAOSTH("dumbridge","tomriddle");

        pageHome = new OSTHHome(driver);

        Assertions.assertEquals(pageHome.getPageTitle(),"Bienvenido a OSTH On-Line");

    }

    @Test
    public void case4(){
        pageLogin = new OSTHLogin(driver);

        Assertions.assertEquals(pageLogin.getPageTitle(),"Obra Social de los Trabajadores de Hogwarts");

        pageLogin.ingresarAOSTH("dumbridge","nottomriddle");

        Assertions.assertEquals(pageLogin.getStateText(),"Atención: El password ingresado no es válido");

    }
}
