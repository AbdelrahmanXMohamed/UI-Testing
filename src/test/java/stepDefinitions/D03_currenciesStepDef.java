package stepDefinitions;
import Pages.P03_homePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage homepage=Hooks.homepage;
    @When("user select random currency")
    public void user_select_random_currency()
    {
        homepage.ChangeCurrency("Euro");
    }
    @Then("currency is changed in Home Page correctly")
    public void currency_is_changed_in_Home_Page_correctly()
    {
        for(int i =0;i<homepage.getCurrenciesSize();i++)
        {
            Assert.assertEquals(homepage.CheckCurrencies(i),true);
        }
    }


}
