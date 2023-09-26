package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Adactin_UtilityClass {
	//Name : Mahesh
	//Date : 15/9/23
	//Day  : Friday
	//Fetch data from property file
	
	@Test
	public static String GetDataFromPropFile(String Key) throws IOException 
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\LR\\eclipse-workspace\\15th_April_A_Selenium\\PropertyFile_Cred.properties");
		
		Properties prop = new Properties();
		
		prop.load(file);
	
		String value = prop.getProperty(Key);
		return value;
		
	}
	
		//Name : Mahesh
		//Date : 15/9/23
		//Day  : Friday
		//Fetch data from Excel file
	@Test
	public static String GetDataFromExcel(int RowIndex, int ColumnIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("E:\\Class and RTO\\Class work\\Selenium\\Parameterization.xlsx");
		String ExpectedUsername = WorkbookFactory.create(file).getSheet("Sheet12").getRow(RowIndex).getCell(ColumnIndex).getStringCellValue();
		
		return ExpectedUsername;
	}
	
	
		//Name : Mahesh
		//Date : 15/9/23
		//Day  : Friday
		//to Get the ScreenShot
	@Test
	public static void TakeScreenshot(WebDriver driver, String TCID) throws IOException 
	{
		File S = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File D = new File("E:\\Class and RTO\\Class work\\Screenshot\\"+TCID+".png");
		FileHandler.copy(S, D);
		
	}
	
	
	
	
	
	
	

}
