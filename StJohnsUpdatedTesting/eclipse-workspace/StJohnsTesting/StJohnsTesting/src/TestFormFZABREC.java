import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class TestFormFZABREC {

	@Test
	void test() {

		String username = "kanyank";
		String password = "temp1234";
		String formName = "fzabrec";
		String field1 = "Bank";
		String field2 = "Bank Account Number";
		String field3 = "Cash Account Number";
		String field4 = "Status Selection";
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
		//Checks for Bank field
		driver.switchTo().frame("bannerHS");  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{
			System.out.println("User Id feld is present");
			passcount++;
		}
		else
		{	
			System.out.println("User Id field is not present");
		}
		  
		//Checks for Bank Account Number field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{ 	
			System.out.println(field2 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field2+" is not present");
		}
		//Checks for Cash Account Number field
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field3+" is not present");
		}
		//Checks for Status Selection field
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
		if(passcount == 5)
		{
			System.out.println("All of the fields are present");
		}
		else
		{
			System.out.println(passcount + " Out of 5 Fields are present");
		}
		 //Close Driver
		 TestUtility.CloseBrowser(driver);
				 
		
		
	}

}
