package StepDefinitions;

import Utils.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    CommonUtils commonUtils = new CommonUtils();
    @Before
public void beforeTest() throws IOException {
    commonUtils.openBrowser();
}
@After
public void afterTest(){
    commonUtils.closeBrowser();
}
}
