package sites;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 24.07.2017.
 */
public class Autoexpostore {
    private static BatchInfo batch;
    private WebDriver driver;
    private WebDriverWait wait;
    private Eyes eyes;

    @BeforeClass
    public static void setBatch(){
        batch = new BatchInfo("Autoexpostore");
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        eyes = new Eyes();
        eyes.setApiKey("42ocIyb2h7fn4sJyi0zODSOvI3glY118F26yVtRUB5c110");
        eyes.setBatch(batch);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void correctCredentials() {
        eyes.open(driver,"test app", "CorrectCredentials", new RectangleSize(1300, 600));
        driver.get("http://www.andreyb.ixloo.com/dms");
        waitFullPageLoading();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"#login2\").style.background = \"red\"");
        eyes.checkWindow("Before login");
        driver.findElement(By.cssSelector("#login")).clear();
        driver.findElement(By.cssSelector("#login")).sendKeys("dealerlogin");
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("000");
        driver.findElement(By.cssSelector("#login2")).click();
        waitFullPageLoading();
        eyes.checkWindow("After login");
        eyes.close();
    }

    @Test
    public void incorrectCredentials() {
        eyes.open(driver,"test app", "IncorrectCredentials", new RectangleSize(1150, 650));
        driver.get("http://www.andreyb.ixloo.com/dms");
        waitFullPageLoading();
        eyes.checkWindow("Login");
        driver.findElement(By.cssSelector("#login")).clear();
        driver.findElement(By.cssSelector("#login")).sendKeys("dealerlogin");
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("00");
        driver.findElement(By.cssSelector("#login2")).click();
        waitFullPageLoading();
        eyes.checkWindow("Logged in");
        eyes.close();
    }

    @AfterMethod
    public void teatDown() {
        eyes.abortIfNotClosed();
        driver.quit();
    }

    public void waitFullPageLoading() {
        new WebDriverWait(driver, 10000).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }


}
