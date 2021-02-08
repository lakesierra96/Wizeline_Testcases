package test_cases;

import actions.SignUpFuntion;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static supports.Util.driver;
import static supports.Util.openBrowser;

public class TC1_Submit_The_Form_Successfully {
    @BeforeMethod
    public void setUp() {
        openBrowser();
    }

    @Test
    public void submit_form_successfully() {
        SignUpFuntion signUp = new SignUpFuntion(driver);
        signUp.openSignUpPage()
                .submitForm()
                .verifyNavigateToNextPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
