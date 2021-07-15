package StepDefinitions;

import Utils.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class MenuSteps extends CommonUtils {
    @Given("I am on home page")
    public void i_am_on_home_page() throws IOException {
      String url = readProperties("url");
      driver.get(url);
      driver.manage().window().maximize();

      //String title = driver.getTitle();
          //if(title.contains("https://www.next.co.uk/")){
           //   System.out.println("Right page");

        //  }
          //else {
          //    System.out.println("Wrong Page");
        //  }
        }



    @When("I choose menu option {string}")
    public void i_choose_menu_option(String menu) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//span[text()='"+menu+"']"));
        mouseOver(element);
Thread.sleep(2000);
    }

    @When("I choose subMenu options {string}")
    public void i_choose_sub_menu_options(String subMenu) {
 driver.findElement(By.xpath("//a[text()='"+subMenu+"']")).click();
    }

    @Then("I should be redirected to appropriate search page {string}")
    public void i_should_be_redirected_to_appropriate_search_page(String string) throws IOException {
        WebElement elementObj = driver.findElement(By.xpath("//div[@class='SearchedFor']/h3"));
        Assert.assertTrue(elementObj.isDisplayed());
        this.takeScreenShots();
    }
    public void takeScreenShots() throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("C:\\Users\\6666\\IdeaProjects\\untitled3\\src\\main\\resources\\testData\\screenshot.png"));
    }
}


