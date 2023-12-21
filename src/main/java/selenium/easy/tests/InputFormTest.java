package main.java.selenium.easy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import main.java.selenium.easy.pages.InputFormPage;
import main.java.selenium.easy.utilities.Links;
import main.java.selenium.easy.utilities.SetUpDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class InputFormTest {
    WebDriver driver;


    @BeforeClass
    public void beforeClassTest(){
        driver = new SetUpDriver().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get(Links.URL_INPUT_FORM);

    }

    @AfterClass
    public void afterClassTest(){
        driver.close();
        driver.quit();
    }

    @Test (dataProvider = "data-input-form")
    public void inputSuccess(String firstName, String lastName, String email, String phone, String address,
                             String city, int indexState, String zip, String web, int indexHosting, String description){
        // Input information
        InputFormPage ifPage = new InputFormPage(driver);
        ifPage.inputFirstName(firstName);
        ifPage.inputLastName(lastName);
        ifPage.inputEmail(email);
        ifPage.inputPhone(phone);
        ifPage.inputAddress(address);
        ifPage.inputCity(city);
        ifPage.selectState(indexState);
        ifPage.inputZipCode(zip);
        ifPage.inputWebsite(web);
        ifPage.chooseHosting(indexHosting);
        ifPage.inputDescription(description);

        // Click "Send"
        ifPage.clickSubmitButton();

        Assert.assertTrue(true);

    }

    @DataProvider (name="data-input-form")
    public Object[][] dt(){
        return new Object[][]{{"Tran", "Hue", "huetransky@gmail.com", "0325811117", "Thuy Hung",
                "Thai Thuy", 3, "10000", "google.com", 1, "test comment"}};
    }
}
