import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Ctests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Ctests() {
        wd.get("http://212.42.103.149:8070/Workflow/login");
        wd.findElement(By.id("login")).click();
        wd.findElement(By.id("login")).clear();
        wd.findElement(By.id("login")).sendKeys("user1");
        wd.findElement(By.id("pwd")).click();
        wd.findElement(By.id("pwd")).sendKeys("\\undefined");
        wd.findElement(By.id("enter")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.linkText("создать")).click();
        wd.findElement(By.xpath("//div[@id='choose_npa']//button[.='Пропустить']")).click();
        wd.findElement(By.id("fDESCRIPTION")).click();
        wd.findElement(By.id("fDESCRIPTION")).clear();
        wd.findElement(By.id("fDESCRIPTION")).sendKeys("что надо еще");
        wd.findElement(By.id("fEFFECTIVE_DATE")).click();
        wd.findElement(By.linkText("Next")).click();
        wd.findElement(By.linkText("1")).click();
        wd.findElement(By.id("tab-class-classification")).click();
        wd.findElement(By.id("fBASECLASS")).click();
        wd.findElement(By.cssSelector("span.dynatree-expander")).click();
        wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/span/span[1]")).click();
        wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/ul/li[2]/span/span[1]")).click();
        wd.findElement(By.linkText("ВЕРХНЯЯ ОДЕЖДА")).click();
        wd.findElement(By.id("tab-class-properties")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
