package StepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class British {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.britishairways.com/travel/home/public/en_gb/");
        driver.manage().window().maximize();

        driver.findElement(By.id("flight-outbound-date-selector")).click();
selectDate("26","November","2021");
Thread.sleep(2000);
driver.findElement(By.id("flight-inbound-date-selector")).click();
selectDate("10","December", "2021");
    }
    public static String[] getMonthYear(String monthYearVal){
        return monthYearVal.split(" ");
    }
    public static void selectDate(String exDay, String exMonth, String exYear) throws InterruptedException {
        Thread.sleep(2000);
        String monthYearVal = driver.findElement(By.xpath("//div[@class='datepicker-month']")).getText();
        System.out.println("MonthYearVal");
        while (!(getMonthYear(monthYearVal)[0].equals(exMonth)&& getMonthYear(monthYearVal)[1].equals(exYear))){
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@class='move-month next-month']")).click();
            monthYearVal = driver.findElement(By.xpath("//div[@class='datepicker-month']")).getText();
        }
        driver.findElement(By.xpath("//span[text()='"+exDay+"']")).click();
    }
}
