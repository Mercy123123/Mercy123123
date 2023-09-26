package Module1_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.Adactin_BaseClass;
import Library_Files.Adactin_UtilityClass;
import Module1.Adactin_HomePage;
import Module1.Adactin_Login;

public class Adactin_TestClass extends Adactin_BaseClass
{
	Adactin_Login Login;
	Adactin_HomePage HomePage;
	
	String TCID;									//For Taking ScreenShot if FAILS all the Test case
	
	@BeforeClass
	public void OpenApp() 
	{
		InitializeBrowser();
		
		//Create Object of POM - 1
		Login = new Adactin_Login(driver);
		
		//Create Object of POM - 2
		HomePage = new Adactin_HomePage(driver);
		
		
	}
	
	@BeforeMethod
	public void LoginApp() throws IOException 
	{
		Login.EnterUsername(Adactin_UtilityClass.GetDataFromPropFile("Username"));			//Adactin_UtilityClass.GetDataFromPropFile("Username") = Mahesh599
		Login.EnterPassword(Adactin_UtilityClass.GetDataFromPropFile("Password"));			//Adactin_UtilityClass.GetDataFromPropFile("Password") = Mahesh@599
		Login.ClickOnLoginButton();
		
	}
	@Test(priority = 1)
	public void VerifyUsername() throws EncryptedDocumentException, IOException 
	{	TCID="TC01";
		String ActualUsername = HomePage.GetUsername();
		String ExpectedUsername = Adactin_UtilityClass.GetDataFromExcel(2, 0); 
		Assert.assertEquals(ActualUsername, ExpectedUsername);
		
	}
	
	@Test (priority = 2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException 
	{	TCID="TC02";
		String ActualTitle = HomePage.GetTitle(driver);
		String ExpectedTitle = Adactin_UtilityClass.GetDataFromExcel(4, 0);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	
	}
	
	@Test (priority = 3)
	public void BookAHotel() throws EncryptedDocumentException, IOException 
	{
		HomePage.SelectLocation(Adactin_UtilityClass.GetDataFromExcel(6, 0));
		HomePage.SelectHotels(Adactin_UtilityClass.GetDataFromExcel(7, 0));
		HomePage.SelectRoomtype(Adactin_UtilityClass.GetDataFromExcel(8, 0));
		HomePage.SelectNumberofRooms(Adactin_UtilityClass.GetDataFromExcel(9, 0));
		HomePage.EnterCheckInDate(Adactin_UtilityClass.GetDataFromExcel(10, 0));
		HomePage.EnterCheckOutDate(Adactin_UtilityClass.GetDataFromExcel(11, 0));
		HomePage.SelectAdultsperRoom(Adactin_UtilityClass.GetDataFromExcel(12, 0));
		HomePage.ChildrenperRoom(Adactin_UtilityClass.GetDataFromExcel(13, 0));
		HomePage.ClickSearch();
		HomePage.ClickRadioBtn();
		HomePage.ClickContinue();
		
	}
	@AfterMethod
	public void LogoutAppandclickLoginAgain(ITestResult results) throws IOException
	{
		if(results.getStatus()==results.FAILURE) 
		{
			Adactin_UtilityClass.TakeScreenshot(driver, TCID);
		}
		HomePage.ClickOnLogoutButton();
		HomePage.ClickOnLoginAgain();
		
		
	}
	@AfterClass
	public void CloseBrowser() 
	{
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	

}
