package selenium.easy.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InputFormPage {

    public WebDriver driver;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/legend")
    public WebElement title;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[1]/label")
    public WebElement firstNameLabel;

    @FindBy (name = "first_name")
    public WebElement firstNameTextbox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[2]/label")
    public WebElement lastNameLabel;

    @FindBy (name = "last_name")
    public WebElement lastNameTextbox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[3]/label")
    public WebElement emailLabel;

    @FindBy (name = "email")
    public WebElement emailTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[4]/label")
    public WebElement phoneLabel;

    @FindBy (name = "phone")
    public WebElement phoneTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[5]/label")
    public WebElement addressLabel;

    @FindBy (name = "address")
    public WebElement addressTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[6]/label")
    public WebElement cityLabel;

    @FindBy (name = "city")
    public WebElement cityTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[7]/label")
    public WebElement stateLabel;

    @FindBy (name = "state")
    public WebElement stateDropdown;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[8]/label")
    public WebElement zipCodeLabel;

    @FindBy (name = "zip")
    public WebElement zipCodeTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[9]/label")
    public WebElement websiteLabel;

    @FindBy (name = "website")
    public WebElement websiteTextBox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[10]/label")
    public WebElement hostingLabel;

    @FindBy (name = "hosting")
    public List<WebElement> hostingRadioBtns ;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[11]/label")
    public WebElement descriptionLabel;

    @FindBy (name = "comment")
    public WebElement descriptionTextbox;

    @FindBy (xpath = "//*[@id=\"contact_form\"]/fieldset/div[13]/div/button")
    public WebElement submitButton;

    public InputFormPage(WebDriver driver){
       this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void inputFirstName(String firstName){
        firstNameTextbox.sendKeys(firstName);
    }

    public void inputLastName(String lastName){
        lastNameTextbox.sendKeys(lastName);
    }

    public void inputEmail(String email){
        emailTextBox.sendKeys(email);
    }

    public void inputPhone(String phone){
        phoneTextBox.sendKeys(phone);
    }

    public void inputAddress(String address){
        addressTextBox.sendKeys(address);
    }

    public void inputCity(String city){
        cityTextBox.sendKeys(city);
    }

    public void selectState(int index){
        stateDropdown.click();
        ArrayList<WebElement> listState = (ArrayList<WebElement>) stateDropdown.findElements(By.cssSelector("option"));
        listState.get(index).click();

    }

    public void inputZipCode(String zip){
        zipCodeTextBox.sendKeys(zip);
    }

    public void inputWebsite(String web){
        websiteTextBox.sendKeys(web);
    }

    public void chooseHosting(int index){
        hostingRadioBtns.get(index).click();
    }

    public void inputDescription(String description){
        descriptionTextbox.sendKeys(description);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

}
