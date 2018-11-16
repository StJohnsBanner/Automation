import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestFormSZVDEPT {

	@Test
	void test() {
		String username = "kanyank";
		String password = "temp1234";
		String formName = "szvdept";
		String field1 = "Code";
		String field2 = "Description";
		String field3 = "System Req";
		String field4 = "VR Msg No";
		String field5 = "Web Description";
		String field6 = "Save";
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
		//Checks for Code field  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{ 	
		   	System.out.println(field1+" is present");
		   	passcount++;
		}
		else
		{
		    System.out.println(field1+" is not present");
		}
		  
		//Checks for Description field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present"); 
			passcount++;
		} 
		else
		{
			System.out.println(field2+" is not present");
		}
		//Checks for  system req
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{ 	
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
		   	System.out.println(field3+" is not present");
		}
		//Checks for VR MSG No field
		if(TestUtility.CheckForFieldInIframeByName(driver, field4)==true) 
		{ 	
		    System.out.println(field4+" is present");
		    passcount++;
		}
		else
		{
	    	System.out.println(field4+" is not present");
	    }
			  
		//Checks for  Web Description field
		if(TestUtility.CheckForFieldInIframeByName(driver, field5)==true) 
		{ 	
		    System.out.println(field5 +" is present");   
		    passcount++;
		}
		else
		{
		   	System.out.println(field5+" is not present");
		}
		//Checks for Save Button
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
