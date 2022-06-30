package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.P01_register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register registerPage;


    @Given("user go to register page")
    public void user_go_to_register_page() throws InterruptedException {
        registerPage=Hooks.homepage.GoToRegisterPage();

    }
    @When("user select gender type")
    public void user_select_gender_type()
    {
        registerPage.RegisterGender();
    }

    @And("user enter first and last name")
    public void user_enter_first_and_last_name()
    {
        registerPage.RegisterFirstAndLastName(Data.firstname,Data.lastname);
    }
    @And("user enter date of birth")
    public void user_enter_date_of_birth()
    {
        registerPage.RegisterBirthDay(27,"5","1999");
    }

    @And("user enter email and password and confirm password")
    public void user_enter_email_and_password_and_confirm_password() {
        registerPage.RegisterEmailAndPassword(Data.userEmail,Data.password);
    }
    @And("user press on register button")
    public void UserRegister() {
        registerPage.Register();
    }

    @Then("user register to the system successfully")
    public void user_register_to_the_system_successfully() {
        SoftAssert Assert=new SoftAssert();
        Assert.assertEquals(registerPage.resultRegister(), "Your registration completed");
        Assert.assertEquals(registerPage.GetMsgColor(),"rgba(76, 177, 124, 1)");
        Assert.assertAll();
        registerPage.Logout();
    }
}
