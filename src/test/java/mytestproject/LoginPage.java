package mytestproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class LoginPage {

    WebDriver driver;
    By username = new By.ById("user-name");
    By password = new By.ById("password");
    By submitBtn = new By.ByClassName("submit-button");
    By loginBtn = new By.ById("login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        Properties prop = ConfigUtils.getProps(("data"));

        driver.findElement(username).sendKeys(prop.getProperty("username"));
        driver.findElement(password).sendKeys(prop.getProperty("password"));
        driver.findElement(loginBtn).isEnabled();
        driver.findElement(submitBtn).click();
    }
}
