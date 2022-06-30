package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class D06_homeSlidersStepDef {
    @Given("^user go to \"(.*)\" slider")
    public void user_go_to_first_slider(String num) {
        Hooks.homepage.sliders(num).click();
    };
    @Then("relative product for slider is displayed")
    public void check_current_link()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10) );
        System.out.println(Hooks.driver.getCurrentUrl());
        boolean check =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(check);
    }
}
