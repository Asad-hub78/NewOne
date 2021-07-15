package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
    public static WebDriver driver;
    public static String readProperties(String key) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\6666\\IdeaProjects\\untitled3\\src\\main\\resources\\testData\\read.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }
    public void openBrowser() throws IOException {
        String browserObj = readProperties("browser");
        switch(browserObj){
            case"chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        }
        public void closeBrowser(){
        driver.quit();
    }
    public void waitForTime(int waitTime){
        driver.manage().window().maximize();
    }
    public void waitForElement(WebElement element, int maxTime){
        WebDriverWait wait = new WebDriverWait(driver, maxTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void mouseOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
            }
        }


