package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;

public class P01_register {
    private WebDriver driver= Hooks.driver;
    public P01_register()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="gender-female")
    private WebElement FemaleGender;

//    @FindBy(id="gender-male")
//    private WebElement maleGender;

    @FindBy(id="FirstName")
    private WebElement Firstname;

    @FindBy(id="LastName")
    private WebElement LastName;

    @FindBy(id="Email")
    private WebElement Email;

    @FindBy(id="Password")
    private WebElement Password;

    @FindBy(id="ConfirmPassword")
    private WebElement ConfirmPassword;

    @FindBy(id="register-button")
    private WebElement RegisterBtn;

    @FindBy(className="result")
    private WebElement Result;

    @FindBy(linkText="Log out")
    private  WebElement Logout;
    public void RegisterGender(){
        FemaleGender.click();
    }
    public void RegisterBirthDay(int day,String month,String year)
    {
        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(birthDay);
        select.selectByIndex(day-1);

        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(birthMonth);
        select.selectByValue(month);

        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        select.selectByVisibleText(year);
    }

    public void RegisterFirstAndLastName(String firstName,String lastName )
    {
        Firstname.sendKeys(firstName);
        LastName.sendKeys(lastName);
    }
    public void RegisterEmailAndPassword(String email , String password)
    {
        Email.sendKeys(email);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(password);
    }
    public void Register(){RegisterBtn.click();}
    public String resultRegister(){
        System.out.println(Result.getText());
        return Result.getText();
    }
    public String GetMsgColor()
    {
        return Result.getCssValue("color");
    }
    public void Logout(){
        Logout.click();
    }

//    protected static void clickButton(WebElement button) {button.click();
//    }
}
