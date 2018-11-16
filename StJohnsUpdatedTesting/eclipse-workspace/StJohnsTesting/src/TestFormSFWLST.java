import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestFormSFWLST {

	@Test
	void test() {
		String username = "kanyank";
		String password = "temp1234";
		String formName = "sfwslst";
		String field1 = "Term";
		String field2 = "CRN";
		String field3 = "Roll";
		String field4 = "Degree Award Status";
		String field5 = "Go";
		
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
		driver.switchTo().frame("bannerHS");  
		//Checks for Term field  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{ 	
		   	System.out.println(field1+" is present");
		   	passcount++;
		}
		else
		{
		    System.out.println(field1+" is not present");
		}
		  
		//Checks for Copy from User ID field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present"); 
			passcount++;
		} 
		else
		{
			System.out.println(field2+" is not present");
		}
		//Checks for  Include COA Code field
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{ 	
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
		   	System.out.println(field3+" is not present");
		}
		//Checks for Exclude COA Code field
		if(TestUtility.CheckForFieldInIframeByName(driver, field4)==true) 
		{ 	
		    System.out.println(field4+" is present");
		    passcount++;
		}
		else
		{
	    	System.out.println(field4+" is not present");
	    }
			  
	
		//Checks for Go Button
		if(TestUtility.CheckForFieldInIframeByName(driver, field5)==true) 
		{ 	
		 	System.out.println(field5+" is present");
		 	passcount++;
		}
		else
		{
			System.out.println(field5+" is not present");
		}
		//check the count of all present fields
		if(passcount == 5)
		{
			System.out.println("All of the fields are present");
			
		}
		else
		{
			System.out.println(passcount + " Out of 7 Fields are present");
		}
			  
		//Close Driver
		TestUtility.CloseBrowser(driver);
	}
}
