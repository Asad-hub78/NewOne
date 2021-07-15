package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@menu", dryRun = false)
public class Run {
  //  public static String xmlReport = new File("src/main/resources/testData/read.properties").getAbsolutePath();

   //public void generateReport(){
       // Reporter.loadXMLConfig(xmlReport);
   // }
}
