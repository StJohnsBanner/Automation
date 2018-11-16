import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestFormSWAAFFL {

	@Test
	void test() {

		String username = "kanyank";
		String password = "temp1234";
		String formName = "swaaffl";
		String field1 = "ID";
		String field2 = "Go";
		int passcount = 0;
			
		//creates webDriver
		WebDriver driver = TestUtility.LaunchChromeBrowser();
		System.out.println("Running Test:" + formName);
		System.out.println("________________________");
		//Logs user into system using username and password
		TestUtility.Login(driver,username, password);
		//Search for form
		TestUtility.SearchForForm(driver, formName);
		//check to make sure all fields of the form are present
		//switch to banner iframe
		driver.switchTo().frame("bannerHS");  
		//Checks for ID field  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{ 	
		   	System.out.println(field1+" is present");
		   	passcount++;
		}
		else
		{
		    System.out.println(field1+" is not present");
		}
		  
		//Checks for GO Button
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present"); 
			passcount++;
		} 
		else
		{
			System.out.println(field2+" is not present");
		}
	
		
		
		//check the count of all present fields
		if(passcount == 2)
		{
			System.out.println("All of the fields are present");
			passcount++;
		}
		else
		{
			System.out.println(passcount + " Out of 2S Fields are present");
		}
					  
		//Close Driver
		 TestUtility.CloseBrowser(driver);
	}

}
