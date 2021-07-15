package StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scrolling {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.next.co.uk/");
        driver.manage().window().maximize();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(2000);
        javascriptExecutor.executeScript("window.scrollBy(0,-5000)");

        WebElement element = driver.findElement(By.xpath("//h3[text()='My Account']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
    }
}
