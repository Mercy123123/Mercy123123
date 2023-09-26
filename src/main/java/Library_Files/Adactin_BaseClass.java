package Library_Files;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adactin_BaseClass {
	
	public WebDriver driver;
	
	public void InitializeBrowser() 
	{
		driver = new ChromeDriver();
		
		driver.get("http://adactinhotelapp.com/index.php");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
