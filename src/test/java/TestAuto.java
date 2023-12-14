import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestAuto {
    WebDriver driver;
    @BeforeClass
    public void openChrome(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://test-aitriage-web.beedu.vn/login");
    }
    @AfterClass
    public void closeChrome(){
        driver.close();
        driver.quit();
    }

    @BeforeGroups (groups = {"testButton"})
    public void beforeCheckButton(){
        System.out.println("Check button");
    }
    @AfterGroups (groups = {"testButton"})
    public void afterCheckButton(){
        System.out.println("End Check button");
    }

    @Test (groups = {"testText"}, priority = 3)
    public void checkTitlePage(){
        SoftAssert sortAssert=new SoftAssert();
        sortAssert.assertEquals(driver.getTitle(),"aiTriage");
        sortAssert.assertAll();
    }

    @Test (groups = {"testButton"}, priority = 2)
    public void checkButtonDisplay(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[4]")).isDisplayed());

    }

    @Test (groups = {"testButton"}, enabled = false, description = "Test button 1",
    expectedExceptions = AssertionError.class, priority = 1)
    public void checkButtonSize(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[4]")).getSize().width, 100);

    }


}
