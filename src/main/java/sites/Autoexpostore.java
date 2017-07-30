package sites;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Andrey on 24.07.2017.
 */
public class Autoexpostore extends Base {

    @BeforeClass
    public static void setBatch() {
        batch = new BatchInfo("Autoexpostore");
    }

    @Test
    public void english_Laptop_HomePage() {
        eyes.open(driver,"Autoexpostore", "english_Laptop", getScreenSize("Home"));
        driver.get("http://www.autoexpostore.com/");
        waitFullPageLoading();
        eyes.checkWindow("Header");
        scrollToElement(driver,driver.findElement(By.className("home-about")));
        eyes.checkWindow("About AutoExpo");
        scrollToElement(driver,driver.findElement(By.className("block-name")));
        eyes.checkWindow("Search Vehicle by Body type + Advanced Search");
        scrollToElement(driver,driver.findElement(By.className("footer-list")));
        eyes.checkWindow("Footer");
        eyes.close();
    }

    @Test
    public void english_GalaxyS5_360_640_HomePage() {
        eyes.open(driver,"Autoexpostore", "english_GalaxyS5_HomePage", getScreenSize("Galaxy S5"));
        driver.get("http://www.autoexpostore.com/");
        //waitFullPageLoading();
        eyes.checkWindow("Header");
        scrollToElement(driver,driver.findElement(By.className("home-about")));
        eyes.checkWindow("About AutoExpo");
        scrollToElement(driver,driver.findElement(By.className("footer-list")));
        eyes.checkWindow("Footer");
        eyes.close();
    }

    @Test
    public void english_Laptop_Inventory() {
        eyes.open(driver,"Autoexpostore", "english_Laptop_Inventory", getScreenSize("Home"));
        driver.get("http://www.autoexpostore.com/cars-for-sale.html");
        //waitFullPageLoading();
        eyes.checkWindow("Header");
        scrollToElement(driver,driver.findElement(By.className("footer-list")));
        eyes.checkWindow("Footer");
        eyes.close();
    }

    @Test
    public void english_Laptop_Get_pre_approved()throws Exception {
        eyes.open(driver,"Autoexpostore", "english_Laptop_Get_pre_approved", getScreenSize("Home"));
        driver.get("http://www.autoexpostore.com");
        Thread.sleep(3000);
        driver.findElements(By.cssSelector(".nav.navbar-nav>li")).get(10).click();
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".modul-r-iframe.nowow"))));
        scrollToElement(driver,driver.findElement(By.cssSelector(".modul-r-iframe.nowow")));
        Thread.sleep(5000);
        eyes.checkWindow("Form");
        scrollToElement(driver,driver.findElement(By.cssSelector("div[data-container = 'footer']")));
        eyes.checkWindow("Footer");
        eyes.close();
    }

    /*@Test
    public void spanish_Laptop_1650_650_HomePage() {
        eyes.open(driver,"test app", "spanish_Laptop_1650_650_HomePage", new RectangleSize(1300, 600));
        driver.get("http://www.autoexpostore.com/");
        waitFullPageLoading();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".header-socials"))).moveByOffset(-1000, 0).click().perform();
        driver.findElements(By.cssSelector(".languageName")).get(1).click();
        waitFullPageLoading();
        eyes.checkWindow("Header");
        scrollToElement(driver,driver.findElement(By.className("home-about")));
        eyes.checkWindow("AboutAutoExpo");
        scrollToElement(driver,driver.findElement(By.className("block-name")));
        eyes.checkWindow("Search Vehicle by Body type + Advanced Search");
        scrollToElement(driver,driver.findElement(By.className("footer-list")));
        eyes.checkWindow("Footer");
        eyes.close();
    }*/








}
