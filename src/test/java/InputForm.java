import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class InputForm {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("Before Suite");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterSuite
    public void afterSuiteTest(){
        driver.close();
        driver.quit();
        System.out.println("After Suite");
    }

    @BeforeClass
    public void beforeClassTest(){
        System.out.println("Before Class");
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

    }

    @AfterClass
    public void afterClassTest(){
        System.out.println("After Class");
    }

    @Test
    public void checkNull(){
        WebElement submitBtn=driver.findElement(By.className(".btn.btn-default"));
        submitBtn.click();
    }

}
