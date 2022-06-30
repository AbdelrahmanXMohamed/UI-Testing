package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.cucumber.messages.types.Product;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    @Given("user clicks on search field")
    public void user_clicks_on_search_field()
    {
        Hooks.homepage.ClickOnSearchBar();
    }
    @When("user search with name of product")
    public void  user_search_with_name_of_product()
    {
        Hooks.homepage.SearchForProduct("Apple");
    }
    @Then("user could find relative results")
    public void user_could_find_relative_results()
    {
        SoftAssert Assert=new SoftAssert();
        for (int i=0 ; i<Hooks.homepage.getSearchResult();++i)
            Assert.assertTrue(Hooks.homepage.CheckProducts(i,"Apple"));
        Assert.assertAll();
    }
    @When("^user search with sku of product \"(.*)\"")
    public void user_search_with_sku_of_product(String ProductName)
    {
        Hooks.homepage.SearchForProduct(ProductName);
    }
    @Then("user will find only one results and user will click on it")
    public void user_will_find_only_one_results_and_user_will_click_on_it()
    {
        Hooks.homepage.GoToSearchResult();
    }
    @Then("^verify sku \"(.*)\"")
    public void verify_sku(String ProductName)
    {
        Assert.assertTrue(Hooks.homepage.GetSKU().contains(ProductName));
    }

}
