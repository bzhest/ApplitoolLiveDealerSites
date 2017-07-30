package sites;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Andrey on 29.07.2017.
 */
public class Base {
    protected static BatchInfo batch;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Eyes eyes;



    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        eyes = new Eyes();
        eyes.setApiKey("42ocIyb2h7fn4sJyi0zODSOvI3glY118F26yVtRUB5c110");
        eyes.setBatch(batch);
        wait = new WebDriverWait(driver, 30);
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

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        //js.executeScript("document.querySelector('.mcprt-link').scrollIntoView()"); way with hardcoding
    }

    public WebElement getArticleTitle(String title) {
        try {
            return driver.findElements(By.tagName("span")).stream().filter(e -> e.getText().trim().contains(title)).findFirst().get();
        } catch (RuntimeException re) {
            throw new RuntimeException("Title wasn't found");
        }
    }

    public RectangleSize getScreenSize(String device) {
        RectangleSize rectangleSize = null;
        switch (device) {
            case "Home":
                return rectangleSize = new RectangleSize(1150, 650);
            case "Work":
                return rectangleSize = new RectangleSize(1300, 600);
            case "Galaxy S5":
                return rectangleSize = new RectangleSize(360, 640);
        }
        return rectangleSize;
    }

    public void spanishOrEnglish(String spanish, String english){
        try{
            scrollToElement(driver, getArticleTitle("spanish"));
        }catch (RuntimeException ex){
            scrollToElement(driver, getArticleTitle("english"));
        }
    }

}
