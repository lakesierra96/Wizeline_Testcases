package page_objects;

import org.openqa.selenium.By;

public class SignUpPage {

    public static final String SIGNUP_URL = "https://www.utest.com/signup/personal";
    protected By FIRST_NAME_FIELD = By.id("firstName");
    protected By LAST_NAME_FIELD = By.id("lastName");
    protected By EMAIL_FIELD = By.id("email");
    protected By BIRTH_MONTH_LISTBOX = By.id("birthMonth");
    protected By BIRTH_DAY_LISTBOX = By.id("birthDay");
    protected By BIRTH_YEAR_LISTBOX = By.id("birthYear");
    protected By LANGUAGE_TEXT_FIELD = By.xpath("//div[@id='languages']/div[1]/input[1]");
    protected By NEXT_BUTTON = By.xpath("//span[contains(text(),'Next: Location')]");
    protected By STEP_2_TITLE = By.xpath("//span[contains(text(),'Step 2:')]");
    protected By EMAIL_ERROR = By.id("emailError");
}
