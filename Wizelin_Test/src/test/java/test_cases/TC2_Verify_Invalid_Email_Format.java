package test_cases;

import actions.SignUpFuntion;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static supports.Util.driver;
import static supports.Util.openBrowser;

public class TC2_Verify_Invalid_Email_Format {

    @BeforeMethod
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verify_invalid_email_format() {
        SignUpFuntion signup = new SignUpFuntion(driver);
        signup.openSignUpPage()
                .verifyInvalidEmail();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
