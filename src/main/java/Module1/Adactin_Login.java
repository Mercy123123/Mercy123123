package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactin_Login {


	@FindBy (xpath = "(//input[@class='login_input'])[1]") private WebElement UN;
	@FindBy (xpath = "(//input[@class='login_input'])[2]") private WebElement PW;
	@FindBy (xpath = "//input[@class='login_button']") private WebElement Loginbtn;
	
	
	//Initialize within constructor
	public Adactin_Login(WebDriver driver) 
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	//utilize within Method with accessLevel as PUBLIC
	public void EnterUsername(String User)
	{
		UN.sendKeys(User);
		
	}
	
	public void EnterPassword(String Pass)
	{
		PW.sendKeys(Pass);
		
	}
	
	public void ClickOnLoginButton()
	{
		Loginbtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
