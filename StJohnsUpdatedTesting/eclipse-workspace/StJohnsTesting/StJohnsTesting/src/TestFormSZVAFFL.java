import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestFormSZVAFFL {

	@Test
	void test() {
		String username = "kanyank";
		String password = "temp1234";
		String formName = "szvaffl";
		String field1 = "Affl Code";
		String field2 = "Affl Desc";
		String field3 = "Park";
		String field4 = "Deactivation Date";
		String field5 = "Activity Date";
		String field6 = "Go";
		int passcount = 0;
		int totalFields = 6;
		
		
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
		//Checks forAffl Code field  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{ 	
		   	System.out.println(field1+" is present");
		   	passcount++;
		}
		else
		{
		    System.out.println(field1+" is not present");
		}
		  
		//Checks for Affl Desc field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present"); 
			passcount++;
		} 
		else
		{
			System.out.println(field2+" is not present");
		}
		//Checks for  Park field
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{ 	
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
		   	System.out.println(field3+" is not present");
		}
		//Checks for Deactivation Date field
		if(TestUtility.CheckForFieldInIframeByName(driver, field4)==true) 
		{ 	
		    System.out.println(field4+" is present");
		    passcount++;
		}
		else
		{
	    	System.out.println(field4+" is not present");
	    }
			  
		//Checks for  Activity Date field
		if(TestUtility.CheckForFieldInIframeByName(driver, field5)==true) 
		{ 	
		    System.out.println(field5 +" is present");   
		    passcount++;
		}
		else
		{
		   	System.out.println(field5+" is not present");
		}
		//Checks for Go Button
		if(TestUtility.CheckForFieldInIframeByName(driver, field6)==true) 
		{ 	
		 	System.out.println(field6+" is present");
		 	passcount++;
		}
		else
		{
			System.out.println(field6+" is not present");
		}
		//check total fields present
		if(passcount == totalFields)
		{
			System.out.println("All of the fields are present");
			
		}
		else
		{
			System.out.println(passcount + " Out of" +totalFields+ " Fields are present");
		}
			  
		//Close Driver
		TestUtility.CloseBrowser(driver);
				 
		
		
	}

}
