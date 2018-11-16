import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class TestDataEntryForGZAEMAL {

	@Test
	void test() {
		String username = "kanyank";
		String password = "temp1234";
		String formName = "gzaemal";
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
		//switches to banner iframe
		driver.switchTo().frame("bannerHS");  
		//enters user id  
		TestUtility.SendKeysElement(driver, By.id("inp:id"),"X02175849");
		//go to search
		try {
		TestUtility.ClickElement(driver,By.xpath(TestUtility.XpathText("Go")));
		
		}
		catch(Exception e)
		{}
		//change to email tab
		try
		{
			TestUtility.ClickElement(driver,By.xpath(TestUtility.XpathText("System Maintained E-mail")));
		}
		catch(Exception e)
		{}
		
		//check to see if preferred check box is read only
		WebElement element = driver.findElement(By.xpath("//*[@id='EMAIL_goremalPreferredInd_0']"));
		if("ui-widget ui-checkbox ui-state-readonly mode-read".equals(element.getAttribute("class"))) {
		  System.out.println("Element is Read Only");
		} else {
			  System.out.println("Element is not Read only");
		}
		System.out.println(element.getAttribute("class"));
		
		//check to see if preferred check box is read only
				WebElement element2 = driver.findElement(By.xpath("//*[@id='EMAIL_goremalStatusInd_0']"));
				if("ui-widget ui-checkbox ui-state-readonly mode-read".equals(element2.getAttribute("class"))) {
				  System.out.println("Element is Read Only");
				} else {
					  System.out.println("Element is not Read only");
				}
				System.out.println(element2.getAttribute("class"));
				//Close Driver
				//TestUtility.CloseBrowser(driver);
		
	}

}
