package mytestproject.tests;

import mytestproject.LoginPage;
import mytestproject.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigUtils;

import java.time.Duration;
import java.util.Properties;

public class Tests {

    LoginPage loginPage;
    LogoutPage logoutPage;
    WebDriver driver;

    @BeforeClass
    public void baseURL() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        Properties prop = ConfigUtils.getProps(("data"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("URL"));
    }

    @Test(description = "User login into Swag Labs", priority=1)
    public void login() {
        loginPage = new LoginPage(driver);
        loginPage.login();

        String text = driver.findElement(By.className("title")).getText();
        if (text.contains("Products"))
            System.out.println("Login successfully");
        Assert.assertEquals(text, "Products");
        Assert.assertTrue(text.contains("Products"));
    }

    @Test(description = "User logout from Swag Labs", priority=2)
    public void logout() throws InterruptedException {
        logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        String title = driver.getTitle();
        System.out.println("Page title: "+title);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        System.out.println("Logout successfully");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
