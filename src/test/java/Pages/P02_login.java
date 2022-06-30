package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

public class P02_login {
    WebDriver driver= Hooks.driver;
    public P02_login()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="Email")
    private WebElement Email;

    @FindBy(id="Password")
    private WebElement Password;

    @FindBy(xpath="//form/div[3]/button")
    private WebElement LoginBtn;

    @FindBy(xpath="//ul/li[1]/a")
    private WebElement SuccessLogin;

    @FindBy(xpath="//div[1]/ul/li[2]/a")
    private WebElement Logout;


    public void UserLogin(String email,String pass){
        Email.sendKeys(email);
        Password.sendKeys(pass);
        LoginBtn.click();
    }

    public boolean GetMyAccount(){return SuccessLogin.isDisplayed();}
    public void Logout(){Logout.click();}
//    public void PasswordRecovery(){PasswordRecovery.click();}
}
