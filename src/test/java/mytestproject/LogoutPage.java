package mytestproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {

    WebDriver driver;

    By menu = new By.ById("react-burger-menu-btn");
    By logoutFromMenu = new By.ById("logout_sidebar_link");
    By logo = new By.ByClassName("login_logo");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() throws InterruptedException {
        driver.findElement(menu).click();
        WebElement element = driver.findElement(logoutFromMenu);
        element.isDisplayed();
        element.click();
        driver.findElement(logo).isDisplayed();
    }
}
