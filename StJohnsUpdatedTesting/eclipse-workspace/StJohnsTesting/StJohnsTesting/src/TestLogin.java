import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class TestLogin {

	@Test
	//Test if a user can successfully can login
	void test() {
		
		String username = "kanyank";
		String password = "temp1234";
		String field = "Welcome";
		
		
		//creates webDriver
		WebDriver driver = TestUtility.LaunchChromeBrowser();
		System.out.println("Running Test for Login...");
		//Logs user into system using username and password
		TestUtility.Login(driver,username, password);  
		//check to see if welcome page is showing for user
		
		//Ends current driver
		TestUtility.CloseBrowser(driver);

}}
