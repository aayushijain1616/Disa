package DisaModule;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class initiateDisa 
{
	
			 String driverPath = "Z:\\Softwares\\chromedriver_win32\\";
			 public static WebDriver driver = null;
			 String disaURL = "http://del1-vm-disa5:9001";
			
			 
			 
			@BeforeSuite
			public void setUpBrowser() 
			{
				System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
				System.out.println(driverPath+"chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(disaURL);
			}
			
			
			@Test
			 public void startDisa() throws Exception 
			 {
				System.out.println("--------------------- Starting DISA Framework in chrome browser------------------------");
				 disaFunctionality df = new disaFunctionality();
				boolean result = df.disaLogin();
				System.out.println("The final result is: "+result);
			 }

			
			@AfterSuite
			public void closingBrowser() throws Exception 
			{
				
				if(driver!=null) 
				{
					System.out.println("Closing chrome browser");
					Thread.sleep(5000);
					driver.quit();
				}
			}

	}
