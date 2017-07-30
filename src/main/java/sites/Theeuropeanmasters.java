package sites;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 29.07.2017.
 */
public class Theeuropeanmasters extends Base {

    @BeforeClass
    public static void setBatch() {
        batch = new BatchInfo("Theeuropeanmasters");
    }

    @Test
    public void english_Laptop_HomePage() {
        eyes.open(driver, "Theeuropeanmasters", "english_Laptop_HomePage", getScreenSize("Home"));
        driver.get("http://www.theeuropeanmasters.com/");
        waitFullPageLoading();
        eyes.checkWindow("Header");
        scrollToElement(driver, getArticleTitle("WELCOME TO"));
        waitFullPageLoading();
        eyes.checkWindow("Wellcom to european masters");
        scrollToElement(driver, getArticleTitle("CLICK HERE TO VIEW ALL INVENTORY"));
        waitFullPageLoading();
        eyes.checkWindow("CLICK HERE TO VIEW ALL INVENTORY");
        scrollToElement(driver, getArticleTitle("ABOUT US"));
        waitFullPageLoading();
        eyes.checkWindow("About Us");
        scrollToElement(driver, getArticleTitle("Thank you for Shopping with European Masters!"));
        waitFullPageLoading();
        eyes.checkWindow("Thank you!");
        scrollToElement(driver, driver.findElement(By.tagName("footer")));
        waitFullPageLoading();
        eyes.checkWindow("Footer");
        eyes.close();
    }


    @Test
    public void spanish_Laptop_HomePage() throws Exception{
        eyes.open(driver, "Theeuropeanmasters", "spanish_Laptop_HomePage", getScreenSize("Home"));
        driver.get("http://www.theeuropeanmasters.com/");
        driver.findElement(By.cssSelector("#languageGoogleMenu")).click();
        driver.findElement(By.cssSelector("a[data-lang=\"es\"]")).click();
        waitFullPageLoading();
        eyes.checkWindow("Header");
        spanishOrEnglish("BIENVENIDOS A", "WELCOME TO");
        waitFullPageLoading();
        eyes.checkWindow("BIENVENIDOS A European Masters");
        //wait.until(ExpectedConditions.visibilityOf(getArticleTitle("HAGA CLIC AQUÍ PARA VER TODO EL INVENTARIO")));
        spanishOrEnglish("HAGA CLIC AQUÍ PARA VER TODO EL INVENTARIO","CLICK HERE TO VIEW ALL INVENTORY" );
        waitFullPageLoading();
        eyes.checkWindow("HAGA CLIC AQUÍ PARA VER TODO EL INVENTARIO");
        spanishOrEnglish("SOBRE NOSOTROS","ABOUT US");
        waitFullPageLoading();
        eyes.checkWindow("SOBRE NOSOTROS");
        spanishOrEnglish("Gracias por hacer compras con el European Masters!","Thank you for Shopping with European Masters!");
        waitFullPageLoading();
        eyes.checkWindow("Gracias por hacer compras con el European Masters!");
        scrollToElement(driver, driver.findElement(By.tagName("footer")));
        waitFullPageLoading();
        eyes.checkWindow("Footer");
        eyes.close();
    }
}