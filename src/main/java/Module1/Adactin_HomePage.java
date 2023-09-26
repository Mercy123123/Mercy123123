package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Adactin_HomePage {
	

	
	@FindBy (xpath = "//input[@class='input_show']") private WebElement getUser;
	@FindBy (xpath = "//a[text()='Logout']") private WebElement Logout;
	@FindBy (xpath = "//a[text()='Click here to login again']") private WebElement AgainLogin;
	@FindBy (xpath = "//select[@name='location']") private WebElement Location;
	@FindBy (xpath = "//select[@name='hotels']") private WebElement Hotels;
	@FindBy (xpath = "//select[@name='room_type']") private WebElement RoomType;
	@FindBy (xpath = "//select[@name='room_nos']") private WebElement NumberofRooms;
	@FindBy (xpath = "//input[@name='datepick_in']") private WebElement CheckInDate;
	@FindBy (xpath = "//input[@name='datepick_out']") private WebElement CheckOutDate;
	@FindBy (xpath = "//*[@name='adult_room']") private WebElement AdultsperRoom;
	@FindBy (xpath = "//*[@name='child_room']") private WebElement ChildrenperRoom;
	@FindBy (xpath = "(//input[@class='reg_button'])[1]") private WebElement SearchBtn;
	@FindBy (xpath = "//input[@id='radiobutton_0']") private WebElement RadioBtn;
	@FindBy (xpath = "//input[@id='continue']") private WebElement Continue;
	
	public Adactin_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String GetUsername() 
	{
		String Name = getUser.getAttribute("value");
		String[] ALL = Name.split(" ");
		String ExpectedUS = ALL[1];
		return ExpectedUS;
		
	}
	
	public String GetTitle(WebDriver driver) 
	{
		String Actual = driver.getTitle();
		return Actual;
	}
	
	public void ClickOnLogoutButton() 
	{
		Logout.click();
		
	}
	
	public void ClickOnLoginAgain() 
	{
		AgainLogin.click();
		
	}
	
	public void SelectLocation(String Loc) 
	{
		Select S = new Select(Location);
		S.selectByVisibleText(Loc);
	}
	public void SelectHotels(String Hot) 
	{

		Select S = new Select(Hotels);
		S.selectByVisibleText(Hot);
	}
	public void SelectRoomtype(String RT) 
	{
		Select S = new Select(RoomType);
		S.selectByVisibleText(RT);
		
	}
	public void SelectNumberofRooms(String RNum) 
	{
		Select S = new Select(NumberofRooms);
		S.selectByVisibleText(RNum);
	}
	
	public void EnterCheckInDate(String CID) 
	{
		CheckInDate.sendKeys(CID);
	}
	public void EnterCheckOutDate(String COD) 
	{
		CheckOutDate.sendKeys(COD);
	
	}
	public void SelectAdultsperRoom(String Adultrooms) 
	{
		Select S = new Select(AdultsperRoom);
		S.selectByVisibleText(Adultrooms);
	}
	public void ChildrenperRoom(String Children) 
	{
		Select S = new Select(ChildrenperRoom);
		S.selectByVisibleText(Children);
	}
	public void ClickSearch() 
	{
		SearchBtn.click();
		
	}
	public void ClickRadioBtn() 
	{
		RadioBtn.click();
		
	}
	public void ClickContinue() 
	{
		Continue.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
