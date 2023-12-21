import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class SeleniumEasy {
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

    }

    @AfterClass
    public void afterClassTest(){
        System.out.println("After Class");
    }

    @BeforeGroups (groups = "Test Input")
    public void beforeInput(){
        System.out.println("Before groups Test Input");
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }
    @AfterGroups (groups = "Test Input")
    public void afterInput(){
        System.out.println("After groups Test Input");
    }

    @BeforeGroups (groups = "Test Checkbox")
    public void beforeCheckbox(){
        System.out.println("Before groups Test Checkbox");
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }
    @AfterGroups (groups = "Test Checkbox")
    public void afterCheckbox(){
        System.out.println("After groups Test Checkbox");
    }

    @BeforeGroups (groups = "Test Radio Button")
    public void beforeRadioBtn(){
        System.out.println("Before groups Test Radio Button");
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }
    @AfterGroups (groups = "Test Radio Button")
    public void afterRadioBtn(){
        System.out.println("After groups Test Radio Button");
    }

    @BeforeGroups (groups = "Test Dropdown")
    public void beforeDropdown(){
        System.out.println("Before groups Test Dropdown");
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    @AfterGroups (groups = "Test Dropdown")
    public void afterDropdown(){
        System.out.println("After groups Test Dropdown");
    }

    @Test (groups = "Test Input", enabled = false)
    @Parameters({"textMessage"})
    public void singleInputField(String textMessage){
        WebElement input=driver.findElement(By.cssSelector("input#user-message"));
        WebElement btn=driver.findElement(By.cssSelector("#get-input > button"));
        WebElement message=driver.findElement(By.cssSelector("#display"));
        input.sendKeys(textMessage);
        btn.click();
        System.out.println(message.getText());
        Assert.assertEquals(message.getText(), textMessage);
    }

    @Test (groups = "Test Input", enabled = false)
    @Parameters({"a", "b"})
    public void twoInputField(int a, int b){
        WebElement inputA=driver.findElement(By.id("value1"));
        WebElement inputB=driver.findElement(By.id("value2"));
        WebElement totalBtn=driver.findElement(By.cssSelector("#gettotal > button"));
        WebElement result=driver.findElement(By.id("displayvalue"));
        int c=a+b;
        inputA.sendKeys(String.valueOf(a));
        inputB.sendKeys(String.valueOf(b));
        totalBtn.click();
        System.out.println(result.getText());
        Assert.assertEquals(result.getText(), String.valueOf(c));
    }

    @Test (groups = "Test Checkbox", enabled = false)
    public void singleCheckbox(){
        WebElement check1=driver.findElement(By.id("isAgeSelected"));
        WebElement check2=driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > div.checkbox > form > label:nth-child(2) > input[type=checkbox]"));
        WebElement check3=driver.findElement(By.cssSelector("#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > div.checkbox > form > label:nth-child(3) > input[type=checkbox]"));

        WebElement text1=driver.findElement(By.cssSelector("div#txtAge"));
        check1.click();
        Assert.assertEquals(text1.getText(), "Success - Check box is checked");
        Assert.assertTrue(check2.isSelected());
        Assert.assertFalse(check3.isEnabled());
    }

    @Test (groups = "Test Checkbox", enabled = false)
    public void multipleCheckbox(){
        ArrayList<WebElement> listCheckbox= (ArrayList<WebElement>) driver.findElements(By.className("cb1-element"));
        WebElement checkAllBtn=driver.findElement(By.id("check1"));
        checkAllBtn.click();
        for (WebElement cb :listCheckbox) {
            Assert.assertTrue(cb.isSelected());
        }
        Assert.assertEquals(checkAllBtn.getAttribute("value"),"Uncheck All");
        listCheckbox.get(0).click();
        Assert.assertFalse(listCheckbox.get(0).isSelected());
        Assert.assertEquals(checkAllBtn.getAttribute("value"),"Check All");
    }

    @Test (groups = "Test Radio Button", enabled = false, priority = 0)
    public void radioBtn(){
        WebElement maleBtn=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
        WebElement femaleBtn=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[2]/input"));
        WebElement btnCheck=driver.findElement(By.id("buttoncheck"));
        WebElement rs=driver.findElement(By.className("radiobutton"));

        maleBtn.click();
        btnCheck.click();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(maleBtn.isSelected());
        softAssert.assertEquals(rs.getText(), "Radio button 'Male' is checked");

        femaleBtn.click();
        btnCheck.click();
        softAssert.assertTrue(femaleBtn.isSelected());
        softAssert.assertEquals(rs.getText(), "Radio button 'Female' is checked");

        softAssert.assertAll();
    }

    @Test (groups = "Test Radio Button", enabled = false, priority = 1)
    public void groupRadioBtn() throws InterruptedException {
        ArrayList<WebElement> list1= (ArrayList<WebElement>) driver.findElements(By.name("gender"));
        ArrayList<WebElement> list2= (ArrayList<WebElement>) driver.findElements(By.name("ageGroup"));
        WebElement getValueBtn=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));
        WebElement rs=driver.findElement(By.className("groupradiobutton"));

        SoftAssert softAssert=new SoftAssert();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                list1.get(i).click();
                list2.get(j).click();
                Thread.sleep(500);
                getValueBtn.click();
                Thread.sleep(500);
                String s="Sex : " + list1.get(i).getAttribute("value") + "\n" + "Age group: " + list2.get(j).getAttribute("value");
                softAssert.assertEquals(rs.getAttribute("innerText"), s);
            }
        }
        softAssert.assertAll();
    }

    @Test (groups="Test Dropdown")
    public void selectList() throws InterruptedException {
        WebElement selectList=driver.findElement(By.id("select-demo"));
        ArrayList<WebElement> options= (ArrayList<WebElement>) selectList.findElements(By.cssSelector("option"));
        WebElement rs=driver.findElement(By.className("selected-value"));
        SoftAssert softAssert=new SoftAssert();
        for(int i=1; i<options.size(); i++){
            options.get(i).click();
            String s="Day selected :- " + options.get(i).getAttribute("value");
            softAssert.assertEquals(rs.getText(), s);
            Thread.sleep(500);

        }
        softAssert.assertAll();
    }


}
