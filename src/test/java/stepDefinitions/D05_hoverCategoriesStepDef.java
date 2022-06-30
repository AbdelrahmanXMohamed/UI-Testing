package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {
    @Given("user hover category and select subcategory and go to desktop")
    public void user_hover_category_and_select_subcategory_and_go_to_desktop() throws InterruptedException {
        Hooks.homepage.HoverCategories();
    }
    @Then("check page title with selected")
    public void check_page_title_with_selected()
    {
        Assert.assertEquals(Hooks.homepage.getPageTitle(),Hooks.homepage.subCategoryName);
    }
}
