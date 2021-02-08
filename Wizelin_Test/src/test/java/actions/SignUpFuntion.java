package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import page_objects.SignUpPage;

import static supports.Util.*;

public class SignUpFuntion extends SignUpPage {

    public SignUpFuntion(WebDriver driver) {
        super();
    }

    public SignUpFuntion openSignUpPage(){
        visit(SIGNUP_URL);
        return this;
    }

    public SignUpFuntion submitForm(){
        sendKey(FIRST_NAME_FIELD, "Hieu");
        sendKey(LAST_NAME_FIELD, "Pham");
        sendKey(EMAIL_FIELD, "hieu.pkt96@gmail.com");
        select(BIRTH_MONTH_LISTBOX, "August");
        select(BIRTH_DAY_LISTBOX, "17");
        select(BIRTH_YEAR_LISTBOX, "1996");
        sendKey(LANGUAGE_TEXT_FIELD, "Arabic");
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        click(NEXT_BUTTON);
        return this;
    }

    public SignUpFuntion verifyNavigateToNextPage(){
        Assert.assertEquals(getText(STEP_2_TITLE), "Step 2:");
        return this;
    }

    public SignUpFuntion verifyInvalidEmail(){
        sendKey(EMAIL_FIELD, "test");
        Assert.assertTrue(isDisplayed(EMAIL_ERROR));
        sendKey(EMAIL_FIELD, "Test@123");
        Assert.assertTrue(isDisplayed(EMAIL_ERROR));
        sendKey(EMAIL_FIELD, "Test.com");
        Assert.assertTrue(isDisplayed(EMAIL_ERROR));
        return this;
    }
}
