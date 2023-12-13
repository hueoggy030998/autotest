import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
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
        Assert.assertEquals(driver.getTitle(),"aiTriage");
    }

    @Test (groups = {"testButton"}, priority = 2)
    public void checkButtonDisplay(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[4]")).isDisplayed(), true);

    }

    @Test (groups = {"testButton"}, enabled = true, description = "Test button 1",
    expectedExceptions = AssertionError.class, priority = 1)
    public void checkButtonSize(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[4]")).getSize().width, 100);

    }

}
