package main.java.selenium.easy.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SetUpDriver {
    public WebDriver getDriver(String type){
        WebDriver driver;
        switch (type){
            case "chrome":
                driver = initChromeDriver();
                break;
            case "safari":
                driver = initSafariDriver();
                break;
            default:
                driver = null;
        }
        return driver;
    }
    public WebDriver initChromeDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        return driver;
    }

    public WebDriver initEdgeDriver(){
        WebDriver driver;
        System.setProperty("webdriver.edge.whitelistedIps", "");
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        return driver;
    }

    public WebDriver initSafariDriver(){
        WebDriver driver;
        System.setProperty("webdriver.safari.whitelistedIps", "");
        WebDriverManager.safaridriver().setup();
        driver=new SafariDriver();
        return driver;
    }
}
