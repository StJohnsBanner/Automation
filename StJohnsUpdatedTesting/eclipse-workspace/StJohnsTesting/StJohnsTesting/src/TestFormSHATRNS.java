import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class TestFormSHATRNS {

	@Test
	//TEST THE FORM FOR SHATRNS
	void test() {
		String username = "kanyank";
		String password = "temp1234";
		String formName = "shatrns";
		String field1 = "ID";
		String field2 = "Transfer Institution Number";
		String field3 = "Attendance Period Number";
		String field4 = "Go";
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
		  
		//Checks for Transfer Institution Number field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present"); 
			passcount++;
		} 
		else
		{
			System.out.println(field2+" is not present");
		}
		//Checks for  Attendance Period Number field
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{ 	
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
		   	System.out.println(field3+" is not present");
		}
		//Checks for Go Button
		if(TestUtility.CheckForFieldInIframeByName(driver, field4)==true) 
		{ 	
			System.out.println(field4 +" is present");
			passcount++;
		}
		else
		{
		   	System.out.println(field4+" is not present");
		} 

		//check the count of all present fields
		if(passcount == 4)
		{
			System.out.println("All of the fields are present");
			passcount++;
		}
		else
		{
			System.out.println(passcount + " Out of 4 Fields are present");
		}
					  
		//Close Driver
		 TestUtility.CloseBrowser(driver);
				 
		
		
	}

}
