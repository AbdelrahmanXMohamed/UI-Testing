package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;
import org.openqa.selenium.interactions.Actions;

public class P03_homePage {
    WebDriver driver= Hooks.driver;
    Actions actions=new Actions(driver);
    public String subCategoryName;

    @FindBy(id="small-searchterms")
    WebElement SearchBar;
    @FindBy(css="h2[class=\"product-title\"] a")
    WebElement SearchResult;
    @FindBy(css=".sku .value")
    WebElement SkuValue;

    @FindBy(css="ul[class=\"top-menu notmobile\"] a[href=\"/computers\"]")
    WebElement Computers;

    @FindBy(css="ul[class=\"top-menu notmobile\"] a[href=\"/desktops\"]")
    WebElement Desktops;
    @FindBy(css="div .page-title h1")
    WebElement PageTitle;

    @FindBy(xpath="//*[@class=\"facebook\"]/a[1]")
    public WebElement Facebook;

    @FindBy(xpath="//*[@class=\"twitter\"]/a[1]")
    public WebElement Twitter;

    @FindBy(xpath="//*[@class=\"rss\"]/a[1]")
    public WebElement Rss;

    @FindBy(xpath = "//*[@class=\"youtube\"]/a[1]")
    public WebElement Youtube;
    public P03_homePage() {
        PageFactory.initElements(driver,this);
    }

    public void ChangeCurrency(String currency)
    {
        Select select  = new Select(Hooks.driver.findElement(By.name("customerCurrency")));
        select.selectByVisibleText(currency);
    }

    public int getCurrenciesSize()
    {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).size();
    }
    public boolean CheckCurrencies(int id)
    {
        return Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")).get(id).getText().contains("€");
    }

    private void HandleClick(String Linkttext){
        driver.findElement(By.linkText(Linkttext)).click();
    }

    public P01_register GoToRegisterPage()
    {
        HandleClick("Register");
        return new P01_register();
    }
    public P02_login GoToLoginPage(){
        HandleClick("Log in");
        return new P02_login();
    }
    public void SearchForProduct(String ProductName)
    {
        SearchBar.sendKeys(ProductName);
        SearchBar.sendKeys(Keys.ENTER);
    }
    public void ClickOnSearchBar()
    {
        SearchBar.click();
    }
    public int getSearchResult()
    {
        return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();
    }
    public Boolean CheckProducts(int id,String Product)
    {
     return Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(id).getText().contains(Product);
    }
    public void GoToSearchResult()
    {
        SearchResult.click();
    }
    public String GetSKU()
    {
        return SkuValue.getText();
    }
    public void HoverCategories() throws InterruptedException {

        actions.moveToElement(Computers).perform();
        Thread.sleep(1000);
        subCategoryName = Desktops.getText().toLowerCase().trim();
        Desktops.click();
    }
    public String getPageTitle()
    {
        return PageTitle.getText().toLowerCase().trim();
    }

    public WebElement sliders(String num)
    {
        return Hooks.driver.findElement(By.xpath("//*[@id=\"nivo-slider\"]/a["+num+"]"));
    }
    public void SoicalClick(WebElement Social)
    {
        Social.click();
    }
}
