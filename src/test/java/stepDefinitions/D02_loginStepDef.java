package stepDefinitions;
import Pages.P02_login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login loginPage;
    @Given("user go to login page")
    public void go_to_login_page()
    {loginPage= Hooks.homepage.GoToLoginPage();
    }
    @When("^user login with valid \"(.*)\" and \"(.*)\"")
    public void login_with_valid_email_and_password(String userEmail,String password)
    {
        loginPage.UserLogin(userEmail,password);
    }

//    @When("user login with valid email and password")
//    public void login_with_valid_email_and_password()
//    {
//        loginPage.UserLogin(Data.userEmail,Data.password);
//    }

    @Then("user login to the system successfully")
    public void login_successfully() {
        SoftAssert Assert =new SoftAssert();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        Assert.assertEquals(loginPage.GetMyAccount(),true);
        Assert.assertAll();
        loginPage.Logout();

    }
}
