package StepDefinitions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException, CsvValidationException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.next.co.uk/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='My Account']")).click();

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\6666\\IdeaProjects\\untitled3\\src\\main\\resources\\testData\\testData.csv"));
        String[] cell;
        while ((cell=reader.readNext())!=null){
            for(int i=2; i<= cell.length; i++){
                String email = cell[0];
                String password = cell[1];

                driver.findElement(By.id("EmailOrAccountNumber")).clear();
                driver.findElement(By.id("EmailOrAccountNumber")).sendKeys(email);
                driver.findElement(By.id("Password")).clear();
                driver.findElement(By.id("Password")).sendKeys(password);
            }
        }
    }
}
