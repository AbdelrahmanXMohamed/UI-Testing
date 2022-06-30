package stepDefinitions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    ArrayList<String> Tabs ;
    @When("^click on \"(.*)\" icon")
    public void click_on_icon(String Icon)  {
        switch (Icon)
        {
            case "facebook":
                Hooks.homepage.SoicalClick(Hooks.homepage.Facebook);
                break;
            case "twitter":
                Hooks.homepage.SoicalClick(Hooks.homepage.Twitter);
                break;
            case "rss":
                Hooks.homepage.SoicalClick(Hooks.homepage.Rss);
                break;
            case "youtube":
                Hooks.homepage.SoicalClick(Hooks.homepage.Youtube);
                break;
        }


    }
    @Then("^\"(.*)\" is opened in new tab")
    public void switch_to_second_tab(String Soical) throws InterruptedException
    {
        Thread.sleep(2000);
        Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        switch (Soical)
        {
        case "facebook":
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
            break;
        case "twitter":
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
            break;
        case "rss":
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");            break;
        case "youtube":
            Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
            break;
    }
        Hooks.driver.close();

        Hooks.driver.switchTo().window(Tabs.get(0));
        System.out.println(Hooks.driver.getCurrentUrl());
    }


}
