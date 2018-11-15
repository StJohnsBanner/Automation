

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestUtility {
	
	
	

		

		private static int waitTimeLimit = 120;	// Set wait time to detect element. **Increase time if test fails due to wait.**
		private static int implicitlyWait = 120;
		private static int pageLoadTimeout = 120;
		private static int thinktimeSecond = 1; // Set think time to 1 sec
		
		
		/**
		 * Logs user into system
		 * @param username 	Test user's user name
		 * @param password 	Test user's password
		 */
		public static void Login(WebDriver driver, String username, String password) 
		{
			boolean present = false;

			//WebDriver driver = TestUtility.LaunchChromeBrowser();	
			driver.get("https://castest.stjohns.edu/cas-web/login?TARGET=https%3A%2F%2Fappnavtest.stjohns.edu%2FapplicationNavigator%2Fj_spring_cas_security_check");
			
			TestUtility.SendKeysElement(driver, By.id("username"),username);
			TestUtility.SendKeysElement(driver,By.id("password"), password);
			try {
			//TestUtility.ClickElement(driver, By.xpath("//*[@id=\'login\']/div[5]/input[4]"));
				TestUtility.ClickElement(driver, By.cssSelector("input[class='btn-submit']"));
			}
			catch(Exception e) {}
			
			
			
		   
		}
		
		/**
		 * Logs user into system
		 * @param formName 	Name of the form the user want to search
		 * @param password 	Test user's password
		 */
		public static void SearchForForm(WebDriver driver, String formName) 
		{
			

			TestUtility.SendKeysElement(driver, By.id("search-landing"), formName + Keys.ENTER);
			
		   
		}
		
		/**
		 * Finds an element in an I frame
		 * @param driver driver
		 * @param fieldName Name of field as shown on screen
		 */
		public static boolean CheckForFieldInIframeByName(WebDriver driver,String fieldName) 
		{
			try {
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				if( driver.findElement(By.xpath( "//*[contains(text(),'"+ fieldName+"')]")).getText() != null)
				{
				    	return true;
				} 
				else 
				{
				        return false;
				}
				}
			catch(WebDriverException e)
				{
					return false;
			}
			    
			
		}
		
			
		/**
		 *  switch to Banner iframe
		 * @param driver 	driver
		 */
		public static void SwitchToIframeBanner(WebDriver driver) 
		{
			driver.switchTo().frame("bannerHS");  

		}
		/**
		 *  switch to defalt frame
		 * @param driver 	driver
		 */
		public static void SwitchToIframeDefault(WebDriver driver) 
		{
			driver.switchTo().defaultContent(); 
		}
		/**
		 * kills the current webdriver
		 * @param driver   driver
		 */
		public static void CloseBrowser(WebDriver driver) 
		{
			
			driver.close();
			driver.quit();
		}
		
		
		
		/**
		 * Waits for element to exist and double click element
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of element to be clicked
		 * @throws InterruptedException 
		 */
		public static void DoubleClickElement(WebDriver driver, By xpath) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			new Actions(driver).doubleClick(driver.findElement(xpath)).perform();
			Sleep(thinktimeSecond);
		}
		
		/**
		 * Waits for element to exist and click element
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of element to be clicked
		 * @throws Exception 
		 */
		public static void ClickElement(WebDriver driver, By xpath) throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			WebElement element = driver.findElement(xpath);
			if( driver instanceof InternetExplorerDriver) {
				for (int i =0; i < 10; i++) {
					try {
						Sleep(1);
						element = driver.findElement(xpath);
						JavascriptExecutor js =(JavascriptExecutor)driver;
				        js.executeScript("window.scrollTo(0,"+element.getLocation().x+")");
				        
				        Sleep(1);
				        js.executeScript("arguments[0].click();", element);
				        i=10;
					} catch (Exception e) {
						if(i>=9) {
							throw new Exception("Element was not found: " + xpath.toString());
						}
					}
				}
			}
			else {
				element.click();
			}
//			new Actions(driver).moveToElement(driver.findElement(xpath)).click(driver.findElement(xpath)).perform();
			Sleep(thinktimeSecond);
		}
		
		/**
		 * Waits for element to exist and click element
		 * Function similar to ClickElement() but has a longer wait time for element to appear
		 * Used for clicking on element after transition to new page 
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of element to be clicked
		 * @throws Exception 
		 */
		public static void ClickElementLongWait(WebDriver driver, By xpath) throws Exception
		{
			WebDriverWait wait = new WebDriverWait(driver,120);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			WebElement element = driver.findElement(xpath);
			if( driver instanceof InternetExplorerDriver) {
				for (int i =0; i < 10; i++) {
					try {
						Sleep(4);
						element = driver.findElement(xpath);
						JavascriptExecutor js =(JavascriptExecutor)driver;
				        js.executeScript("window.scrollTo(0,"+element.getLocation().x+")");
				        Sleep(1);
				        js.executeScript("arguments[0].click();", element);
				        Sleep(1);
				        i=10; //break the loop if action is completed
					} catch (Exception e) {
						if(i>=9) {
							throw new Exception("Element was not found: " + xpath.toString());
						}
					}
				}
			}
			else {
				element.click();
			}
//			new Actions(driver).moveToElement(driver.findElement(xpath)).click(driver.findElement(xpath)).perform();
			Sleep(thinktimeSecond);
		}

		/**
		 * Waits for element to exist and right click on element
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of element to be clicked
		 */
		public static void RightClickElement(WebDriver driver, By xpath)
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			new Actions(driver).contextClick(driver.findElement(xpath)).perform();
			Sleep(thinktimeSecond);
		}
		public static void LaunchBrowser(WebDriver driver,int browserCode,String url)
		{
		
			//Log mLog = new Log("Reports\\BrowserUsed.html", "Test Scenario", "Test", true);
			//	S0601 - Campuses & Majors
			//	Step 1:  Access applyUC via the link:  https://applyucl.ucop.edu/applicant-redesign/login.htm
			switch(browserCode){
				case 0: driver = TestUtility.LaunchChromeBrowser(url); // Launch Browser
				//		mLog.writeInfo("Test Scenario started on Chrome browser");
						break;
				case 1: driver = TestUtility.LaunchFireFoxBrowser(); // Launch Browser
					//	mLog.writeInfo("Test Scenario started on FireFox browser");
						break;
				case 2: driver = TestUtility.LaunchIEBrowser(); // Launch Browser
						//mLog.writeInfo("Test Scenario started on Internet Explorer browser");
						break;
				default:driver = TestUtility.LaunchChromeBrowser(url); // Launch Browser
						//mLog.writeInfo("Test Scenario started on Chrome browser");
			}
		}
		/**
		 * Waits for element to exist and select item from dropbox
		 * @param driver	WebDriver of where element is located
		 * @param xpath		XPATH of droxbox element
		 * @param option	Option to select from dropbox
		 */
		public static void SelectDropboxElement(WebDriver driver, By xpath, String option)
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
			wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
			WebElement mySelectElement = driver.findElement(xpath);
			if( driver instanceof InternetExplorerDriver) {
				JavascriptExecutor js =(JavascriptExecutor)driver;
		        js.executeScript("window.scrollTo(0,"+mySelectElement.getLocation().x+")");
		        Sleep(1);
			}
			Select dropdown = new Select(mySelectElement);
			dropdown.selectByVisibleText(option);
			Sleep(thinktimeSecond);
		}
		
		/**
		 * Waits for element to exist and select item from dropbox by value
		 * @param driver	WebDriver of where element is located
		 * @param xpath		XPATH of droxbox element
		 * @param value		Value to select from dropbox
		 */
		public static void SelectDropboxElementByValue(WebDriver driver, By xpath, String value)
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
			wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
			WebElement mySelectElement = driver.findElement(xpath);
			if( driver instanceof InternetExplorerDriver) {
				JavascriptExecutor js =(JavascriptExecutor)driver;
		        js.executeScript("window.scrollTo(0,"+mySelectElement.getLocation().x+")");
		        Sleep(1);
			}
			Select dropdown = new Select(mySelectElement);
			dropdown.selectByValue(value);
			Sleep(thinktimeSecond);
		}
		
		/**
		 * Wait for element to appear and send keys. Element must be a textbox.
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of textbox element
		 * @param keys 		keys to input to textbox
		 */
		public static void SendKeysElement(WebDriver driver, By xpath, String keys)
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
//			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			WebElement element = driver.findElement(xpath);
			if(driver instanceof InternetExplorerDriver) {
				Sleep(1);
				JavascriptExecutor js =(JavascriptExecutor)driver;
		        js.executeScript("window.scrollTo(0,"+element.getLocation().x+")");
		        Sleep(1);
		        js.executeScript("arguments[0].value = arguments[1]; ", element, keys);  
		        Sleep(1);
			}
//			else if(driver instanceof FirefoxDriver) {
//				JavascriptExecutor js =(JavascriptExecutor)driver;
//				js.executeScript("arguments[0].removeAttribute('readonly','readonly')",element); 
//				element.click();
//		        element.clear();
//		        element.sendKeys(keys);
//			}
			else {
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("arguments[0].removeAttribute('readonly','readonly')",element); 
				element.click();
		        element.clear();
		        element.sendKeys(keys);
			}

			Sleep(thinktimeSecond);
		}
		
		/**
		 * Wait for element to appear and send keys. Element does not have to be a textbox, but it must accept text input.
		 * @param driver 	WebDriver of where element is located
		 * @param xpath 	XPATH of textbox element
		 * @param keys 		keys to input to textbox
		 */
		public static void SendKeysElement2(WebDriver driver, By xpath, String keys)
		{
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			WebElement element = driver.findElement(xpath);
			if(driver instanceof InternetExplorerDriver) {
				JavascriptExecutor js =(JavascriptExecutor)driver;
		        js.executeScript("window.scrollTo(0,"+element.getLocation().x+")");
		        Sleep(1);
		        element.click();
		        element.clear();
		        element.sendKeys(keys);
		        Sleep(1);
			}

			else {
				JavascriptExecutor js =(JavascriptExecutor)driver;
				js.executeScript("arguments[0].removeAttribute('readonly','readonly')",element); 
				element.click();
		        element.clear();
		        element.sendKeys(keys);
			}
			Sleep(thinktimeSecond);
		}
		public static void Sleep(int sec) {
			try {
				Thread.sleep(sec*1000);
			} catch (Exception e) {/* Do nothing */}
		};
		
		/**
		 * Launch Chrome browser and navigate to URL
		 */
		public static WebDriver LaunchChromeBrowser(String url)
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			 
			// Initialize browser
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
			//driver.get(url);
			
			// Maximize browser
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		
		/**
		 * Launch Chrome browser and navigate to URL
		 */
		public static WebDriver LaunchChromeBrowser()
		{
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			 
			// Initialize browser
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
			//driver.get(url);
			
			// Maximize browser
			driver.manage().window().maximize();
			//driver.get(url);
			return driver;
		}
		
		/**
		 * Launch Firefox browser and navigate to URL
		 */
		public static WebDriver LaunchFireFoxBrowser()
		{
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			 
			// Initialize browser
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
//			driver.get(url);
			
			// Maximize browser
			driver.manage().window().maximize();
			
			return driver;
		}
		
		/**
		 * Launch Internet Explorer browser and navigate to URL
		 */
		public static WebDriver LaunchIEBrowser()
		{
			System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
//			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//			caps.setCapability("nativeEvents", false);
//			caps.setCapability("unexpectedAlertBehaviour", "accept");
//			caps.setCapability("ignoreProtectedModeSettings", true);
//			caps.setCapability("disable-popup-blocking", true);
//			caps.setCapability("enablePersistentHover", true);
//			caps.setCapability("ignoreZoomSetting", true);
			// Initialize browser
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
//			driver.get(url);
			
			// Maximize browser
			driver.manage().window().maximize();
			
			return driver;
		}
		
		/**
		 * Convert integer to alphabet
		 * @param i		integer to convert
		 * @return		alphabet equivalent
		 */
		public static String toAlphabetic(int i) {
		    if( i<0 ) {
		        return "-"+toAlphabetic(-i-1);
		    }

		    int quot = i/26;
		    int rem = i%26;
		    char letter = (char)((int)'A' + rem);
		    if( quot == 0 ) {
		        return ""+letter;
		    } else {
		        return toAlphabetic(quot-1) + letter;
		    }
		}
		
		/**
		 * Convert date to character
		 * @param date		date to convert
		 * @return			converted date
		 */
		public static String convertDatetoChar(String date) 
		{
			
			String dateCode = "";
			int [] dateSplit = { 	Integer.parseInt(date.substring(0, 2)),
									Integer.parseInt(date.substring(2, 4)),
									Integer.parseInt(date.substring(4, 6)),
									Integer.parseInt(date.substring(6, 8)),
									Integer.parseInt(date.substring(8, 10)),
									Integer.parseInt(date.substring(10,12)),
									Integer.parseInt(date.substring(12))
									};
			for (int i = 0; i < dateSplit.length; i++) {
				dateCode += toAlphabetic(dateSplit[i]);
			}
			return dateCode;
		}
		
		/**
		 * Clock test and log results into report
		 * @param pageName			Title of page
		 * @param startPageTime		start time of page execution
		 * @param mLog				Log file for report
		 */
	/*		public static void clockPage(String pageName, long startPageTime, Log mLog, WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver,waitTimeLimit);
//			wait.until(new ExpectedCondition<Boolean>() {
//		        public Boolean apply(WebDriver wdriver) {
//		            return ((JavascriptExecutor) driver).executeScript(
//		                "return document.readyState"
//		            ).equals("complete");
//		        }
//		    });
			try {
			wait.until(
			          webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
			}catch(Exception e) {}
			float totalPageTime = (System.currentTimeMillis()-startPageTime)/(1000F); // Stop clock for page
			mLog.writeInfo(pageName + " - Time Elapsed to go to Page: "+ Float.toString(totalPageTime) +" Seconds");
		};
		*/

	}


