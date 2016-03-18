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

public class ClassCreationTestsDouble {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void ClassCreationTestsDouble() {
        wd.get("http://in-capsule.com:9090/Workflow/login");
        wd.findElement(By.id("login")).click();
        wd.findElement(By.id("login")).clear();
        wd.findElement(By.id("login")).sendKeys("user1");
        wd.findElement(By.id("pwd")).click();
        wd.findElement(By.id("pwd")).clear();
        wd.findElement(By.id("pwd")).sendKeys("1");
        wd.findElement(By.id("enter")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.linkText("создать")).click();
        wd.findElement(By.cssSelector("button.print-unvisible.hover")).click();
        wd.findElement(By.xpath("//div[@id='ufd-container']/div[2]/div/div/ul/li[2]")).click();
        if (!wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).click();
        }
        wd.findElement(By.id("close_npa")).click();
        wd.findElement(By.id("ufd-fSECURITY_ID")).click();
        wd.findElement(By.name("1")).click();
        if (!wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[2]")).click();
        }
        wd.findElement(By.id("fCLASS_NAME")).click();
        wd.findElement(By.id("fCLASS_NAME")).clear();
        wd.findElement(By.id("fCLASS_NAME")).sendKeys("Удача");
        wd.findElement(By.id("fTARGET")).click();
        wd.findElement(By.id("fTARGET")).clear();
        wd.findElement(By.id("fTARGET")).sendKeys("учет");
        wd.findElement(By.id("fANALITIC_VALUE")).click();
        wd.findElement(By.id("fANALITIC_VALUE")).clear();
        wd.findElement(By.id("fANALITIC_VALUE")).sendKeys("контроль");
        wd.findElement(By.id("fDESCRIPTION")).click();
        wd.findElement(By.id("fDESCRIPTION")).clear();
        wd.findElement(By.id("fDESCRIPTION")).sendKeys("удача");
        wd.findElement(By.id("fEFFECTIVE_DATE")).click();
        wd.findElement(By.linkText("След>")).click();
        wd.findElement(By.linkText("1")).click();
        wd.findElement(By.id("tab-class-classification")).click();
        wd.findElement(By.id("fBASECLASS")).click();
        wd.findElement(By.cssSelector("span.dynatree-expander")).click();
        wd.findElement(By.linkText("SELENIUM TEST")).click();
        wd.findElement(By.id("tabs-class-classification")).click();
        wd.findElement(By.id("tab-class-properties")).click();
        new Actions(wd).doubleClick(wd.findElement(By.xpath("//tr[@id='propedit_tr_new']/td[3]"))).build().perform();
        wd.findElement(By.id("edit_prop_attrname")).click();
        wd.findElement(By.id("edit_prop_attrname")).clear();
        wd.findElement(By.id("edit_prop_attrname")).sendKeys("атрибут 01");
        wd.findElement(By.id("ufd-edit_fldtype")).click();
        wd.findElement(By.xpath("//div[@id='ufd-container']//li[.='Вещественный']")).click();
        if (!wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[2]")).click();
        }
        wd.findElement(By.id("edit_prop_mask")).click();
        wd.findElement(By.id("edit_prop_mask")).clear();
        wd.findElement(By.id("edit_prop_mask")).sendKeys("хххх");
        wd.findElement(By.id("edit_prop_limits")).click();
        wd.findElement(By.id("edit_prop_limits")).clear();
        wd.findElement(By.id("edit_prop_limits")).sendKeys("нет");
        wd.findElement(By.id("edit_prop_defval")).click();
        wd.findElement(By.id("ufd-edit_prop_seculev")).click();
        wd.findElement(By.xpath("//div[@id='ufd-container']/div[3]/div/div/ul/li[2]")).click();
        if (!wd.findElement(By.xpath("//select[@id='edit_prop_seculev']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='edit_prop_seculev']//option[2]")).click();
        }
        wd.findElement(By.id("edit_prop_attrdescr")).click();
        wd.findElement(By.id("edit_prop_attrdescr")).clear();
        wd.findElement(By.id("edit_prop_attrdescr")).sendKeys("атрибут 01");
        wd.findElement(By.id("edit_prop_attrdate")).click();
        wd.findElement(By.linkText("След>")).click();
        wd.findElement(By.linkText("1")).click();
        wd.findElement(By.id("edit_prop_note")).click();
        wd.findElement(By.id("edit_prop_note")).clear();
        wd.findElement(By.id("edit_prop_note")).sendKeys("ок");
        wd.findElement(By.id("edit_save")).click();
        wd.findElement(By.id("tab-class-solutions")).click();
        wd.findElement(By.id("fEXPLANATORY_NOTE")).click();
        wd.findElement(By.id("fEXPLANATORY_NOTE")).clear();
        wd.findElement(By.id("fEXPLANATORY_NOTE")).sendKeys("проверка тест селениум");
        wd.findElement(By.id("saveProfile")).click();
        wd.findElement(By.id("sendProfile")).click();
        wd.findElement(By.linkText("Выход")).click();
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
