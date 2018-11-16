import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

class TestFormFWMUSFN {

	@Test
	//Test if all fields for form fwmusfn are present
	void test() {

		String username = "kanyank";
		String password = "temp1234";
		String formName = "fwmusfn";
		String field1 = "User ID";
		String field2 = "Copy from User ID";
		String field3 = "Include COA Code";
		String field4 = "Include Fund Type";
		String field5 = "Include Fund";
		String field6 = "Exclude Fund Type";
		String field7 = "Exclude Fund";
		String field8 = "Exclude COA Code";
		String field9 = "Go";
		int passcount = 0;
		
		
	/*	ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\kanyank\\Desktop\\ExtentReports");
		
        // Create object of ExtentReports class- This is main class which will create report
		ExtentReports extent = new ExtentReports();
    
        // attach the reporter which we created in Step 1
		extent.attachReporter(reporter);
    
        // call createTest method and pass the name of TestCase
		ExtentTest logger=extent.createTest("LoginTest");
    
        // log method will add logs in report and provide the log steps which will come in report
		logger.log(Status.INFO, "Test1");
   
		logger.log(Status.PASS, "Test2");
		extent.flush();
   
		//ExtentTest test = reports.createTest("TestFormFWMUSFN");
	*/	
		//creates webDriver
		WebDriver driver = TestUtility.LaunchChromeBrowser();
		System.out.println("Running Test:" + formName);
		System.out.println("________________________");
		//Logs user into system using username and password
		
		TestUtility.Login(driver,username, password);
		//Search for form
		TestUtility.SearchForForm(driver, formName);
		//switch to  Iframe Banner
		TestUtility.SwitchToIframeBanner(driver);
		//check to make sure all fields of the form are present
		
		//Checks for user User ID field		  
		if(TestUtility.CheckForFieldInIframeByName(driver, field1)==true) 
		{
			System.out.println(field1 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field1+" is not present");
			
		}
		  
		//Checks for user Copy from User ID field
		if(TestUtility.CheckForFieldInIframeByName(driver, field2)==true) 
		{
			System.out.println(field2 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field2+" is not present");
		}
			 
		//Checks for user Include COA Code field
		if(TestUtility.CheckForFieldInIframeByName(driver, field3)==true) 
		{
			System.out.println(field3 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field3+" is not present");
		}
		//Checks for Include Fund Type field
		if(TestUtility.CheckForFieldInIframeByName(driver, field4)==true) 
		{
			System.out.println(field4 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field4+" is not present");
		}
		//Checks for Include Fund field
		if(TestUtility.CheckForFieldInIframeByName(driver, field5)==true) 
		{
			System.out.println(field5 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field5+" is not present");
		}
		//Checks for Exclude Fund Type field
		if(TestUtility.CheckForFieldInIframeByName(driver, field6)==true) 
		{
			System.out.println(field6 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field6+" is not present");
		}
		//Checks for Exclude Fund field
		if(TestUtility.CheckForFieldInIframeByName(driver, field7)==true) 
		{
			System.out.println(field7 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field7+" is not present");
		}
		//Checks for Exclude COA Code field
		if(TestUtility.CheckForFieldInIframeByName(driver, field8)==true) 
		{
			System.out.println(field8 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field8+" is not present");
		}
		//Checks for Exclude Go Button
		if(TestUtility.CheckForFieldInIframeByName(driver, field9)==true) 
		{
			System.out.println(field9 +" is present");
			passcount++;
		}
		else
		{
			System.out.println(field9+" is not present");
		}
		//Test if every scenario passed
		if(passcount == 9)
		{
			System.out.println("All of the fields are present");
		}
		else
		{
			System.out.println(passcount + " Out of 6 Fields are present");
		}
		//close Iframe
		TestUtility.SwitchToIframeDefault(driver);
		//kill the current browser
		TestUtility.CloseBrowser(driver);
		
		
	}

}
